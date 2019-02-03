package rekening;

public class Rekening {

    String naam;
    int rekeningNr;
    double saldo;

    public Rekening(int rekeningNr, String naam, double saldo) {
        this.rekeningNr = rekeningNr;
        this.naam = naam;
        this.saldo = saldo;
    }

    public String getNaam() {
        return this.naam;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getRekeningNr() {
        return this.rekeningNr;
    }


    public void stortBedrag(double stortBedrag) {
        if (getSaldo() + stortBedrag > 0) {
            double huidigSaldo = getSaldo();
            double nieuwSaldo = huidigSaldo + stortBedrag;

            saldo = nieuwSaldo;
        } else {
            System.out.println("Onvoldoende saldo voor deze transactie");
        }
    }

    public void neemBedragOp(double opneemBedrag) {
        if (getSaldo() - opneemBedrag > 0) {
            double huidigSaldo = getSaldo();
            double nieuwSaldo = huidigSaldo - opneemBedrag;

            saldo = nieuwSaldo;
        } else {
            System.out.println("Onvoldoende saldo voor deze transactie");
        }
    }
}
