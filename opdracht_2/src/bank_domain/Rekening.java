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

    public String getRekeningNaam() {
        return naam;
    }

    public int getRekeningNr() {
        return rekeningNr;
    }

    public double getSaldo() {
        return saldo;
    }

    void stortBedrag(double stortBedrag) {
        saldo += stortBedrag;
    }

    void neemBedragOp(double opneemBedrag) {
        saldo -= opneemBedrag;
    }
}