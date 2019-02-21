package bank_domain;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Rekening> rekeningen;
    private int debitRekeningNr;
    private int creditRekeningNr;

    /**
     * De contructor voor Bank maakt een bank object die de mogeklijkheden biedt om rekeningen te zoeken, geld op te nemen, te storten en over te maken.
     * Er zijn twee constructors: eentje met en eentje zonder default actieve rekeningen
     *
     * @param rekeningen       hier de ArrayList van rekening objecten
     * @param debitRekeningNr  dit bepaald welke debitrekening standaard ingeladen is bij het opstarten
     * @param creditRekeningNr dit bepaald welke creditrekening standaard ingeladen is bij het opstarten
     */
    public Bank(ArrayList<Rekening> rekeningen, int debitRekeningNr, int creditRekeningNr) {
        this.rekeningen = rekeningen;
        this.debitRekeningNr = debitRekeningNr;
        this.creditRekeningNr = creditRekeningNr;
    }

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

    public int getDebitRekeningNr() {
        return this.debitRekeningNr;
    }

    public int getCreditRekeningNr() {
        return this.creditRekeningNr;
    }

    public String getDebitRekeningNaam() {
        return getRekening(debitRekeningNr).getRekeningNaam();
    }

    public String getCreditRekeningNaam() {
        return getRekening(creditRekeningNr).getRekeningNaam();
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
     * Dit is een overloaded method om transacties aan te kunnen vragen bij de bank.
     * @param mutatieType met mutatietype wordt de type mutatie bepaald: opnemen = 0, storten = 1 en 2 = overmaken
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
                case 0:
                    getRekening(rekeningNummer).neemBedragOp(bedrag);
                    return "De transactie is met succes uitgevoerd.";
                case 1:
                    getRekening(rekeningNummer).stortBedrag(bedrag);
                    return "De transactie is met succes uitgevoerd.";
                default:
                    return "De mutatietype is onjuist.";
            }
        }
    }

    public String requestTransactie(int mutatieType, int debitRekeningNr, int creditRekeningNr, double bedrag) {

        if (getRekening(debitRekeningNr) == null || getRekening(creditRekeningNr) == null) {
            return "Error: Een van de rekeningen bestaat niet";
        } else if (bedrag <= 0) {
            return "Error: Er mogen alleen positieve bedragen gestort worden";
        }else if (mutatieType != 2) {
            return "Mutatie type is onjuist.";
        } else if (getRekening(debitRekeningNr).getSaldo() - bedrag < 0) {
            return "Er is onvoldoende saldo voor deze transactie";
        } else if (getDebitRekeningNr() != debitRekeningNr || getCreditRekeningNr() != creditRekeningNr) {
            return "Transactie niet gelukt controleer rekeningnummers";
        } else {
            getRekening(debitRekeningNr).neemBedragOp(bedrag);
            getRekening(creditRekeningNr).stortBedrag(bedrag);
            return "De transactie is succesvol uitgevoerd";
        }
    }
}