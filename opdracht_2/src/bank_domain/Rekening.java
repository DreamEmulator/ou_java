package bank_domain;

public class Rekening {

    private String naam;
    private int rekeningNr;
    private double saldo;

    public Rekening(int rekeningNr, String naam, double saldo) {
        this.rekeningNr = rekeningNr;
        this.naam = naam;
        this.saldo = saldo;
    }

    public String getNaam() {
        return naam;
    }

    public int getRekeningNr() {
        return rekeningNr;
    }

    public double getSaldo() {
        return saldo;
    }

//    Discussiepunt: door de volgende methodes op "protected" te zetten kan alleen de Bank de rekeningen manipuleren
    protected void stortBedrag(double stortBedrag) {
        saldo += stortBedrag;
    }

    protected void neemBedragOp(double opneemBedrag) {
        saldo -= opneemBedrag;
    }
}