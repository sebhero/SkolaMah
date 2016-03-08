/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package p2.view;

import p2.model.roffe.Place;
import p2.model.roffe.Position;
import p2.model.roffe.Road;
import p2.presenter.P2Presenter;
import p2.shared.SEARCHTYPE;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * A View implemenation of MainView interface
 * Is a Gui representation of the P2 app.
 * @author Sebastian Börebäck on 2016-03-08.
 */
public class MainViewImpl extends JFrame implements MainView {

	private SEARCHTYPE searchAlgorithm;
	private P2Presenter ctrl;
	private MapView map;
	private JComboBox cmbFrom;
	private JComboBox cmbTo;
	private JTextArea teMapPath;

	/***
	 * Constructs the view implementation.
	 * Using the image path, upp left cords, lower right cords
	 * @param imgPath the image file path
	 * @param mapLeftUp the upper left cords
	 * @param mapRightDown the lower right cords
	 * @throws FileNotFoundException throws file not found if the image file is not found
	 */
	public MainViewImpl(String imgPath, Position mapLeftUp, Position mapRightDown) throws FileNotFoundException {
		initComponents(imgPath, mapLeftUp, mapRightDown);
	}

	/**
	 * Initializes the view components.
	 * MapView need the imgPath and the cords to be initialized.
	 * @param imgPath      the image of the map
	 * @param mapLeftUp    upper left cords
	 * @param mapRightDown lower right cords
	 */
	private void initComponents(String imgPath, Position mapLeftUp, Position mapRightDown) throws FileNotFoundException {
		this.setTitle("P2 Karta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		map = null;

		//Check for file not found exception of the Image file.
		try {
			//init map
			//convert relative path to real path
			String imgFile = this.getClass().getResource("/" + imgPath).getPath();
			map = new MapView(imgFile, mapLeftUp.getLongitude(), mapLeftUp.getLatitude(), mapRightDown.getLongitude(), mapRightDown.getLatitude());
		} catch (Exception e) {
			throw new FileNotFoundException("Couldnt load Image file: " + imgPath + "\n");
		}


		this.setLayout(new BorderLayout());
		//create main panels
		JPanel buttonsPanel = new JPanel(new BorderLayout());
		JTabbedPane mainTabbedPanel = new JTabbedPane();

		//create buttons
		cmbFrom = new JComboBox();
		cmbTo = new JComboBox();

		JRadioButton rdBtnDijkstra = new JRadioButton("Dijkstra");
		JRadioButton rdBtnBreadth = new JRadioButton("Sökning på bredden");
		JRadioButton rdBtnDepth = new JRadioButton("Sökning på djupet");
		JButton btnSearch = new JButton("Sök");

		JLabel lbFrom = new JLabel("Från");
		JLabel lbTo = new JLabel("Till");
		lbFrom.setBorder(new EmptyBorder(0, 20, 0, 10));
		lbTo.setBorder(new EmptyBorder(0, 20, 0, 10));


		ButtonGroup btnGrp = new ButtonGroup();
		btnGrp.add(rdBtnBreadth);
		btnGrp.add(rdBtnDepth);
		btnGrp.add(rdBtnDijkstra);

		//split the buttons panel to 3 panels
		JPanel buttonsP1 = new JPanel(new BorderLayout());
		JPanel buttonsP1a = new JPanel(new GridLayout(2, 1));
		JPanel buttonsP1b = new JPanel(new GridLayout(2, 1));

		//Label panel add labels
		buttonsP1a.add(lbFrom);
		buttonsP1a.add(lbTo);

		//Combo panel add combos
		buttonsP1b.add(cmbFrom);
		buttonsP1b.add(cmbTo);

		//add label and combo panels to buttons 1 panel
		buttonsP1.add(buttonsP1a, BorderLayout.WEST);
		buttonsP1.add(buttonsP1b, BorderLayout.CENTER);

		//radio buttons panel
		JPanel buttonsP2 = new JPanel(new GridLayout(3, 1));
		buttonsP2.add(rdBtnBreadth);
		buttonsP2.add(rdBtnDepth);
		buttonsP2.add(rdBtnDijkstra);

		//Panel put label,combo and radio together and search button
		buttonsPanel.add(buttonsP1, BorderLayout.CENTER);
		buttonsPanel.add(buttonsP2, BorderLayout.EAST);
		buttonsPanel.add(btnSearch, BorderLayout.SOUTH);

		//TABS
		JPanel mapTab = new JPanel(new BorderLayout());

		JPanel textTab = new JPanel(new BorderLayout());
		teMapPath = new JTextArea();
		//add scrollbar
		JScrollPane sp = new JScrollPane(teMapPath);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		mapTab.add(map);
		textTab.add(sp);

		//add tabs to tabs panel
		mainTabbedPanel.addTab("Karta", mapTab);
		mainTabbedPanel.add("Text", textTab);


		//Add tabs and buttons panel
		this.add(mainTabbedPanel, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);

		rdBtnDijkstra.setSelected(true);
		this.searchAlgorithm = SEARCHTYPE.DIJKSTRA;

		//init buttons
		initButtons(btnSearch, rdBtnDijkstra, rdBtnBreadth, rdBtnDepth);

		pack();


	}

	private void initButtons(JButton btnSearch, JRadioButton rdBtnDijkstra, JRadioButton rdBtnBreadth, JRadioButton rdBtnDepth) {
		//add actionlistner to the search button and call search from controller
		/***
		 * Same as
		 btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.search()
			}
			});
		 */
		btnSearch.addActionListener(ae -> ctrl.search());

		/**
		 * Init the radiobuttons. so when a radiobuton is selected there is a action
		    Same as:
		    rdBtnBreadth.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					setSearchAlgorithm(SEARCHTYPE.BREADTH);
				}
			});
		 */

		rdBtnDijkstra.addActionListener(ae -> setSearchAlgorithm(SEARCHTYPE.DIJKSTRA));
		rdBtnBreadth.addActionListener(ae -> setSearchAlgorithm(SEARCHTYPE.BREADTH));
		rdBtnDepth.addActionListener(ae -> setSearchAlgorithm(SEARCHTYPE.DEPTH));
	}

	/**
	 * Connect the presenter to the view
	 * @param ctrl the presenter (P2Controller)
	 */
	@Override
	public void setPresenter(P2Presenter ctrl) {
		this.ctrl = ctrl;
	}

	/**
	* Update the view from the model
	*/
	@Override
	public void updateViewFromModel() {
		//test
		ArrayList<Road> roads = ctrl.getModel().getFoundRoads();
		map.showRoads(roads);
		//clear the textarea
		teMapPath.setText("");
		//for loop to add each road in roads to textarea teMapPath
		/**
			 for (Road road : roads) {
			 teMapPath.append(road.toString()+"\n")
			 }
		 */

		roads.forEach(road -> teMapPath.append(road.toString()+"\n"));
	}

	/**
	 * Start/show the view
	 */
	@Override
	public void open() {
		setVisible(true);
	}

	/**
	 * Close the view
	 */
	@Override
	public void close() {
		this.dispose();

	}

	/**
	 * Update the model from the view
	 */
	@Override
	public void updateModelFromView() {
		String from = cmbFrom.getSelectedItem().toString();
		String to = cmbTo.getSelectedItem().toString();
		ctrl.getModel().setFrom(from);
		ctrl.getModel().setTo(to);
		ctrl.getModel().setSearchAlgorithm(this.getSearchAlgorithm());
	}

	/**
	 * Set the places used by the comboboxes
	 * @param places the list of places
	 */
	@Override
	public void setPlaces(Place[] places) {
		//fills the comboboxes with the ArrayList
		cmbFrom.setModel(new DefaultComboBoxModel<Place>(ctrl.getModel().getPlaces()));
		cmbTo.setModel(new DefaultComboBoxModel<Place>(ctrl.getModel().getPlaces()));
	}

	private SEARCHTYPE getSearchAlgorithm() {
		return searchAlgorithm;
	}

	private void setSearchAlgorithm(SEARCHTYPE searchAlgorithm) {
		this.searchAlgorithm = searchAlgorithm;
	}


}
