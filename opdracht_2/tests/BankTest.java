public class BankTest {
    public BankTest(Bank bank) {

        System.out.println("\n---Bank-Test---");

        System.out.println(">>> getRekening: <<<\n" + bank.getRekening(2345).getNaam() + " heeft een rekening met het saldo: " + bank.getRekening(2345).getSaldo());

        System.out.println("\n>>> maakOver: <<<");
        System.out.println("Eerst heeft " + bank.getRekening(1111).getNaam() + " een saldo van " + bank.getRekening(1111).getSaldo() + " en heeft " + bank.getRekening(2345).getNaam() + " een saldo van " + bank.getRekening(2345).getSaldo() + ".");
        System.out.println("\nNu gaan we een bedrag overmaken van 3.45");
        bank.maakOver(1111,2345,3.45);

        System.out.println("\nNu heeft " + bank.getRekening(1111).getNaam() + " een saldo van " + bank.getRekening(1111).getSaldo() + " en heeft " + bank.getRekening(2345).getNaam() + " een saldo van " + bank.getRekening(2345).getSaldo() + ".\n");

        System.out.println("---------------");

    }
}
