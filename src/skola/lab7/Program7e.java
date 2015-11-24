/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab7;
import javax.swing.*;

public class Program7e {
   public void customer() {
      double price, fromCustomer, back;
      boolean member;
        
      price = Double.parseDouble( JOptionPane.showInputDialog("Ange varans pris") );
      fromCustomer = Double.parseDouble( JOptionPane.showInputDialog("Hur mycket betalar kunden?") );
      
      // medlem får värdet true vid klick på 'Ja', och false vid klick på 'Nej' / stängning av dialog
      member = JOptionPane.showConfirmDialog( null, "Är kunden medlem?", "MEDLEM", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION;

      // om medlem så ska nytt pris beräknas här: price = 0.9 * price; // 10% rabatt
      if (member) {
         price = 0.9 *price;

      }
      back = fromCustomer-price;
      JOptionPane.showMessageDialog( null, "Pengar tillbaka: " + back + " kr" );
   }

   public static void main(String[] args) {
      Program7e p7e = new Program7e();
      p7e.customer();
   }
}
