public class Rekening {

    int rekeningNr;
    String naam;
    double saldo;

    public Rekening(int rekeningNr, String naam, double saldo) {
        this.rekeningNr = rekeningNr;
        this.naam = naam;
        this.saldo = saldo;
    }

    protected String getNaam (){
        return this.naam;
    }
    protected double getSaldo () { return this.saldo; }
    protected int getRekeningNr () { return this.rekeningNr; }


    protected void setSaldo (double bedrag) {
        if (saldo + bedrag > 0 ){
            saldo = bedrag;
        } else {
            System.out.println("Onvoldoende saldo");
        }
    }

}
