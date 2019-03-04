// OPDRACHT B:

// Implementeer de klasse Theater.

// DONE - Geef deze klasse een constructor met één parameter, namelijk de naam van het theater.

// Ontwerp en implementeer methoden voor dit beheer van klanten :
//
// DONE - het maken van een nieuwe klant, het uitgeven van een nieuw klantnummer
//
// DONE - het opzoeken van een klant op basis van naam en telefoonnummer.
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

    private ArrayList<Klant> klanten = new ArrayList<>();
    private Voorstelling voorstelling;


    public Theater(String naam){
        this.naam = naam;
    }

    public void nieuweVoorstellijng (String naam, String datum){
        voorstelling = new Voorstelling(naam, datum);
    }

    public String getNaam(){
        return naam;
    }

    public void nieuweKlant (String naam, int telefoon){
        klanten.add(new Klant(naam, klanten.size() + 1, telefoon));
        hoogsteklantnummer = klanten.size();
    }

    public Klant getKlant (String naam, int telefoon){
        Klant klant = null;
        for (Klant k : klanten){
            if (telefoon == k.getTelefoon() && naam.equals(k.getNaam())){
                klant = k;
                break;
            }
        }
        return klant;
    }

    public Voorstelling getVoorstelling(){
        return voorstelling;
    }

    public int getHoogsteklantnummer(){
        return hoogsteklantnummer;
    }

    public void reserveer (int rij, int stoel){
        voorstelling.reserveer(rij, stoel);
    }

    public void plaatsKlant(String naam, int telefoon){
        voorstelling.plaatsKlant(getKlant(naam, telefoon));
    }

    public void resetAlleReserveringen(){
        voorstelling.resetAlleReserveringen();
    }

    public int getStatusPlaatsenAantal(Plaats.Status status){
        return voorstelling.getStatusPlaatsenAantal(status);
    }

    public void printVoorstelling(){
        voorstelling.printVoorstelling();
    }

    public void printVerkochtePlaatsen(){
        voorstelling.printVerkochtePlaatsen();
    }
}