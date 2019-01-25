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

        Rekening debitRekening = getRekening(debitRekeningNr);
        Rekening creditRekening = getRekening(creditRekeningNr);

        debitRekening.setSaldo(-bedrag);
        creditRekening.setSaldo(bedrag);
    }

}
