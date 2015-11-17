/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab21.upg2;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-11-17.
 */
public class NameProfession extends JPanel {

    private JPanel west = new JPanel(new GridLayout(2,1));
    private JPanel center = new JPanel(new GridLayout(2,1));

    private JLabel lblName = new JLabel("Namn: ");
    private JLabel lbJob = new JLabel("Yrke: ");
    private JTextField tfName = new JTextField();
    private JTextField tfJob = new JTextField();

    public NameProfession() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200, 80));


        west.add(lblName);
        west.add(lbJob);
        center.add(tfName);
        center.add(tfJob);

        this.add(west, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);

    }

    public String getTfName() {
        return tfName.getText();
    }

    public String getTfJob() {
        return tfJob.getText();
    }
}
