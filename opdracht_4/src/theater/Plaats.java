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

// CLASS =
// TESTS =
// DOCS =

package theater;

public class Plaats {

    public enum Status {VRIJ, BEZET, GERESERVEERD};
    private Status status;
    private int rijnummer;
    private int stoelnummer;
    private String besteldDoor;

    public Plaats(int rijnummer, int stoelnummer) {
        this.status = status.VRIJ;
        this.rijnummer = rijnummer;
        this.stoelnummer = stoelnummer;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public void plaatsToekennen(String klant){
        this.setStatus(Status.BEZET);
        this.besteldDoor = klant;
    }

    public String plaatsToString() {
        return "Plaats{" +
                "status=" + status +
                ", rijnummer=" + rijnummer +
                ", stoelnummer=" + stoelnummer +
                ", besteldDoor='" + besteldDoor + '\'' +
                '}';
    }
}
