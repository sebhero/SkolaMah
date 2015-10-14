package skola.lab11b;
/*
* BankAccountTest.java
* Den 5/10 - 2015
*/

import javax.swing.*;
/**
* Programmet testar klassen BankAcccount
* @author Rolf Axelsson
*/
public class BankAccountTest {
    public void test() {
        BankAccount account1 = new BankAccount( "399.847.500" );
        BankAccount account2 = new BankAccount( "399.847.555", 1000, 0.0395 );
        account1.deposit( 1000 );

        account1.info();
        account1.deposit( 250 );
        JOptionPane.showMessageDialog( null, "Konto med " + account1.getBalance() + " kr\nRäntesatsen är " + account1.getInterestRate()*100 + " % per år" );
        account1.withdrawal( 550 );
        account1.info();

        account2.info();
        account2.deposit( 500 );
        JOptionPane.showMessageDialog( null, "Konto med " + account2.getBalance() + " kr\nRäntesatsen är " + account2.getInterestRate()*100 + " % per år" );
        account2.withdrawal( 200 );
        account2.info();
    }

    public static void main(String[] args) {
        BankAccountTest prog = new BankAccountTest();
        prog.test();
    }
}
