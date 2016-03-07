/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p2.p2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * Created by seb on 2016-03-07.
 */
public class MainView2 extends JPanel {

	private final P2Controller ctrl;
	private ActionEvent searchAlgorithm;
	private JTabbedPane mainTabbedPanel;
	private JPanel mapTab;
	private JPanel textTab;
	private JPanel buttonsPanel;
	private JRadioButton rdBtnDijkstra;
	private JRadioButton rdBtnBreadth;
	private JRadioButton rdBtnDepth;
	private JComboBox cmbFrom;
	private JComboBox cmbTo;
	private JButton btnSearch;
	private MapView mapView;
	private JTextArea teMapPath;


	/***
	 * Draws the gui
	 */
	private void initGUI() {
		this.setLayout(new BorderLayout());
		//create main panels
		buttonsPanel = new JPanel(new BorderLayout());
		mainTabbedPanel = new JTabbedPane();

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
		mapTab = new JPanel(new BorderLayout());

		textTab = new JPanel(new BorderLayout());
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


//		mainTabbedPanel

	}


	public MainView2(MapView mapFile, P2Controller p2Controller, ArrayList<Place> places) {
		ctrl  = p2Controller;
		mapView = mapFile;

		initGUI();


		cmbFrom.setModel(new DefaultComboBoxModel<>(places.toArray()));
		cmbTo.setModel(new DefaultComboBoxModel<>(places.toArray()));

		rdBtnDijkstra.setSelected(true);
		this.searchAlgorithm = new ActionEvent(rdBtnDijkstra, 1, "dijkstra");




		//mapFile.setPreferredSize(new Dimension(686, 592));

		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(MessageFormat.format("From: {0} to {1}", cmbFrom.getSelectedItem(), cmbTo.getSelectedItem()));


				System.out.println(searchAlgorithm.getID());
				System.out.println(searchAlgorithm.getActionCommand());

				switch (searchAlgorithm.getActionCommand()) {
					case "dijkstra":
						ctrl.shortestPath(cmbFrom.getSelectedItem().toString(), cmbTo.getSelectedItem().toString());
						break;
					case "breadth":
						ctrl.search1(cmbFrom.getSelectedItem().toString(), cmbTo.getSelectedItem().toString());
						break;
					case "depth":
						ctrl.search1(cmbFrom.getSelectedItem().toString(), cmbTo.getSelectedItem().toString());
						break;
				}



			}
		});



		rdBtnDijkstra.addActionListener(ae->{
			this.searchAlgorithm = new ActionEvent(ae.getSource(), 1, "dijkstra");
			System.out.println(searchAlgorithm.getID());
			System.out.println(searchAlgorithm.getActionCommand());

		});
		rdBtnBreadth.addActionListener(ae -> {
			this.searchAlgorithm = new ActionEvent(ae.getSource(), 2, "breadth");
			System.out.println(searchAlgorithm.getID());
			System.out.println(searchAlgorithm.getActionCommand());

		});
		rdBtnDepth.addActionListener(ae -> {
			this.searchAlgorithm = new ActionEvent(ae.getSource(), 3, "depth");
			System.out.println(searchAlgorithm.getID());
			System.out.println(searchAlgorithm.getActionCommand());

		});
	}



	private void createUIComponents() {
	}

	public void updateMapRoadList(ArrayList<Road> roadList) {
//		taMapPath.setText(roadList.toString());

		teMapPath.setText("Hello");
		String txt = "";
		for (Road road : roadList) {
			txt+=road+"\n";

		}
		teMapPath.setText(txt);
		System.out.println(txt);

	}
}

