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
            saldo += bedrag;
            System.out.println("Overschrijven is gelukt het nieuwe saldo is: " + saldo);
        } else {
            System.out.println("Overschrijven is NIET gelukt: onvoldoende saldo");
        }
    }


}
