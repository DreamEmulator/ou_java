import java.util.ArrayList;

public class Bank {

    private ArrayList<Rekening> rekeningen;

    public Bank (ArrayList<Rekening> rekeningen) {
        this.rekeningen = rekeningen;
    }

    public Rekening getRekening (int rekeningNr) {

        Rekening rekening = null;

        for (Rekening i : rekeningen){
            if (rekeningNr == i.getRekeningNr()){
                rekening = i;
            }
        }
        return rekening;
    }

    public void maakOver (int debitRekeningNr, int creditRekeningNr, double bedrag) {

        if (bedrag > 0){
            Rekening debitRekening = getRekening(debitRekeningNr);
            Rekening creditRekening = getRekening(creditRekeningNr);

            debitRekening.setSaldo(-bedrag);
            creditRekening.setSaldo(bedrag);
        } else {
            System.out.println("Negatieve bedragen niet toegestaan");
        }

    }

}
