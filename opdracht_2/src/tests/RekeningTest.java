package tests;

import rekening.Rekening;

public class RekeningTest {
    public RekeningTest(Rekening rekening) {

        //Rekening tests
        System.out.println("\n<<< Rekening-Test >>>");

        //getNaam
        System.out.println("\n>>> getNaam <<<\n" + rekening.getNaam());
        //getSaldo
        System.out.println("\n>>> getSaldo <<<\n" + rekening.getSaldo());
        //getRekeningNr
        System.out.println("\n>>> getRekeningNr <<<\n" + rekening.getRekeningNr());

        //neemBedragOp
        System.out.println("\n>>> neemBedragOp <<<\nWe nemen nu een bedrag van 1.32 op en dan gaat het bedrag van " + rekening.getSaldo() + " naar:");
        rekening.neemBedragOp(1.32);
        System.out.println(rekening.getSaldo());

        //stortBedrag
        System.out.println("\n>>> stortBedrag <<<\nWe storten nu een bedrag van 4.29 op en dan gaat het bedrag van " + rekening.getSaldo() + " naar:");
        rekening.stortBedrag(4.29);
        System.out.println(rekening.getSaldo());

    }
}
