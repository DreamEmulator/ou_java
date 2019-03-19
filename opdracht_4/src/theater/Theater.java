/*
TODO:
- Het is de bedoeling dat de bijgeleverde TheaterApplicatie.java je programma kan aansturen. Er zou dus, bijvoorbeeld, een nieuweVoorstelling en getAantalPlaatsen methoden in Theater moeten zijn.
X Hoewel het een leuk ontwerp is, is het hierdoor dus ook niet de bedoeling dat de dichtsbijzijnste plaats gezocht wordt als een niet vrije plaats wordt gereserveerd
X De functie getHoogsteKlantnummer is onnodig. Je slaat het hoogste klantnummer al op in een attribuut, deze kun je zo aanspreken.
X Het afhandelen van Klant en Voortelling objecten is de verantwoordelijkheid van de Theater klasse. Maw, er is geen reden om publieke getters te maken die deze objecten teruggeven.
X Dezelfde klant kan nu meerdere keren toegevoegd worden.
X Plaats heeft volgens het klasse diagram een referentie naar Klant. De link is dus geen klantInfo attribuut, maar gewoon een Klant attribuut.
? Het is de verantwoordelijkheid van Plaats om de status te wijzigen. Ik zou setStatus dus private maken en een publieke functie die de status naar gereserveerd en vrij zet (zoals nu ook voor plaatsBezetten). Op deze manier voorkom je ook het zetten op BEZET, zonder een klant.
X Ik heb met de corrector overlegd en het is alleen nodig om alle niet-triviale publieke methoden te testen (getters en setters die niks aanpassen kun je negeren).
- Breidt je testen uit. Test ook voor zaken die fout kunnen gaan (een stoel plaatsReserveren buiten de array, een klant zoeken die niet bestaat, etc.)
- Zorg dat alle methodes zo dicht mogelijk staan
*/
// Toelichting:
// Ik heb heb checks gemaakt voor nullPointers. Als deze falen schrijf ik wat uit naar, omdat anders de fout volledig verborgen blijft

package theater;

import java.util.ArrayList;

public class Theater {
    static int AANTALTRIJEN = 15;
    static int AANTALPERRIJ = 10;

    private int hoogsteklantnummer = 0;
    private String naam;

    private ArrayList<Klant> klanten = new ArrayList<>();

    private Voorstelling voorstelling;

    private Klant zoekKlant(String naam, String telefoon) {
        Klant klant = null;
        for (Klant k : klanten) {
            if (telefoon.equals(k.getTelefoon()) && naam.trim().toLowerCase().equals(k.getNaam().trim().toLowerCase())) {
                klant = k;
                break;
            }
        }
        return klant;
    }

    /**
     * Constructor functie voor Theater.
     *
     * @param naam neemt alleen een naam als parameter
     */
    public Theater(String naam) {
        this.naam = naam;
    }

    /**
     * Maakt een nieuwe voorstelling aan, nu is er nog maar ruimte voor 1 voorstelling.
     *
     * @param naam  naam van de voorstelling
     * @param datum datum dat deze plaatsvindt
     */
    public void nieuweVoorstelling(String naam, String datum) {
        voorstelling = new Voorstelling(naam, datum);
    }

    /**
     * Voegt een nieuwe klant toe aan de ArrayList van het theater.
     * Omdat er geen klanten verwijderd kunnen worden kunnen we de size van de ArrayList gebruiker als klantennummer
     *
     * @param naam     naam van de klant
     * @param telefoon telefoonnummer van de klant
     */
    public void nieuweKlant(String naam, String telefoon) {
        if (zoekKlant(naam, telefoon) == null) {
            klanten.add(new Klant(naam, hoogsteklantnummer + 1, telefoon));
            hoogsteklantnummer++;
        }
    }

    /**
     * Behoudt een plaats voor een klant.
     *
     * @param rij   nummer van de rij
     * @param stoel nummer van de stoel
     */
    public void reserveren(int rij, int stoel) {
        if (voorstelling != null) {
            voorstelling.reserveer(rij, stoel);
        }
    }

    /**
     * Als een klant bevestigd is wordt de klant geplaatst, deze is dan bezet.
     *
     * @param naam     naam van de klant
     * @param telefoon telefoonnummer van de klant
     */
    public void plaatsen(String naam, String telefoon) {
        Klant klant = zoekKlant(naam, telefoon);
        if (voorstelling != null && klant != null) {
            voorstelling.plaatsKlant(klant);
        }
    }

    /**
     * Als de klant uiteindelijk niet plaatst, moeten de reserveringen reset worden.
     */
    public void resetten() {
        if (voorstelling != null) {
            voorstelling.resetAlleReserveringen();
        }
    }

    /**
     * Geeft het aantal plaatsen van een bepaalde status terug.
     *
     * @param status geef de status mee die je zoekt
     * @return geeft het aantal plaatsen met deze status terug
     */
    public int getAantalPlaatsen(Plaats.Status status) {
        int aantal = 0;
        if (voorstelling != null) {
            aantal = voorstelling.getPlaatsenStatus(status);
        }
        return aantal;
    }

}
