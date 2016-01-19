/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package DA339A_programmering1.Patterns.skola.lab21.upg3;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sebastian Börebäck on 2015-11-17.
 */
public class Title extends JLabel {
    public Title(String content, int style, int fontsize, Color text,
                 Color background) {
        Font font = new Font("Dialog", style, fontsize);
        setText(content);
        setHorizontalAlignment(JLabel.CENTER);
        setFont(font);
        setBackground(background);
        setOpaque(true);
        setForeground(text);
    }
}