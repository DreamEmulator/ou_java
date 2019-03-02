package theater;

public class Plaats {

    public enum Status {VRIJ, BEZET, GERESERVEERD};
    private Status status;
    private int rijnummer;
    private int stoelnummer;

    public Plaats(Status status, int rijnummer, int stoelnummer) {
        this.status = status;
        this.rijnummer = rijnummer;
        this.stoelnummer = stoelnummer;
    }

    public Status getStatus() {
        return status;
    }

    public int getRijnummer() {
        return rijnummer;
    }

    public int getStoelnummer() {
        return stoelnummer;
    }
}
