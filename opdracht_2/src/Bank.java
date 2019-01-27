import java.util.ArrayList;

public class Bank {

    private ArrayList<Rekening> rekeningen;
    private BankGui bankGui;

    public Bank (ArrayList<Rekening> rekeningen, BankGui bankGui) {

        this.rekeningen = rekeningen;
        this.bankGui = bankGui;
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

    public void updateGuiValues (int debitRekeningNr, int creditRekeningNr){
        String debitNaam = getRekening(debitRekeningNr).getNaam();
        double debitSaldo = getRekening(debitRekeningNr).getSaldo();

        String creditNaam = getRekening(creditRekeningNr).getNaam();
        double creditSaldo = getRekening(creditRekeningNr).getSaldo();

        bankGui.updateGuiView(debitRekeningNr,debitNaam,debitSaldo,creditRekeningNr,creditNaam,creditSaldo);
    }

}
