public class RekeningTest {
    public RekeningTest(Rekening rekening) {

        System.out.println("\n---Rekening-Test---");

        System.out.println(">>> getSaldo: <<<\n" + rekening.getNaam() + " heeft een rekening met het saldo: " + rekening.getSaldo());

        System.out.println("\n>>> setSaldo: <<<\nWe voegen nu 15.32 toe en dan komt het bedrag op:");
        rekening.setSaldo(15.32);

        System.out.println("---------------");

    }
}
