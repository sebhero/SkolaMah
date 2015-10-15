/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab15;

import javax.swing.*;
import java.awt.*;


public class AllPanels extends JPanel{

    public AllPanels()
    {
        setPreferredSize(new Dimension(600,500));
        CalcPanel calc = new CalcPanel();
        FCConverterPanel fccConv = new FCConverterPanel();
        ColorPanel pickColor = new ColorPanel();
        TransportPanel transport = new TransportPanel();

        add(calc);
        add(fccConv);
        add(pickColor);
        add(transport);

    }

//    public static void main(String[] args) {
//        AllPanels panel = new AllPanels();
//        JOptionPane.showMessageDialog(null ,panel);
//    }


}
