package opdracht02;

import bank_domain.Bank;
//import bank_gui.BankFrame;
import bank_domain.Rekening;
import bank_gui.BankGUI;

import java.util.ArrayList;

/**
* De Opdracht02 klasse fungeert als de data-laag voor de bank, alsmede de plek waar de intitiele waarden geïnitialiseerd worden.
*/
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
//        BankFrame bankFrame = new BankFrame(bank);
        BankGUI bankGUI = new BankGUI(bank);
    }
}