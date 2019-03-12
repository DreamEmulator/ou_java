package bank_domain;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Rekening> rekeningen;

    public Bank(ArrayList<Rekening> rekeningen) {
        this.rekeningen = rekeningen;
    }

    public Rekening zoekRekening(int rekeningNr) {
        Rekening rekening = null;
        for (Rekening i : rekeningen) {
            if (rekeningNr == i.getRekeningNr()) {
                rekening = i;
                break;
            }
        }
        return rekening;
    }

    public void storten (int rekening, double bedrag){
        if (bedrag > 0 && zoekRekening(rekening) != null) {
            zoekRekening(rekening).stortBedrag(bedrag);
        }
    }

    public void opnemen (int rekening, double bedrag){
        if (bedrag > 0 && zoekRekening(rekening) != null && zoekRekening(rekening).getSaldo() - bedrag >= 0) {
            zoekRekening(rekening).neemBedragOp(bedrag);
        }
    }

    public void overmaken (int debitRekening, int creditRekening, double bedrag){

        if (bedrag > 0 && zoekRekening(debitRekening) != null && zoekRekening(creditRekening) != null && zoekRekening(debitRekening).getSaldo() - bedrag >= 0) {
            zoekRekening(debitRekening).neemBedragOp(bedrag);
            zoekRekening(creditRekening).stortBedrag(bedrag);
        }

    }

}