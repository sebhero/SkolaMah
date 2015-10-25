/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package p3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sebastian Börebäck on 2015-10-25.
 */
public class TestGui{
    private final SSPController controller;
    public JPanel panel1;
    private JButton btnSten;
    private JButton btnNewGame;
    private JButton btnSax;
    private JButton btnPose;

    public TestGui() {
        controller = null;
    }

    public TestGui(SSPController controller) {
        this.controller = controller;

        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.newGame();
            }
        });
        btnSten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.newChoice(0);
            }
        });
        btnSax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.newChoice(1);
            }
        });
        btnPose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.newChoice(2);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("TestGui");
        frame.setContentPane(new TestGui().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
