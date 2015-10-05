//package laboration11;
//import javax.swing.JOptionPane;
//
//public class AddressTest {
//    public void test() {
//        Address a1 = new Address("Nygatan 3", 26344, "Eslöv");
//        String nyGata, nyPostadress;
//        int nyttPostnummer;
//
//        JOptionPane.showMessageDialog(null,a1.toString());
//
//        nyGata = JOptionPane.showInputDialog("Ange ny gata");
//        nyttPostnummer = Integer.parseInt(JOptionPane.showInputDialog("Ange nytt postnummer"));
//        nyPostadress = JOptionPane.showInputDialog("Ange ny postadress");
//
//        a1 = new Address(nyGata, nyttPostnummer, nyPostadress);
//        JOptionPane.showMessageDialog(null,a1.toString());
//    }
//
//    public static void main(String[] args) {
//        AddressTest prog = new AddressTest();
//        prog.test();
//    }
//}
