/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab21.upg2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sebastian Börebäck on 2015-11-17.
 */

public class TestNameProfession extends JPanel implements ActionListener {
    private JButton update = new JButton("Uppdatera textytan");
    private JTextArea textarea = new JTextArea();
    private NameProfession nameProfession = new NameProfession();
    public TestNameProfession() {
        setLayout(new BorderLayout());
        textarea.setPreferredSize(new Dimension(300,100));
        textarea.setEditable(false);
        update.addActionListener(this);
        add(nameProfession, BorderLayout.NORTH);
        add(textarea, BorderLayout.CENTER);
        add(update, BorderLayout.SOUTH);
    }
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == update) {
            textarea.setText("Namn: "+nameProfession.getTfName()+"\n" +
                    "Yrke: "+nameProfession.getTfJob());
        }

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestNameProfession());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}