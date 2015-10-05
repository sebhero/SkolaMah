/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2015.
 */

package skola.lab11;

import javax.swing.*;
import java.text.MessageFormat;

/**
 * Created by sebadmin on 2015-10-05.
 */
public class BankAccount {

    String accountNbr;
    double balance;
    double interestRate;

    public BankAccount(String accountNbr) {
        this.accountNbr = accountNbr;
    }

    public BankAccount(String accountNbr, double balance, double interestRate) {
        this.accountNbr = accountNbr;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public String getAccountNbr() {
        return accountNbr;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double balance) {
        this.balance += balance;
    }

    public void withdrawal(double balance) {
        this.balance -= balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void info()
    {
        JOptionPane.showMessageDialog(null, MessageFormat.format("Account number: {0}\n" +
                "Balance: {1}",this.accountNbr,this.balance));

    }


}
