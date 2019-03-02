package theater;

public class Theater {
    public final static int AANTALTRIJEN = 15;
    public final static int AANTALPERRIJ = 10;
    private int hoogsteklantnummer;
    private String naam;

    public Theater(int hoogsteklantnummer, String naam) {
        this.hoogsteklantnummer = hoogsteklantnummer;
        this.naam = naam;
    }

    public int getHoogsteklantnummer() {
        return hoogsteklantnummer;
    }

    public String getNaam() {
        return naam;
    }
}
