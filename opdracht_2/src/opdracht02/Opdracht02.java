package opdracht02;

import bank_domain.Bank;
import bank_gui.BankGUI;

public class Opdracht02 {
    public static void main(String[] args) {
        Bank bank = new Bank();
        new BankGUI(bank);
    }
}