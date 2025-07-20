/* ===============================================================
 *  BankAccount.java
 * =============================================================== */
package edu.banks.csc272;

/** Encapsulates a single savings account balance. */
public class BankAccount {

    private double balance;                /* current amount $ */

    public BankAccount(double initialDeposit) { balance = initialDeposit; }

    /** Compound annually at rate r for n years. */
    public void addInterest(double ratePct, int years) {
        double r = ratePct / 100.0;
        balance = balance * Math.pow(1 + r, years);
    }

    public double getBalance() { return balance; }
}
