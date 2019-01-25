public class Rekening {

    int rekeningNr;
    String naam;
    double saldo;

    public Rekening(int rekeningNr, String naam, double saldo) {
        this.rekeningNr = rekeningNr;
        this.naam = naam;
        this.saldo = saldo;
    }

    public String getNaam (){
        return this.naam;
    }
}
