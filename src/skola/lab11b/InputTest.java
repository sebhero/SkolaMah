package skola.lab11b;


import javax.swing.JOptionPane;

public class InputTest {
    public static void main(String[] args) {
        int nbr1, nbr2;
        nbr1 = Input.getInt("Mata in ett heltal");
        nbr2 = Input.getInt("Mata in ett heltal till");
        JOptionPane.showMessageDialog( null, "nbr1=" + nbr1 + "\nnbr2=" + nbr2 );
    }
}
