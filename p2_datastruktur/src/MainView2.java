/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;


/****
 * Main view for displaying the map etc.
 * @author Sebastian Börebäck
 */
public class MainView2 extends JPanel {

	private final P2Controller ctrl;
	private SEARCHTYPE searchAlgorithm;
	private JRadioButton rdBtnDijkstra;
	private JRadioButton rdBtnBreadth;
	private JRadioButton rdBtnDepth;
	private JComboBox cmbFrom;
	private JComboBox cmbTo;
	private JButton btnSearch;
	private final MapView mapView;
	private JTextArea teMapPath;


	/***
	 * Draws the gui
	 */
	private void initGUI() {
		this.setLayout(new BorderLayout());
		//create main panels
		JPanel buttonsPanel = new JPanel(new BorderLayout());
		JTabbedPane mainTabbedPanel = new JTabbedPane();

		//create buttons
		cmbFrom = new JComboBox();
		cmbTo = new JComboBox();

		rdBtnDijkstra = new JRadioButton("Dijkstra");
		rdBtnBreadth = new JRadioButton("Sökning på bredden");
		rdBtnDepth = new JRadioButton("Sökning på djupet");
		btnSearch = new JButton("Sök");

		JLabel lbFrom = new JLabel("Från");
		JLabel lbTo = new JLabel("Till");
		lbFrom.setBorder(new EmptyBorder(0,20,0,10));
		lbTo.setBorder(new EmptyBorder(0,20,0,10));


		ButtonGroup btnGrp = new ButtonGroup();
		btnGrp.add(rdBtnBreadth);
		btnGrp.add(rdBtnDepth);
		btnGrp.add(rdBtnDijkstra);

		//split the buttons panel to 3 panels
		JPanel buttonsP1 = new JPanel(new BorderLayout());
		JPanel buttonsP1a = new JPanel(new GridLayout(2,1));
		JPanel buttonsP1b = new JPanel(new GridLayout(2,1));

		//Label panel add labels
		buttonsP1a.add(lbFrom);
		buttonsP1a.add(lbTo);

		//Combo panel add combos
		buttonsP1b.add(cmbTo);
		buttonsP1b.add(cmbFrom);

		//add label and combo panels to buttons 1 panel
		buttonsP1.add(buttonsP1a, BorderLayout.WEST);
		buttonsP1.add(buttonsP1b, BorderLayout.CENTER);

		//radio buttons panel
		JPanel buttonsP2 = new JPanel(new GridLayout(3,1));
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

		mapTab.add(mapView);
		textTab.add(sp);

		//add tabs to tabs panel
		mainTabbedPanel.addTab("Karta", mapTab);
		mainTabbedPanel.add("Text", textTab);


		//Add tabs and buttons panel
		this.add(mainTabbedPanel, BorderLayout.CENTER);
		this.add(buttonsPanel, BorderLayout.SOUTH);
	}

	/**
	 * Creates the MainView
	 * @param mapView the map which i draw the graph on
	 * @param p2Controller the controller
	 * @param places the different places that i can go to.
	 */
	public MainView2(MapView mapView, P2Controller p2Controller, Object[] places) {
		ctrl  = p2Controller;
		this.mapView = mapView;

		//init gui
		initGUI();

		//fill the comboboxes with the places from the places.txt

		cmbFrom.setModel(new DefaultComboBoxModel<>(places));
		cmbTo.setModel(new DefaultComboBoxModel<>(places));

		//Set Dijkstra as initial searchType
		rdBtnDijkstra.setSelected(true);
		this.searchAlgorithm = SEARCHTYPE.DIJKSTRA;

		//init buttons
		initButtons();
	}

	private void initButtons() {
		//add actionlistner to the search button
		btnSearch.addActionListener(ae -> {
			switch (searchAlgorithm) {
				case DIJKSTRA:
					ctrl.dijkstraSearch(cmbFrom.getSelectedItem().toString(), cmbTo.getSelectedItem().toString());
					break;
				case BREADTH:
					ctrl.breadthFirstSearch(cmbFrom.getSelectedItem().toString(), cmbTo.getSelectedItem().toString());
					break;
				case DEPTH:
					ctrl.depthFirstSearch(cmbFrom.getSelectedItem().toString(), cmbTo.getSelectedItem().toString());
					break;
				default:
					break;
			}
		});


		/**
		 * Init the radiobuttons. so when a radiobuton is selected there is a action
		 */
		rdBtnDijkstra.addActionListener(ae-> this.searchAlgorithm = SEARCHTYPE.DIJKSTRA);
		rdBtnBreadth.addActionListener(ae -> this.searchAlgorithm = SEARCHTYPE.BREADTH);
		rdBtnDepth.addActionListener(ae -> this.searchAlgorithm =SEARCHTYPE.DEPTH);
	}

	/**
	 * Update the text tab with the roadlist *path that you traveled to destination
	 * @param roadList the list of paths you traveled.
	 */
	public void updateMapRoadList(ArrayList<Road> roadList) {
		String txt = "";
		for (Road road : roadList) {
			txt+=road+"\n";

		}
		teMapPath.setText(txt);
	}
}

