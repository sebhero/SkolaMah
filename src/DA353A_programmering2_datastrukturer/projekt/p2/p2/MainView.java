/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.projekt.p2.p2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.util.ArrayList;

/**
 * Created by Sebastian Börebäck on 2016-03-06.
 */
public class MainView extends JPanel{

	private final P2Controller ctrl;
	private ActionEvent searchAlgorithm;
	//	private final String mapFile;
	public JPanel mainPanel;
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


	public MainView(MapView mapFile, P2Controller p2Controller) {
		ctrl  = p2Controller;
		mapView = mapFile;

		DefaultComboBoxModel<Object> cmbModel = new DefaultComboBoxModel<>(ctrl.getPlaces().toArray());
		DefaultComboBoxModel<Object> cmbModel2 = new DefaultComboBoxModel<>(ctrl.getPlaces().toArray());

		cmbFrom.setModel(cmbModel);
		cmbTo.setModel(cmbModel2);

		rdBtnDijkstra.setSelected(true);
		this.searchAlgorithm = new ActionEvent(rdBtnDijkstra, 1, "dijkstra");




		mapFile.setPreferredSize(new Dimension(686, 592));

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
		rdBtnBreadth.addActionListener(ae->{
			this.searchAlgorithm = new ActionEvent(ae.getSource(), 2, "breadth");
			System.out.println(searchAlgorithm.getID());
			System.out.println(searchAlgorithm.getActionCommand());

		});
		rdBtnDepth.addActionListener(ae->{
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
