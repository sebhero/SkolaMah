/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.p2;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 * Created by seb on 2015-10-20.
 */
public class TestaLjud {

    private  AudioClip clip = null;

    public TestaLjud()
    {

    }

    public void start() {
        JFrame frame = new JFrame("Kalkylator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setVisible(true);

        //this.clip = null;
        try {

            // URL url = new File("/DA339A_programmering1.Patterns.p2/car.wav").toURI().toURL();
            URL url = this.getClass().getResource("/DA339A_programmering1/Patterns/p2/car.wav");

            clip = Applet.newAudioClip(url);
        } catch (Exception e) {
            // if couldnt add sound sets sound. clip == null
        }

        if (clip != null) {
            System.out.println("play sound");
            clip.play();
        } else {
            System.out.println("NO sound");
        }
    }

    public static void main(String[] args) {
        TestaLjud app = new TestaLjud();
        app.start();
    }


}
