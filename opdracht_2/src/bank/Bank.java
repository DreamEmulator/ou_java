package bank;

import rekening.Rekening;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Rekening> rekeningen;
    private int debitRekeningNr;
    private int creditRekeningNr;

    public Bank(ArrayList<Rekening> rekeningen, int debitRekeningNr, int creditRekeningNr) {
        this.rekeningen = rekeningen;
        this.debitRekeningNr = debitRekeningNr;
        this.creditRekeningNr = creditRekeningNr;
    }

    private Rekening getRekening(int rekeningNr) {

        Rekening rekening = null;
        int n = 0;
        for (Rekening i : rekeningen) {
            n++;
            if (rekeningNr == i.getRekeningNr()) {
                rekening = i;
            }
            if (n == rekeningen.size() && rekening == null) {
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

    public String getDebitRekeningNaam() {
        return getRekening(debitRekeningNr).getNaam();
    }

    public String getCreditRekeningNaam() {
        return getRekening(creditRekeningNr).getNaam();
    }

    public String getDebitRekeningSaldo() {
        return String.format("%.2f", getRekening(debitRekeningNr).getSaldo());
    }

    public String getCreditRekeningSaldo() {
        return String.format("%.2f", getRekening(creditRekeningNr).getSaldo());
    }

    public String setDebitRekeningNr(int rekeningNr) {
        if (getRekening(rekeningNr) != null) {
            this.debitRekeningNr = rekeningNr;
            return "Rekening gevonden";
        }
        return "De rekening " + rekeningNr + " bestaat niet";
    }

    public String setCreditRekeningNr(int rekeningNr) {
        if (getRekening(rekeningNr) != null) {
            this.creditRekeningNr = rekeningNr;
            return "Rekening gevonden";
        }
        return "De rekening " + rekeningNr + " bestaat niet";
    }

    /** requestMutatie is een public method om een mutatie in een rekening aan te vragen, dit kan zowel storten als opnemen zijn.
     * Tijdens het uitvoeren van de mutatie worden voorafgaand de volgende tests uitgevoerd:<br>
     * 1: Bedragen moet groter dan nul zijn<br>
     * 2: De accounttype die bij de request wordt getest om te zien of de Bank dezelfde hanteert als de GUI<br>
     * 3: De mutatietype bepaald de aard van de mutatie, storten dan wel opnemen<br>
     * @param mutatieType met mutatietype wordt de type mutattie bepaald: storten = 0 en opnemen = 1
     * @param accountType met accountType wordt de type rekening gecontroleerd, dit is om eventuele wijzigingen in de GUI af te vangen, 0 = debit en 1 = credit
     * @param rekeningNummer het nummer van de waarop de mutatie moet worden uitgevoerd
     * @param bedrag het bedrag waarmee de mutatie moet worden uitgevoerd
     */
    public String requestMutatie(int mutatieType, int accountType, int rekeningNummer, double bedrag) {
        if (bedrag > 0) {
            if (getRekening(rekeningNummer).getSaldo() - bedrag > 0) {
                if (accountType == 0 && rekeningNummer == debitRekeningNr) {
                    switch (mutatieType) {
                        //Storten = 0
                        case 0:
                            getRekening(getDebitRekeningNr()).stortBedrag(bedrag);
                            return "De transactie is met succes uitgevoerd.";

                        //Opnemen = 1
                        case 1:
                            getRekening(getDebitRekeningNr()).neemBedragOp(bedrag);
                            return "De transactie is met succes uitgevoerd.";
                    }
                } else if (accountType == 1 && rekeningNummer == creditRekeningNr) {
                    switch (mutatieType) {
                        //Storten = 0
                        case 0:
                            getRekening(getCreditRekeningNr()).stortBedrag(bedrag);
                            return "De transactie is met succes uitgevoerd.";

                        //Opnemen = 1
                        case 1:
                            getRekening(getCreditRekeningNr()).neemBedragOp(bedrag);
                            return "De transactie is met succes uitgevoerd.";
                    }
                } else {
                    return "Error: Je hebt de rekening input gewijzigd na de zoekopdracht, zoek opnieuw de rekening...";
                }
            } else {
                return "Let op: Onvoldoende saldo";
            }
        } else {
            return "Error: Negatieve bedragen zijn niet toegestaan";
        }
        return "Unknown error";
    }

    public String requestTransactie(int debitRekeningNr, int creditRekeningNr, double bedrag) {

        if (debitRekeningNr == getDebitRekeningNr() && creditRekeningNr == getCreditRekeningNr()) {
            Rekening debitRekening = getRekening(debitRekeningNr);
            Rekening creditRekening = getRekening(creditRekeningNr);
            //Controleer of bedrag is toegestaan
            if (bedrag > 0 && debitRekening.getSaldo() - bedrag > 0) {
                debitRekening.neemBedragOp(bedrag);
                creditRekening.stortBedrag(bedrag);
                return "De transactie is succesvol uitgevoerd";
            } else {
                return "Transactie niet gelukt controleer het bedrag";
            }
        }
        return "Transactie niet gelukt controleer rekeningnummers";
    }

}
