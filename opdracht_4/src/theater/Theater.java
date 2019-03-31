// Toelichting:
// Het aantal plaatsen en aantal rijen is public static want ik wil die attributen in de tests gebruiken. Ik ga ervan uit dat de aantallen vast blijven, maar mocht ze dan toch gewijzigd worden in de toekomst dan kloppen de tests nog.

package theater;

import java.util.ArrayList;

public class Theater {
    public final static int AANTALTRIJEN = 15;
    public final static int AANTALPERRIJ = 10;

    private int hoogsteKlantnummer = 0;
    private String naam;
    private ArrayList<Klant> klanten = new ArrayList<>();
    private Voorstelling voorstelling;

    /**
     * Constructor functie voor Theater.
     *
     * @param naam neemt alleen een naam als parameter
     */
    public Theater(String naam) {
        this.naam = naam;
    }

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
     * Maakt een nieuwe voorstelling aan.
     * Nu is er nog maar ruimte voor 1 voorstelling.
     *
     * @param naam  naam van de voorstelling
     * @param datum datum dat deze plaatsvindt
     */
    public void nieuweVoorstelling(String naam, String datum) {
        voorstelling = new Voorstelling(naam, datum);
    }

    /**
     * Voegt een nieuwe klant toe aan de ArrayList van klanten van het theater, mits deze nog niet is toegevoegd.
     *
     * @param naam     naam van de klant
     * @param telefoon telefoonnummer van de klant
     */
    public void nieuweKlant(String naam, String telefoon) {
        if (zoekKlant(naam, telefoon) == null) {
            klanten.add(new Klant(naam, hoogsteKlantnummer + 1, telefoon));
            hoogsteKlantnummer++;
        }
    }

    /**
     * Reserveert een plaats voor een klant.
     * Een gereserveerde plaats kan weer vrijgemaakt worden.
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
     * Als een klant plaatsen heeft gereserveerd kan deze worden geplaatst, waarna ze op bezet komen te staan.
     * Dit kan niet meer gewijzigd worden.
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
     * Als de klant uiteindelijk niet geplaatst wordt, moeten alle reserveringen weer reset worden.
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
