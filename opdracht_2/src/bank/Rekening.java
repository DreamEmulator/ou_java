package bank;

public class Rekening {

    private String naam;
    private int rekeningNr;
    private double saldo;

    public Rekening(int rekeningNr, String naam, double saldo) {
        this.rekeningNr = rekeningNr;
        this.naam = naam;
        this.saldo = saldo;
    }

    protected String getNaam() {
        return this.naam;
    }

    protected double getSaldo() {
        return this.saldo;
    }

    protected int getRekeningNr() {
        return this.rekeningNr;
    }

    protected void stortBedrag(double stortBedrag) {
        if (getSaldo() + stortBedrag > 0) {
            double huidigSaldo = getSaldo();
            double nieuwSaldo = huidigSaldo + stortBedrag;

            saldo = nieuwSaldo;
        } else {
            System.out.println("Het is niet toegestaan negatieve bedragen te storten!");
        }
    }

    protected void neemBedragOp(double opneemBedrag) {
        if (getSaldo() - opneemBedrag > 0) {
            double huidigSaldo = getSaldo();
            double nieuwSaldo = huidigSaldo - opneemBedrag;

            saldo = nieuwSaldo;
        } else {
            System.out.println("Onvoldoende saldo voor deze transactie");
        }
    }
}
