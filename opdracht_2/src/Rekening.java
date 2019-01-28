public class Rekening {

    String naam;
    int rekeningNr;
    double saldo;

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

    protected void setSaldo(double bedrag) {
        if (saldo + bedrag > 0) {
            saldo = bedrag;
        } else {
            System.out.println("Onvoldoende saldo");
        }
    }

    public void stortBedrag(double stortBedrag) {
        if (getSaldo() + stortBedrag > 0) {
            double huidigSaldo = getSaldo();
            double nieuwSaldo = huidigSaldo + stortBedrag;

            setSaldo(nieuwSaldo);
        } else {
            System.out.println("Onvoldoende saldo voor deze transactie");
        }
    }

    public void neemBedragOp(double opneemBedrag) {
        if (getSaldo() - opneemBedrag > 0) {
            double huidigSaldo = getSaldo();
            double nieuwSaldo = huidigSaldo - opneemBedrag;

            setSaldo(nieuwSaldo);
        } else {
            System.out.println("Onvoldoende saldo voor deze transactie");
        }
    }
}
