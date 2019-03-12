package bank_domain;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Rekening> rekeningen;

    public Bank(ArrayList<Rekening> rekeningen) {
        this.rekeningen = rekeningen;
    }

    private Rekening getRekening(int rekeningNr) {
        Rekening rekening = null;
        for (Rekening i : rekeningen) {
            if (rekeningNr == i.getRekeningNr()) {
                rekening = i;
                break;
            }
        }
        return rekening;
    }

//    Is dit ok?
    public Rekening zoeken(int rekeningNr){
        Rekening kopieRekening = new Rekening(getRekening(rekeningNr).getRekeningNr(),getRekening(rekeningNr).getNaam(),getRekening(rekeningNr).getSaldo());
        return kopieRekening;
    }

    public void storten (int rekening, double bedrag){
        if (bedrag > 0 && getRekening(rekening) != null) {
            getRekening(rekening).stortBedrag(bedrag);
        }
    }

    public void opnemen (int rekening, double bedrag){
        if (bedrag > 0 && getRekening(rekening) != null && getRekening(rekening).getSaldo() - bedrag >= 0) {
            getRekening(rekening).neemBedragOp(bedrag);
        }
    }

    public void overmaken (int debitRekening, int creditRekening, double bedrag){

        if (bedrag > 0 && getRekening(debitRekening) != null && getRekening(creditRekening) != null && getRekening(debitRekening).getSaldo() - bedrag >= 0) {
            getRekening(debitRekening).neemBedragOp(bedrag);
            getRekening(creditRekening).stortBedrag(bedrag);
        }

    }

}