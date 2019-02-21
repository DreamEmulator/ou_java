package bank;

import rekening.Rekening;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Rekening> rekeningen;
    private int debitRekeningNr;
    private int creditRekeningNr;


    /**
     * De contructor voor Bank maakt een bank object die de mogeklijkheden biedt om rekeningen te zoeken, geld op te nemen, te storten en over te maken.
     *
     * @param rekeningen       hier een ArrayList van rekening objecten
     */
    public Bank(ArrayList<Rekening> rekeningen) {
        this.rekeningen = rekeningen;
    }
    /**
     * De contructor voor Bank maakt een bank object die de mogeklijkheden biedt om rekeningen te zoeken, geld op te nemen, te storten en over te maken.
     * Deze constructor heeft tevens defaults
     * @param rekeningen       hier een ArrayList van rekening objecten
     * @param debitRekeningNr  dit bepaald welke debitrekening standaard ingeladen is bij het opstarten
     * @param creditRekeningNr dit bepaald welke debitrekening standaard ingeladen is bij het opstarten
     */
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
                break;
            }
            if (n == rekeningen.size() && rekening == null) {
                callbackMessage("Geen rekening gevonden.");
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

    public double getDebitRekeningSaldo() {
        return getRekening(debitRekeningNr).getSaldo();
    }

    public double getCreditRekeningSaldo() {
        return getRekening(creditRekeningNr).getSaldo();
    }

    public String setDebitRekeningNr(int rekeningNr) {
        String message = "unknown error";
        if (getRekening(rekeningNr) != null) {
            this.debitRekeningNr = rekeningNr;
            callbackMessage("Rekening gevonden");
        } else {
            callbackMessage("De rekening " + rekeningNr + " bestaat niet");
        }
        return message;
    }

    public String setCreditRekeningNr(int rekeningNr) {
        String message = "unknown error";
        if (getRekening(rekeningNr) != null) {
            this.creditRekeningNr = rekeningNr;
            callbackMessage("Rekening gevonden");
        } else {
            callbackMessage("De rekening " + rekeningNr + " bestaat niet");
        }
        return message;
    }

    /**
     * om een transactie in een rekening aan te vragen, dit kan zowel storten als opnemen zijn.
     * Tijdens het uitvoeren van de mutatie worden voorafgaand de volgende tests uitgevoerd:<br>
     * 1: Bedragen moet groter dan nul zijn<br>
     * 2: De accounttype die bij de request wordt getest om te zien of de Bank dezelfde hanteert als de GUI<br>
     * 3: De mutatietype bepaald de aard van de mutatie, storten dan wel opnemen<br>
     *
     * @param mutatieType    met mutatietype wordt de type mutattie bepaald: opnemen = 0 en storten = 1
     * @param rekeningNummer het nummer van de waarop de mutatie moet worden uitgevoerd
     * @param bedrag         het bedrag waarmee de mutatie moet worden uitgevoerd
     */
    public String requestTransactie(int mutatieType, int rekeningNummer, double bedrag) {

        String message = "unknown error";

        if (bedrag <= 0) {
            callbackMessage("Error: Alleen positieve bedragen zijn toegestaan");
        } else if (mutatieType == 0 && getRekening(rekeningNummer).getSaldo() - bedrag < 0) {
            callbackMessage("Er is helaas onvoldoende saldo voor deze mutatie");
        } else {
            switch (mutatieType) {
                //Opnemen = 0
                case 0:
                    getRekening(rekeningNummer).neemBedragOp(bedrag);
                    message = callbackMessage("De transactie is met succes uitgevoerd.");
                    break;
                //Storten = 1
                case 1:
                    getRekening(rekeningNummer).stortBedrag(bedrag);
                    message = callbackMessage("De transactie is met succes uitgevoerd.");
                    break;
                default:
                    message = callbackMessage("De mutatietype is onjuist.");
                    break;
            }
        }
        return message;
    }

    public String requestTransactie(int mutatieType, int debitRekeningNr, int creditRekeningNr, double bedrag) {

        String message = "unknown error";

        switch (mutatieType) {
            //Overmaken
            case 2:
                if (debitRekeningNr == getDebitRekeningNr() && creditRekeningNr == getCreditRekeningNr() && bedrag > 0 && getRekening(debitRekeningNr).getSaldo() - bedrag > 0) {
                    getRekening(debitRekeningNr).neemBedragOp(bedrag);
                    getRekening(creditRekeningNr).stortBedrag(bedrag);
                    message = callbackMessage("De transactie is succesvol uitgevoerd");
                } else if (mutatieType == 3) {
                    message = callbackMessage("Mutatie type is onjuist.");
                } else if (getRekening(debitRekeningNr).getSaldo() - bedrag < 0) {
                    message = callbackMessage("Er is onvoldoende saldo voor deze transactie");
                } else if (debitRekeningNr != getDebitRekeningNr() || creditRekeningNr != getCreditRekeningNr()) {
                    message = callbackMessage("Transactie niet gelukt controleer rekeningnummers");
                }
                break;
            default:
                message = callbackMessage("De mutatietype is onjuist.");
                break;
        }
        return message;
    }

    public String callbackMessage(String message) {
        System.out.println(message);
        return message;
    }
}
