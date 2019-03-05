// OPDRACHT C:

// Ontwerp en implementeer de klasse Plaats:
// Voor de status van een Plaats gebruiken we een enumeratietype Status met mogelijke waarden VRIJ, GERESERVEERD en BEZET
// (een plaats is gereserveerd als een klant bezig is met het bestellen van kaarten maar de bestelling nog niet is afgerond).
//
// Aanwijzingen:
//
// DONE - Geef de klasse een constructor met als parameters rijnummer en stoelnummer; de beginstatus wordt VRIJ.
//
// DONE - Geef de klasse een methode toString die een stringrepresentatie van de plaats teruggeeft

//-------------------------------------------------------------------------------------------------

// CLASS = DONE
// TESTS = DONE
// DOCS =

package theater;

public class Plaats {

    public enum Status {VRIJ, BEZET, GERESERVEERD};
    private Status status;
    private int rijnummer;
    private int stoelnummer;
    private String klantInfo;

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
     * Setter om de status van de plaats te manipuleren;
     * @param status gewenste status
     */
    public void setStatus(Status status) {
        this.status = status;
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
     * Zet de status voor de plaats naar bezet en slaat de info van die klant op voor de plaats.
     * @param klantInfo de string die de klant info weergeeft die opgeslagen moet worden
     */
    public void plaatsToekennen(String klantInfo){
        this.setStatus(Status.BEZET);
        this.klantInfo = klantInfo;
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
                ", klantInfo='" + klantInfo + '\'' +
                '}';
    }
}
