/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TransportPanel extends JPanel{

    private final JCheckBox chkbxCar;
    private final JCheckBox chkbxTrain;
    private final JCheckBox chkbxBus;
    private final JCheckBox chkbxBike;
    private final JCheckBox chkbxWalk;
    private final JLabel lblResult;

    public TransportPanel()
    {
        //sets the size
        setPreferredSize(new Dimension(400, 60));
        setBackground(Color.cyan);

        Dimension textDim = new Dimension(390, 10);

        //creates the gui items
        JLabel lblQuestion = new JLabel("How do you travel to MAH?");
        lblQuestion.setPreferredSize(textDim);
        lblResult = new JLabel("result");
        lblResult.setPreferredSize(textDim);
        chkbxCar = new JCheckBox("Car");
        chkbxTrain = new JCheckBox("Train");
        chkbxBus = new JCheckBox("Bus");
        chkbxBike = new JCheckBox("Bike");
        chkbxWalk = new JCheckBox("Walk");

        //adds the listners
        addListner();

        //add gui items to panel
        add(lblQuestion);
        add(chkbxTrain);
        add(chkbxBus);
        add(chkbxBike);
        add(chkbxWalk);
        add(lblResult);

    }

    /**
     * Adds the listners to the checkboxes
     */
    private void addListner() {
        TransportListener listener = new TransportListener();
        this.chkbxBike.addItemListener(listener);
        this.chkbxBus.addItemListener(listener);
        this.chkbxCar.addItemListener(listener);
        this.chkbxTrain.addItemListener(listener);
        this.chkbxWalk.addItemListener(listener);
    }

    /**
     * Handles the checkbox selections and displays the result
     * in lblResult
     */
    private class TransportListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {


            //holds the result string
            String theResult = "You choose:";

            //checklist to see what is checked
            if(chkbxCar.isSelected())
            {
                theResult +=" car";
            }
            if(chkbxWalk.isSelected())
            {
                theResult +=" walk";
            }
            if(chkbxTrain.isSelected())
            {
                theResult +=" train";
            }
            if(chkbxBus.isSelected())
            {
                theResult +=" bus";
            }
            if(chkbxBike.isSelected())
            {
                theResult +=" bike";
            }

            lblResult.setText(theResult);




        }
    }

    public static void main(String[] args) {
        TransportPanel panel = new TransportPanel();
        JOptionPane.showMessageDialog(null, panel);
    }

}
