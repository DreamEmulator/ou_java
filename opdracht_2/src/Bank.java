import java.util.ArrayList;

public class Bank {

    private ArrayList<Rekening> rekeningen;
    private BankGui bankGui;
    private int debitRekeningNr;
    private int creditRekeningNr;

    public Bank (ArrayList<Rekening> rekeningen, int debitRekeningNr, int creditRekeningNr) {
        this.rekeningen = rekeningen;
        this.debitRekeningNr = debitRekeningNr;
        this.creditRekeningNr = creditRekeningNr;
    }

    public Rekening getRekening (int rekeningNr) {

        Rekening rekening = null;
        int n = 0;
        for (Rekening i : rekeningen){
            n++;
            if (rekeningNr == i.getRekeningNr()){
                rekening = i;
            }
            if (n == rekeningen.size() && rekening == null){
                System.out.println("Geen rekening gevonden.");
            }
        }
        return rekening;
    }

    public void maakOver (int debitRekeningNr, int creditRekeningNr, double bedrag) {

        Rekening debitRekening = getRekening(debitRekeningNr);
        Rekening creditRekening = getRekening(creditRekeningNr);

        //Controleer of rekeningen bestaan
        if (debitRekening != null && creditRekening != null){

            //Controleer of bedrag is toegestaan
            if(bedrag > 0 &&  debitRekening.getSaldo()-bedrag > 0) {
                debitRekening.setSaldo(-bedrag);
                creditRekening.setSaldo(bedrag);
            } else {
                System.out.println("Transactie niet gelukt controleer het bedrag");
            }

        } else {
            System.out.println("Transactie niet gelukt controleer rekeningnummers");
        }
    }

    public int getDebitRekeningNr() {
        return debitRekeningNr;
    }

    public int getCreditRekeningNr() {
        return creditRekeningNr;
    }

    //    TODO: Make getters and setters for the active accounts
}
