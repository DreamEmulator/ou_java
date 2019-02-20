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

    public double getDebitRekeningSaldo() {
        return getRekening(debitRekeningNr).getSaldo();
    }

    public double getCreditRekeningSaldo() {
        return getRekening(creditRekeningNr).getSaldo();
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

    /**
     * requestMutatie is een public method om een mutatie in een rekening aan te vragen, dit kan zowel storten als opnemen zijn.
     * Tijdens het uitvoeren van de mutatie worden voorafgaand de volgende tests uitgevoerd:<br>
     * 1: Bedragen moet groter dan nul zijn<br>
     * 2: De accounttype die bij de request wordt getest om te zien of de Bank dezelfde hanteert als de GUI<br>
     * 3: De mutatietype bepaald de aard van de mutatie, storten dan wel opnemen<br>
     *
     * @param mutatieType    met mutatietype wordt de type mutattie bepaald: opnemen = 0 en storten = 1
     * @param accountType    met accountType wordt de type rekening gecontroleerd, dit is om eventuele wijzigingen in de GUI af te vangen, 0 = debit en 1 = credit
     * @param rekeningNummer het nummer van de waarop de mutatie moet worden uitgevoerd
     * @param bedrag         het bedrag waarmee de mutatie moet worden uitgevoerd
     */
    public String requestMutatie(int mutatieType, int accountType, int rekeningNummer, double bedrag) {

        String text = "unknown error";

        if (bedrag < 0) {
            text = "Error: Negatieve bedragen zijn niet toegestaan";
        } else if (mutatieType == 0 && getRekening(rekeningNummer).getSaldo() - bedrag < 0) {
            text = "Er is helaas onvoldoende saldo voor deze transactie";
        } else if (accountType == 0 && rekeningNummer != getDebitRekeningNr() || accountType == 1 && rekeningNummer != getCreditRekeningNr()) {
            text = "Error: Het juiste rekeningnummer staat niet in beeld, zoek opnieuw de rekening...";
        } else {
            switch (mutatieType) {
                //Opnemen = 0
                case 0:
                    switch (accountType) {
                        //Debit = 0
                        case 0:
                            getRekening(getDebitRekeningNr()).neemBedragOp(bedrag);
                            text = "De transactie is met succes uitgevoerd.";
                            break;
                        //Credit = 1
                        case 1:
                            getRekening(getCreditRekeningNr()).neemBedragOp(bedrag);
                            text = "De transactie is met succes uitgevoerd.";
                            break;
                    }
                    break;
                case 1:
                    switch (accountType) {
                        //Debit = 0
                        case 0:
                            getRekening(getDebitRekeningNr()).stortBedrag(bedrag);
                            text = "De transactie is met succes uitgevoerd.";
                            break;
                        //Credit = 1
                        case 1:
                            getRekening(getCreditRekeningNr()).stortBedrag(bedrag);
                            text = "De transactie is met succes uitgevoerd.";
                            break;
                    }
                    break;
            }
        }
        return message(text);
    }

    public String requestTransactie(int debitRekeningNr, int creditRekeningNr, double bedrag) {

        if (debitRekeningNr == getDebitRekeningNr() && creditRekeningNr == getCreditRekeningNr()) {
            Rekening debitRekening = getRekening(debitRekeningNr);
            Rekening creditRekening = getRekening(creditRekeningNr);
            //Controleer of bedrag is toegestaan
            if (bedrag > 0 && debitRekening.getSaldo() - bedrag > 0) {
                debitRekening.neemBedragOp(bedrag);
                creditRekening.stortBedrag(bedrag);
                return message("De transactie is succesvol uitgevoerd");
            } else {
                return message("Transactie niet gelukt controleer het bedrag");
            }
        }
        return "Transactie niet gelukt controleer rekeningnummers";
    }

    public String message(String message) {
        System.out.println(message);
        return message;
    }
}
