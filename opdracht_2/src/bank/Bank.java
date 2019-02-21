package bank;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Rekening> rekeningen;
    protected int debitRekeningNr;
    protected int creditRekeningNr;

    /**
     * De contructor voor Bank maakt een bank object die de mogeklijkheden biedt om rekeningen te zoeken, geld op te nemen, te storten en over te maken.
     *
     * @param rekeningen hier een ArrayList van rekening objecten
     */
    public Bank(ArrayList<Rekening> rekeningen) {
        this.rekeningen = rekeningen;
    }

    /**
     * De contructor voor Bank maakt een bank object die de mogeklijkheden biedt om rekeningen te zoeken, geld op te nemen, te storten en over te maken.
     * Deze constructor heeft tevens defaults
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
        for (Rekening i : rekeningen) {
            if (rekeningNr == i.getRekeningNr()) {
                rekening = i;
                break;
            }
        }
        return rekening;
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
        } else {
            return "De rekening " + rekeningNr + " bestaat niet";
        }
    }

    public String setCreditRekeningNr(int rekeningNr) {
        if (getRekening(rekeningNr) != null) {
            this.creditRekeningNr = rekeningNr;
            return "Rekening gevonden";
        } else {
            return "De rekening " + rekeningNr + " bestaat niet";
        }
    }

    /**
     * om een transactie in een rekening aan te vragen, dit kan zowel storten als opnemen zijn.
     * Tijdens het uitvoeren van de mutatie worden voorafgaand de volgende tests uitgevoerd:<br>
     * 1: Bedragen moet groter dan nul zijn<br>
     * 2: Het mutatietype moet kloppen<br>
     *
     * @param mutatieType    met mutatietype wordt de type mutattie bepaald: opnemen = 0 en storten = 1
     * @param rekeningNummer het nummer van de waarop de mutatie moet worden uitgevoerd
     * @param bedrag         het bedrag waarmee de mutatie moet worden uitgevoerd
     */
    public String requestTransactie(int mutatieType, int rekeningNummer, double bedrag) {

        if (getRekening(rekeningNummer) == null) {
            return "Error: Deze rekening bestaat niet";
        } else if (bedrag <= 0) {
            return "Error: Alleen positieve bedragen zijn toegestaan";
        } else if (mutatieType == 0 && getRekening(rekeningNummer).getSaldo() - bedrag < 0) {
            return "Er is helaas onvoldoende saldo voor deze mutatie";
        } else {
            switch (mutatieType) {
                //Opnemen = 0
                case 0:
                    getRekening(rekeningNummer).neemBedragOp(bedrag);
                    return "De transactie is met succes uitgevoerd.";
                //Storten = 1
                case 1:
                    getRekening(rekeningNummer).stortBedrag(bedrag);
                    return "De transactie is met succes uitgevoerd.";
                default:
                    return "De mutatietype is onjuist.";
            }
        }
    }

    /**
     * dit is een overloaded method om over te kunnen maken
     * Tijdens het uitvoeren van de mutatie worden voorafgaand de volgende tests uitgevoerd:<br>
     * 1: Bedragen moet groter dan nul zijn<br>
     * 2: Het mutatietype moet kloppen<br>
     *
     * @param mutatieType    met mutatietype wordt de type mutattie bepaald: opnemen = 0 en storten = 1
     * @param debitRekeningNr het nummer van de waarop de mutatie moet worden uitgevoerd
     * @param creditRekeningNr het nummer van de waarop de mutatie moet worden uitgevoerd
     * @param bedrag         het bedrag waarmee de mutatie moet worden uitgevoerd
     */
    public String requestTransactie(int mutatieType, int debitRekeningNr, int creditRekeningNr, double bedrag) {

        //Overmaken
        if (getRekening(debitRekeningNr) == null || getRekening(creditRekeningNr) == null) {
            return "Error: Een van de rekeningen bestaat niet";
        } else if (mutatieType != 2) {
            return "Mutatie type is onjuist.";
        } else if (getRekening(debitRekeningNr).getSaldo() - bedrag < 0) {
            return "Er is onvoldoende saldo voor deze transactie";
        } else if (debitRekeningNr != debitRekeningNr || creditRekeningNr != creditRekeningNr) {
            return "Transactie niet gelukt controleer rekeningnummers";
        } else {
            getRekening(debitRekeningNr).neemBedragOp(bedrag);
            getRekening(creditRekeningNr).stortBedrag(bedrag);
            return "De transactie is succesvol uitgevoerd";
        }

    }
}
