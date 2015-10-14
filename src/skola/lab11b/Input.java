package skola.lab11b;

import javax.swing.JOptionPane;

public class Input {
    public static int getInt( String message ) {
        int res = Integer.MIN_VALUE;
        String str = JOptionPane.showInputDialog( message );
        if(str!=null && str.length()>0) {  // användaren klickade inte på Avbryt 
            res = Integer.parseInt( str ); // och minst ett tecken i inmatningen
        }
        return res;
    }
}
