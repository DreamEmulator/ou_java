// OPDRACHT D:

//Ontwerp en implementeer de klasse Voorstelling.
//
//Aanwijzingen
//
//– Gebruik een tweedimensionaal array van type Plaats om de zaalbezetting te representeren
//
//– Geef de klasse een methode die de reserveringsstatus van een bepaalde plaats (rijnummer, stoelnummer) kan wijzigen van VRIJ naar GERESERVEERD of omgekeerd.
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

import java.util.Date;

public class Voorstelling {

    private String naam;
    private Date datum;

    public Voorstelling(String naam, Date datum) {
        this.naam = naam;
        this.datum = datum;
    }

    public String getNaam() {
        return naam;
    }

    public Date getDatum() {
        return datum;
    }
}
