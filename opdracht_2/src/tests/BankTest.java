package tests;

import bank.Bank;

public class BankTest {
    public BankTest(Bank bank) {

        //Bank tests
        System.out.println("\n<<< bank.Bank-Test >>>");

        //getRekening
        System.out.println("\n>>> getRekening <<<\n" + bank.getRekening(bank.getDebitRekeningNr()));

        //getDebitRekeningNr
        System.out.println("\n>>> getDebitRekeningNr <<<\n" + bank.getDebitRekeningNr());

        //getCreditRekeningNr
        System.out.println("\n>>> getDebitRekeningNr <<<\n" + bank.getCreditRekeningNr());

        //setDebitRekeningNr
        bank.setDebitRekeningNr(1111);
        System.out.println("\n>>> setDebitRekeningNr <<<\n" + bank.getDebitRekeningNr());

        //setCreditRekeningNr
        bank.setCreditRekeningNr(2222);
        System.out.println("\n>>> setDebitRekeningNr <<<\n" + bank.getCreditRekeningNr());

        //maakOver
        System.out.println("\n>>> maakOver <<<");
        System.out.println("Eerst heeft " + bank.getRekening(bank.getDebitRekeningNr()).getNaam() + " een saldo van " + bank.getRekening(bank.getDebitRekeningNr()).getSaldo() + " en heeft " + bank.getRekening(bank.getCreditRekeningNr()).getNaam() + " een saldo van " + bank.getRekening(bank.getCreditRekeningNr()).getSaldo() + ".");
        System.out.println("\nNu gaan we een bedrag overmaken van 2.45");
        bank.maakOver(bank.getDebitRekeningNr(),bank.getCreditRekeningNr(),2.45);

        System.out.println("\nNu heeft " + bank.getRekening(bank.getDebitRekeningNr()).getNaam() + " een saldo van " + bank.getRekening(bank.getDebitRekeningNr()).getSaldo() + " en heeft " + bank.getRekening(bank.getCreditRekeningNr()).getNaam() + " een saldo van " + bank.getRekening(bank.getCreditRekeningNr()).getSaldo() + ".\n");

    }
}
