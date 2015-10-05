package skola.lab3.upg5a.laboration5;

import javax.swing.JOptionPane;
/**
 * Created by Sebastian Börebäck on 2015-09-14.
 */
public class Program5a {

    public void nameInfo1() {
        String name, upperCase, lowerCase, res="";
        int count;
        char firstLetter;

        name = JOptionPane.showInputDialog("Mata in ditt förnamn");
        count = name.length();  // length() => antal tecken i String-objektet
        upperCase = name.toUpperCase();  // toUpperCase => nytt String-objekt
        lowerCase = name.toLowerCase();  // toLowerCase => nytt String-objekt
        firstLetter = name.charAt(0);  // charAt(index) => returnerar tecken i visst index

        //res += "Du heter " + name + "\n";
        res = java.text.MessageFormat.format("Du heter {0} \n " +
                "Ditt namn innehåller {1} bokstäver \n" +
                "Ditt namn med stora bokstäver: {2} \n" +
                "Ditt namn med små bokstäver: {3} \n" +
                "Första bokstaven i ditt namn är: {4}"
                ,name,count,upperCase,lowerCase,firstLetter);
        //JOptionPane.showMessageDialog(null, res);


    }

    public static void main(String[] args) {
        Program5a sp = new Program5a();
        sp.nameInfo1();
    }
}




