package bank_domain;

public class Bank {
    private Rekening[] rekeningen = {
            new Rekening(1111, "Bart", 14.56),
            new Rekening(1234, "Freek", 24.63),
            new Rekening(2222, "Tina", 15.67),
            new Rekening(2345, "Sebas", 5.67),
            new Rekening(3333, "Beatrix", 10209.67)
    };

    public Rekening zoekRekening(int rekeningNr) {
        Rekening rekening = null;
        for (Rekening i : rekeningen) {
            if (rekeningNr == i.getRekeningNr()) {
                rekening = i;
                break;
            }
        }
        return rekening;
    }

    public void storten(int rekening, double bedrag) {
        if (bedrag > 0 && zoekRekening(rekening) != null) {
            zoekRekening(rekening).stortBedrag(bedrag);
        }
    }

    public void opnemen(int rekening, double bedrag) {
        if (bedrag > 0 && zoekRekening(rekening) != null && zoekRekening(rekening).getSaldo() - bedrag >= 0) {
            zoekRekening(rekening).neemBedragOp(bedrag);
        }
    }

    public void overmaken(int debitRekening, int creditRekening, double bedrag) {
        if (bedrag > 0 && zoekRekening(debitRekening) != null && zoekRekening(creditRekening) != null && zoekRekening(debitRekening).getSaldo() - bedrag >= 0) {
            zoekRekening(debitRekening).neemBedragOp(bedrag);
            zoekRekening(creditRekening).stortBedrag(bedrag);
        }
    }
}