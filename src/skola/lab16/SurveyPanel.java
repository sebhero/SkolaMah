/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab16;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-10-19.
 */
@SuppressWarnings("DefaultFileTemplate")
public class SurveyPanel extends JPanel {

    private JPanel pnlNorth = new JPanel(new BorderLayout());
    private JPanel pnlNorthNorth = new JPanel(new BorderLayout());
    private JPanel pnlNorthCenter = new JPanel(new GridLayout(1,2));
    private JPanel pnlAge = new JPanel(new GridLayout(5,1));
    private JPanel pnlHobby = new JPanel(new GridLayout(5,1));


    private JTextArea taSummary = new JTextArea();

    private JButton btnSummar = new JButton("Sammanfattning");
    private JLabel lblName = new JLabel("Namn: ");
    private JTextField tfName = new JTextField();

    private JRadioButton rb0_17 = new JRadioButton(" 0 - 17");
    private JRadioButton rb18_64 = new JRadioButton( "18 - 64" );
    private JRadioButton rb65 = new JRadioButton( "65 -");
    private ButtonGroup buttonGroup = new ButtonGroup();

    private JCheckBox cbSport = new JCheckBox("Idrott");
    private JCheckBox cbDance = new JCheckBox("Folkdans");
    private JCheckBox cbBirds = new JCheckBox("Fagelskadning");
    private JCheckBox cbBridge = new JCheckBox("Bridge");
    private JCheckBox cbSong = new JCheckBox("Korsang");


    public SurveyPanel() {
        setPreferredSize(new Dimension(300, 360));

        setLayout(new BorderLayout());

        add(pnlNorth, BorderLayout.NORTH);
        add(taSummary, BorderLayout.CENTER);

        pnlNorth.add(pnlNorthNorth, BorderLayout.NORTH);
        pnlNorth.add(pnlNorthCenter, BorderLayout.CENTER);
        pnlNorth.add(btnSummar, BorderLayout.SOUTH);

        btnSummar.addActionListener(ae -> summary());


        pnlNorthNorth.add(lblName, BorderLayout.WEST);
        pnlNorthNorth.add(tfName, BorderLayout.CENTER);

        pnlNorthCenter.add(pnlAge);
        pnlNorthCenter.add(pnlHobby);

        pnlAge.setBorder(BorderFactory.createTitledBorder("Alder"));

        buttonGroup.add(rb0_17);
        buttonGroup.add(rb18_64);
        buttonGroup.add(rb65);

        pnlAge.add(rb0_17);
        pnlAge.add(rb18_64);
        pnlAge.add(rb65);
        rb65.setSelected(true);

        pnlHobby.setBorder(BorderFactory.createTitledBorder("Hobby"));


        pnlHobby.add(cbSport);
        pnlHobby.add(cbDance);
        pnlHobby.add(cbBirds);
        pnlHobby.add(cbBridge);
        pnlHobby.add(cbSong);


        //so i can get the text i want to print when its selected
        rb0_17.setActionCommand("0 - 17ar\n");
        rb18_64.setActionCommand("18 - 64ar\n");
        rb65.setActionCommand("65 - ar\n");



    }

    private void summary() {
        String res = this.tfName.getText() +"\n";

        //get the selected age from button group
        res +="Alder: "+ buttonGroup.getSelection().getActionCommand();



        //handle the check for hobbies
        Component[] hobbyList =  pnlHobby.getComponents();

        JCheckBox theHobby;

//        if(hobbyList.length > 1) {

            res += "Hobby: ";

            for (Component theComponent : hobbyList) {
                theHobby = (JCheckBox) theComponent;

                if (theHobby.isSelected()) {
                    res += " " + theHobby.getText();
                }

            }
            res += "\n";
//        }

        System.out.println(res);
        taSummary.setText(res);


    }

}
