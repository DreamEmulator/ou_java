package tests;

import bank.Bank;

public class BankTest {
    public BankTest(Bank bank) {

        System.out.println("\n---bank.Bank-Test---");

        //Test: getRekening
        System.out.println(">>> getRekening: <<<\n" + bank.getRekening(bank.getDebitRekeningNr()).getNaam() + " heeft een rekening met het saldo: " + bank.getRekening(bank.getDebitRekeningNr()).getSaldo());

        //Test: maakOver
        System.out.println("\n>>> maakOver: <<<");
        System.out.println("Eerst heeft " + bank.getRekening(bank.getDebitRekeningNr()).getNaam() + " een saldo van " + bank.getRekening(bank.getDebitRekeningNr()).getSaldo() + " en heeft " + bank.getRekening(bank.getCreditRekeningNr()).getNaam() + " een saldo van " + bank.getRekening(bank.getCreditRekeningNr()).getSaldo() + ".");
        System.out.println("\nNu gaan we een bedrag overmaken van 2.45");
        bank.maakOver(bank.getDebitRekeningNr(),bank.getCreditRekeningNr(),2.45);

        System.out.println("\nNu heeft " + bank.getRekening(bank.getDebitRekeningNr()).getNaam() + " een saldo van " + bank.getRekening(bank.getDebitRekeningNr()).getSaldo() + " en heeft " + bank.getRekening(bank.getCreditRekeningNr()).getNaam() + " een saldo van " + bank.getRekening(bank.getCreditRekeningNr()).getSaldo() + ".\n");

        System.out.println("---------------");

    }
}
