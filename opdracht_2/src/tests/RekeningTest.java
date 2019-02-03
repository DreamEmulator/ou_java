package tests;

import rekening.Rekening;

public class RekeningTest {
    public RekeningTest(Rekening rekening) {

        //Rekening tests
        System.out.println("\n---Rekening-Test---");

        //getNaam
        System.out.println(">>> getNaam:\n" + rekening.getNaam() + "<<<\n");
        //getSaldo
        System.out.println(">>> getSaldo: \n" + rekening.getSaldo() + "<<<\n");
        //getRekeningNr
        System.out.println(">>> getRekeningNr: \n" + rekening.getRekeningNr() + "<<<\n");

        //neemBedragOp
        System.out.println(">>> neemBedragOp: <<<\nWe nemen nu een bedrag van 1.32 op en dan gaat het bedrag van " + rekening.getSaldo() + " naar:");
        rekening.neemBedragOp(1.32);
        System.out.println(rekening.getSaldo() + "/n");

        //stortBedrag
        System.out.println("\n>>> stortBedrag: <<<\nWe storten nu een bedrag van 4.29 op en dan gaat het bedrag van " + rekening.getSaldo() + " naar:");
        rekening.stortBedrag(4.29);
        System.out.println(rekening.getSaldo() + "/n");

    }
}
