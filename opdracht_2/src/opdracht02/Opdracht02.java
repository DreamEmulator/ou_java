package opdracht02;

import bank.Bank;
import bankFrame.BankFrame;
import rekening.Rekening;
import java.util.ArrayList;

public class Opdracht02 {

    public static void main(String[] args) {

// Dataset
        ArrayList<Rekening> rekeningen = new ArrayList();
        rekeningen.add(new Rekening(1111, "Fabian", 14.56));
        rekeningen.add(new Rekening(1234, "Fenia", 24.63));
        rekeningen.add(new Rekening(2222, "Hugo", 15.67));
        rekeningen.add(new Rekening(2345, "Sebas", 5.67));
        rekeningen.add(new Rekening(3333, "Beatrix", 10209.67));

// Set intial accounts rekeningen
        int debitRekeningNr = 1111;
        int creditRekeningNr = 1234;

// Create Bank domainlayer and GUI
        Bank bank = new Bank(rekeningen, debitRekeningNr, creditRekeningNr);
        BankFrame bankFrame = new BankFrame(bank);
    }
}
