// OPDRACHT D:

//Ontwerp en implementeer de klasse Voorstelling.
//
//Aanwijzingen
//
//– Gebruik een tweedimensionaal array van type Plaats om de zaalbezetting te representeren
//
// DONE – Geef de klasse een methode die de reserveringsstatus van een bepaalde plaats (rijnummer, stoelnummer) kan wijzigen van VRIJ naar GERESERVEERD of omgekeerd.
//
//– Geef de klasse een methode die een gegeven klant plaatst op alle plaatsen met status GERESERVEERD. Die plaatsen krijgen dan status BEZET en een link met de klant.
//
//– Geef de klasse een methode die alle plaatsen met status GERESERVEERD terugzet naar vrij (nodig voor het cancelen van een transactie).
//
//– Breid de klasse Plaats uit met methoden om bovenstaande methoden van Voorstelling te ondersteunen.

//-------------------------------------------------------------------------------------------------

// CLASS =
// TESTS =
// DOCS =

package theater;

import java.util.ArrayList;

public class Voorstelling {

    private String naam;
    private String datum;
    private ArrayList<Plaats> plaatsen = new ArrayList<>();
    private Theater theater;

    public Voorstelling(String naam, String datum, Theater theater) {
        this.naam = naam;
        this.datum = datum;
        for (int r = 1; r <= Theater.AANTALTRIJEN; r++) {
            for (int p = 1; p <= Theater.AANTALPERRIJ; p++) {
                plaatsen.add(new Plaats(r, p));
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

    protected int getStatusPlaatsenAantal(Plaats.Status status) {
        int aantal = 0;
        for (Plaats p : plaatsen) {
            if (status == p.getStatus()) {
                aantal++;
            }
        }
        return aantal;
    }

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

    protected void resetAlleReserveringen(){
        for(Plaats p: plaatsen){
            p.setStatus(Plaats.Status.VRIJ);
        }
    }

    protected void printVoorstelling(){
        System.out.println();
        String print = "";
        for (int r = 0; r < theater.AANTALTRIJEN; r++){
            print += "Rij " + (r+1) + ": ";
            for (int p = 0; p < theater.AANTALPERRIJ; p++){
                switch (plaatsen.get(r * theater.AANTALPERRIJ + p).getStatus()){
                    case VRIJ:
                        print += "0";
                        break;
                    case GERESERVEERD:
                        print += "-";
                        break;
                    case BEZET:
                        print += "*";
                        break;
                }
                if (p == theater.AANTALPERRIJ -1){
                    System.out.println(print);
                    print = "";
                }
            }
        }
    }
}
