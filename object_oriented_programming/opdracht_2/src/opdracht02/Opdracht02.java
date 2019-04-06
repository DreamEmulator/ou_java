package opdracht02;

import bank_domain.Bank;
import bank_gui.BankFrame;

public class Opdracht02 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        new BankFrame(bank);
    }
}