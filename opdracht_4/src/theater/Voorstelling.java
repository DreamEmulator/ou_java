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
        //REMOVE
        for (int r = 1; r <= Theater.AANTALTRIJEN; r++) {
            for (int p = 1; p <= Theater.AANTALPERRIJ; p++) {
                plaatsen.add(new Plaats(r, p));
            }
        }

        for (int r = 0; r <= Theater.AANTALTRIJEN - 1; r++) {
            for (int p = 0; p <= Theater.AANTALPERRIJ - 1; p++) {
                plaatsen.add(new Plaats(r, p));
                voorstelling[r][p] = new Plaats(r+1, p+1);
            }
        }
    }

    public String getNaam() {
        return naam;
    }

    public String getDatum() {
        return datum;
    }

    //REFACTOR
    protected void reserveer(int rij, int stoel) {
        int plaats = ((rij - 1) * Theater.AANTALPERRIJ + stoel) - 1;
        if (plaatsen.get(plaats).getStatus() != Plaats.Status.GERESERVEERD) {
            plaatsen.get(plaats).setStatus(Plaats.Status.GERESERVEERD);
        } else {
            for (int p = plaats; p < (Theater.AANTALTRIJEN * Theater.AANTALPERRIJ); p++) {
                if (plaatsen.get(p).getStatus() == Plaats.Status.VRIJ) {
                    plaatsen.get((rij - 1) * Theater.AANTALPERRIJ + stoel).setStatus(Plaats.Status.GERESERVEERD);
                    break;
                }
            }
            System.out.println("Helaas: Deze plaats is al gereserveerd, we hebben de eerste volgende vrije plaats gereserveerd");
        }
    }

    //REFACTOR
    protected int getStatusPlaatsenAantal(Plaats.Status status) {
        int aantal = 0;
        for (Plaats p : plaatsen) {
            if (status == p.getStatus()) {
                aantal++;
            }
        }
        return aantal;
    }

    //REFACTOR
    protected void plaatsKlant(Klant klant) {
        if (getStatusPlaatsenAantal(Plaats.Status.GERESERVEERD) != 0) {
            for (int p = 0; p < plaatsen.size(); p++) {
                if (Plaats.Status.GERESERVEERD == plaatsen.get(p).getStatus()) {
                    plaatsen.get(p).plaatsToekennen(klant.klantToString());
                }
            }
        } else {
            System.out.println("Er zijn momenteel geen plaatsen gereserveerd");
        }
    }

    //REFACTOR
    protected void resetAlleReserveringen() {
        for (Plaats p : plaatsen) {
            if (Plaats.Status.GERESERVEERD == p.getStatus()) {
                p.setStatus(Plaats.Status.VRIJ);
            }
        }
    }

    public void printVoorstelling(){
        for (int r = 0; r < voorstelling.length; r++){
            for (int p = 0; p < voorstelling[0].length; p++){
                Plaats plaats = voorstelling[r][p];
                System.out.println("Rij: " + plaats.getRijnummer() + ", Plaats: " + plaats.getStoelnummer() + ", Status: " + plaats.getStatus());
            }
        }


    }

    protected void printVerkochtePlaatsen() {
        for (Plaats p : plaatsen) {
            if (Plaats.Status.BEZET == p.getStatus()) {
                System.out.println(p.plaatsToString());
            }
        }
    }
}
