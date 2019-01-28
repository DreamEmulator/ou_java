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
    public int getDebitRekeningNr() {
        return debitRekeningNr;
    }
    public int getCreditRekeningNr() {
        return creditRekeningNr;
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
    public void stortBedrag (int rekeningNr, double stortBedrag) {
        Rekening rekening = getRekening(rekeningNr);
        if (rekening.getSaldo() + stortBedrag > 0) {
            double huidigSaldo = rekening.getSaldo();
            double nieuwSaldo = huidigSaldo + stortBedrag;

            rekening.setSaldo(nieuwSaldo);
        } else {
            System.out.println("Onvoldoende saldo voor deze transactie");
        }
    }
    public void neemBedragOp (int rekeningNr, double opneemBedrag) {
        Rekening rekening = getRekening(rekeningNr);
        if (rekening.getSaldo() - opneemBedrag > 0) {
            double huidigSaldo = rekening.getSaldo();
            double nieuwSaldo = huidigSaldo - opneemBedrag;

            rekening.setSaldo(nieuwSaldo);
        } else {
            System.out.println("Onvoldoende saldo voor deze transactie");
        }
    }

    //    TODO: Think about where the stort and opneem methods should be, in Bank or in Rekening
}
