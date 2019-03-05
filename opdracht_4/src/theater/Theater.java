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

// CLASS = DONE
// TESTS = DONE
// DOCS = DONE

package theater;

import java.util.ArrayList;

public class Theater {
    public final static int AANTALTRIJEN = 15;
    public final static int AANTALPERRIJ = 10;
    private int hoogsteklantnummer = 0;
    private String naam;

    private ArrayList<Klant> klanten = new ArrayList<>();
    private Voorstelling voorstelling;

    /**
     * Constructor functie voor Theater.
     * @param naam neemt alleen een naam als parameter
     */
    public Theater(String naam){
        this.naam = naam;
    }

    /**
     * Maakt een nieuwe voorstelling aan, nu is er nog maar ruimte voor 1 voorstelling.
     * @param naam naam van de voorstelling
     * @param datum datum dat deze plaatsvindt
     */
    public void nieuweVoorstellijng (String naam, String datum){
        voorstelling = new Voorstelling(naam, datum);
    }

    /**
     * Verleend toegang to de naam van het theater.
     * @return naam van theater
     */
    public String getNaam(){
        return naam;
    }

    /**
     * Voegt een nieuwe klant toe aan de ArrayList van het theater.
     * Omdat er geen klanten verwijderd kunnen worden kunnen we de size van de ArrayList gebruiker als klantennummer
     * @param naam naam van de klant
     * @param telefoon telefoonnummer van de klant
     */
    public void nieuweKlant (String naam, int telefoon){
        klanten.add(new Klant(naam, getHoogsteklantnummer() + 1, telefoon));
        hoogsteklantnummer++;
    }

    /**
     * Geeft toegang tot een klant, hiervoor maken we gebruik van twee parameters naam en telefoon.
     * @param naam naam van de gezochte klant
     * @param telefoon telefoon van de gezochte klant
     * @return
     */
    public Klant getKlant (String naam, int telefoon){
        Klant klant = null;
        for (Klant k : klanten){
            if (telefoon == k.getTelefoon() && naam.trim().toLowerCase().equals(k.getNaam().trim().toLowerCase())){
                klant = k;
                break;
            }
        }
        return klant;
    }

    /**
     * Geeft toegang tot de voorstelling die op dat moment draait in het theater
     * @return
     */
    public Voorstelling getVoorstelling(){
        return voorstelling;
    }

    /**
     * Geeft het hoogste klantnummer terung.
     * @return hoogste klantnummer
     */
    public int getHoogsteklantnummer(){
        return hoogsteklantnummer;
    }

    /**
     * Behoudt een plaats voor een klant.
     * @param rij nummer van de rij
     * @param stoel nummer van de stoel
     */
    public void reserveer (int rij, int stoel){
        voorstelling.reserveer(rij, stoel);
    }

    /**
     * Als een klant bevestigd is wordt de klant geplaatst, deze is dan bezet.
     * @param naam naam van de klant
     * @param telefoon telefoonnummer van de klant
     */
    public void plaatsKlant(String naam, int telefoon){
        voorstelling.plaatsKlant(getKlant(naam, telefoon));
    }

    /**
     * Als de klant uiteindelijk niet plaatst, moeten de reserveringen reset worden.
     */
    public void resetAlleReserveringen(){
        voorstelling.resetAlleReserveringen();
    }

    /**
     * Geeft het aantal plaatsen van een bepaalde status terug.
     * @param status geef de status mee die je zoekt
     * @return geeft het aantal plaatsen met deze status terug
     */
    public int getStatusPlaatsenAantal(Plaats.Status status){
        return voorstelling.getStatusPlaatsenAantal(status);
    }

    /**
     * Print de voorstelling als diagram.
     * V = Vrij
     * R = Gereserveerd
     * B = Bezet
     */
    public void printVoorstelling(){
        voorstelling.printVoorstelling();
    }

}