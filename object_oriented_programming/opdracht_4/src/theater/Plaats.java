// Toelichting:
// Plaats heeft geen publieke methoden omdat alle toegang via Theater moet gaan

package theater;

public class Plaats {

    public enum Status {VRIJ, BEZET, GERESERVEERD}

    private Status status;
    private int rijnummer;
    private int stoelnummer;
    private Klant klant;

    /**
     * Constructor voor de Plaats, deze accepteert de rij en stoel als integers voor de locatie in de zaal.
     *
     * @param rijnummer   integer
     * @param stoelnummer integer
     */
    protected Plaats(int rijnummer, int stoelnummer) {
        this.status = Plaats.Status.VRIJ;
        this.rijnummer = rijnummer;
        this.stoelnummer = stoelnummer;
    }

    protected Status getStatus() {
        return status;
    }

    /**
     * Set de status van de plaats op GERESERVEERD.
     */
    protected void plaatsReserveren() {
        if (Status.VRIJ == status) {
            status = Status.GERESERVEERD;
        }
    }

    /**
     * Set de status van de plaats op VRIJ.
     */
    protected void plaatVrijmaken() {
        if (Status.GERESERVEERD == status) {
            status = Status.VRIJ;
        }
    }

    /**
     * Zet de status voor de plaats naar bezet en slaat de info van die klant op voor de plaats.
     *
     * @param klant wordt aan de klant attribuut van plaats toegekend
     */
    protected void plaatsBezetten(Klant klant) {
        if (Status.GERESERVEERD == status) {
            status = Status.BEZET;
            this.klant = klant;
        }
    }

    /**
     * Geeft de plaats terug als string.
     *
     * @return plaats als string
     */
    protected String plaatsToString() {
        return "Plaats{" +
                "status=" + status +
                ", rijnummer=" + rijnummer +
                ", stoelnummer=" + stoelnummer +
                ", klant='" + klant.getNaam() + '\'' +
                '}';
    }
}