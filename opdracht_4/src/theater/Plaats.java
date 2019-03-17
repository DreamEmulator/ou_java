package theater;

public class Plaats {

    public enum Status {VRIJ, BEZET, GERESERVEERD};
    private Status status;
    private int rijnummer;
    private int stoelnummer;
    private Klant klant;

    /**
     * Constructor voor de Plaats, deze accepteert de rij en stoel als integers voor de locatie in de zaal.
     * @param rijnummer integer
     * @param stoelnummer integer
     */
    public Plaats(int rijnummer, int stoelnummer) {
        this.status = status.VRIJ;
        this.rijnummer = rijnummer;
        this.stoelnummer = stoelnummer;
    }

    /**
     * Getter, geeft de status van de plaats terug
     * @return status enum
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Getter, geeft de rijnummer terug
     * @return integer
     */
    public int getRijnummer() {
        return rijnummer;
    }

    /**
     * Getter, geeft de stoelnummer terug
     * @return integer
     */
    public int getStoelnummer() {
        return stoelnummer;
    }

    /**
     * Set de status van de plaats op GERESERVEERD
     */
    public void reserveren(){
        if (Plaats.Status.VRIJ == status) {
            status = Status.GERESERVEERD;
        }
    }

    public void vrijmaken (){
        if (Plaats.Status.GERESERVEERD == status) {
            status = Status.VRIJ;
        }
    }

    /**
     * Zet de status voor de plaats naar bezet en slaat de info van die klant op voor de plaats.
     * @param klant wordt aan de klant attribuut van plaats toegekend
     */
    public void plaatsToekennen(Klant klant){
        if (Plaats.Status.GERESERVEERD == status) {
            status = Status.BEZET;
            this.klant = klant;
        }
    }

    /**
     * Geeft de plaats terug als string
     * @return plaats als string
     */
    public String plaatsToString() {
        return "Plaats{" +
                "status=" + status +
                ", rijnummer=" + rijnummer +
                ", stoelnummer=" + stoelnummer +
                ", klant='" + klant.getNaam() + '\'' +
                '}';
    }
}
