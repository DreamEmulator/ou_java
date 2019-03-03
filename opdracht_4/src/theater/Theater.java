// OPDRACHT B:

// Implementeer de klasse Theater.

// DONE - Geef deze klasse een constructor met één parameter, namelijk de naam van het theater.

// Ontwerp en implementeer methoden voor dit beheer van klanten :
//
// het maken van een nieuwe klant, het uitgeven van een nieuw klantnummer
//
// het opzoeken van een klant op basis van naam en telefoonnummer.
//
// NOTE: We laten het verwijderen van klanten buiten beschouwing

//-------------------------------------------------------------------------------------------------

// OPDRACHT E:

// Breid de klasse Theater uit. Geef het theater een voorstelling.

//De user interface zal in de uiteindelijke versie van dit programma een associatie met Theater bevatten.

// Geef de klasse Theater daarom een aantal methoden zodat alle beschreven handelingen (reserveren, plaatsen, resetten) door middel van aanroepen op Theater kunnen worden uitgevoerd.

//-------------------------------------------------------------------------------------------------

// CLASS =
// TESTS =
// DOCS =

package theater;

import java.util.ArrayList;

public class Theater {
    public final static int AANTALTRIJEN = 15;
    public final static int AANTALPERRIJ = 10;
    private int hoogsteklantnummer;
    private String naam;

    //TODO: Check if this is the intended way to store the klanten
    private ArrayList<Klant> klanten = new ArrayList<>();

    public Theater(String naam) {
        this.naam = naam;
    }

    public void nieuweKlant (String naam, int telefoon) {
        klanten.add(new Klant(naam, klanten.size() + 1, telefoon));
        hoogsteklantnummer = klanten.size();
    }

    public ArrayList<Klant> getKlanten() {
        return klanten;
    }

    public int getHoogsteklantnummer() {
        return hoogsteklantnummer;
    }

    public String getNaam() {
        return naam;
    }
}
