package tests;

import bank.Bank;
import bankFrame.BankFrame;
import rekening.Rekening;

import java.util.ArrayList;

public class Opdracht02Test {
    public static void main(String[] args) {
        // Dataset
        ArrayList<Rekening> rekeningen = new ArrayList();
        rekeningen.add(new Rekening(1111, "Fabian", 14.56));
        rekeningen.add(new Rekening(1234, "Fenia", 24.63));
        rekeningen.add(new Rekening(2222, "Hugo", 15.67));
        rekeningen.add(new Rekening(2345, "Sebas", 5.67));
        rekeningen.add(new Rekening(3333, "Beatrix", 10209.67));

// Actieve rekeningen
        int debitRekeningNr = 1111;
        int creditRekeningNr = 1234;

// Create bank.Bank
        Bank bank = new Bank(rekeningen, debitRekeningNr, creditRekeningNr);
        BankFrame bankFrame = new BankFrame(bank);
// Run tests
        new tests.BankTest(bank);
        new tests.RekeningTest(rekeningen.get(0));
    }
}
