// OPDRACHT D:

//Ontwerp en implementeer de klasse Voorstelling.
//
//Aanwijzingen
//
//– Gebruik een tweedimensionaal array van type Plaats om de zaalbezetting te representeren
//
// DONE – Geef de klasse een methode die de reserveringsstatus van een bepaalde plaats (rijnummer, stoelnummer) kan wijzigen van VRIJ naar GERESERVEERD of omgekeerd.
//
// DONE – Geef de klasse een methode die een gegeven klant plaatst op alle plaatsen met status GERESERVEERD. Die plaatsen krijgen dan status BEZET en een link met de klant.
//
// DONE – Geef de klasse een methode die alle plaatsen met status GERESERVEERD terugzet naar vrij (nodig voor het cancelen van een transactie).
//
// DONE – Breid de klasse Plaats uit met methoden om bovenstaande methoden van Voorstelling te ondersteunen.

//-------------------------------------------------------------------------------------------------

// CLASS = DONE
// TESTS =
// DOCS =

package theater;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Voorstelling {

    private String naam;
    private String datum;
    private ArrayList<Plaats> plaatsen = new ArrayList<>();
    private Plaats[][] voorstelling = new Plaats[Theater.AANTALTRIJEN][Theater.AANTALPERRIJ];
    private Theater theater;

    public Voorstelling(String naam, String datum) {
        this.naam = naam;
        this.datum = datum;
        for (int r = 0; r <= Theater.AANTALTRIJEN - 1; r++) {
            for (int p = 0; p <= Theater.AANTALPERRIJ - 1; p++) {
                plaatsen.add(new Plaats(r, p));
                voorstelling[r][p] = new Plaats(r + 1, p + 1);
            }
        }
    }

    public String getNaam() {
        return naam;
    }

    public String getDatum() {
        return datum;
    }

    protected void reserveer(int rij, int stoel) {
        Plaats plaats = voorstelling[rij-1][stoel-1];
        if (plaats.getStatus() == Plaats.Status.VRIJ) {
            plaats.setStatus(Plaats.Status.GERESERVEERD);
        } else {
            for (int r = rij; r < Theater.AANTALTRIJEN; r++) {
                for (int s = 0; s < Theater.AANTALPERRIJ; s++) {
                    if (voorstelling[r][s].getStatus() == Plaats.Status.VRIJ){
                        voorstelling[r][s].setStatus(Plaats.Status.GERESERVEERD);
                        System.out.println("Helaas, de gewenste plaats wa niet beschikbaar. We hebben vdeze plaats voor u gereserveerd: \n Rij: " + r + ", Plaats: " + s + "\n");
                        break;
                    }
                }
            }
        }
    }

    protected int getStatusPlaatsenAantal(Plaats.Status status) {
        int aantal = 0;
        for (Plaats[] rij : voorstelling) {
            for (Plaats plaats : rij) {
                if (status == plaats.getStatus()) {
                    aantal++;
                }
            }
        }
        return aantal;
    }

    protected void plaatsKlant(Klant klant) {
        int geplaatst = 0;
        if (geplaatst != getStatusPlaatsenAantal(Plaats.Status.GERESERVEERD)) {
            for (Plaats[] rij : voorstelling) {
                for (Plaats plaats : rij) {
                    if (Plaats.Status.GERESERVEERD == plaats.getStatus()) {
                       plaats.plaatsToekennen(klant.klantToString());
                       geplaatst ++;
                    }
                }
            }
        } else {
            System.out.println("Er zijn momenteel geen plaatsen gereserveerd");
        }
    }

    protected void resetAlleReserveringen() {
        for (Plaats[] rij : voorstelling) {
            for (Plaats plaats : rij) {
                if (Plaats.Status.GERESERVEERD == plaats.getStatus()) {
                    plaats.setStatus(Plaats.Status.VRIJ);
                }
            }
        }
    }

    public void printVoorstelling() {
        String print = "";
        DecimalFormat df = new DecimalFormat("00");
        for (int r = 0; r < Theater.AANTALTRIJEN; r++) {
            print += "Rij " + df.format(r + 1) + ": ";
            for (int p = 0; p < Theater.AANTALPERRIJ; p++) {
                Plaats plaats = voorstelling[r][p];
                switch (plaats.getStatus()) {
                    case VRIJ:
                        print += "V";
                        break;
                    case GERESERVEERD:
                        print += "R";
                        break;
                    case BEZET:
                        print += "B";
                        break;
                }
                if (p == voorstelling[0].length - 1) {
                    System.out.println(print);
                    print = "";
                }
            }
        }
    }

}
