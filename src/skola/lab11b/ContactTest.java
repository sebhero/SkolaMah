package skola.lab11b;
/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */



import javax.swing.*;

/**
 * Created by sebadmin on 2015-10-05.
 */
public class ContactTest {
    public void action() {
        Contact contact = new Contact();
        String name, phone;
        name = JOptionPane.showInputDialog("Ange namn");
        contact.setName(name);
        phone = JOptionPane.showInputDialog("Ange hemtelefon");
        contact.setPhone(phone);
        contact.setMobile(JOptionPane.showInputDialog("Ange mobil"));
        contact.setEmail(JOptionPane.showInputDialog("Ange mail-adress"));
        JOptionPane.showMessageDialog(null, contact.toString());
        JOptionPane.showMessageDialog(null, contact.getName() + "\n" +
                contact.getPhone() + "\n" +
                contact.getMobile() + "\n" +
                contact.getEmail());
    }
    public static void main(String[] args) {
        ContactTest prog = new ContactTest();
        prog.action();
    }
}