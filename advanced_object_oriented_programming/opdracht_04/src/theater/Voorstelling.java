package theater;

import theaterdata.TheaterException;
import theaterdata.Voorstellingbeheer;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Representeert een voorstelling.
 *
 * @author Open Universiteit
 */
public class Voorstelling {

    private String naam = "";
    private GregorianCalendar datum = null;
    private Plaats[][] plaatsen = null;

    /**
     * Creeert een voorstelling.
     *
     * @param naam  naam van de voorstelling
     * @param datum datum van de voorstelling
     */
    public Voorstelling(String naam, GregorianCalendar datum) {
        this.naam = naam;
        this.datum = datum;
        plaatsen = new Plaats[Theater.AANTALRIJEN + 1][Theater.AANTALPERRIJ + 1];
        for (int i = 1; i < plaatsen.length; i++) {
            for (int j = 1; j < plaatsen[i].length; j++) {
                plaatsen[i][j] = new Plaats(i, j);
            }
        }
    }

    /**
     * Geeft naam van de voorstelling.
     *
     * @return naam van de voorstelling
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Geeft datum van de voorstelling.
     *
     * @return datum van de voorstelling
     */
    private GregorianCalendar getDatum() {
        return datum;
    }

    /**
     * Reserveert deze plaats.
     * Voorwaarde: de plaats is nog vrij
     *
     * @param rijnummer   rijnummer van de plaats
     * @param stoelnummer stoelnummer van de plaats
     * @return true als de reservering gelukt is, anders false
     */
    public boolean reserveer(int rijnummer, int stoelnummer) {
        if (inZaal(rijnummer, stoelnummer)) {
            return plaatsen[rijnummer][stoelnummer].reserveer();
        } else {
            return false;
        }
    }

    /**
     * Geef deze (gereserveerde) plaats vrij
     *
     * @param rijnummer   rijnummer van de plaats
     * @param stoelnummer stoelnummer van de plaats
     * @return true als het vrijgeven gelukt is, anders false
     */
    public boolean geefVrij(int rijnummer, int stoelnummer) {
        if (inZaal(rijnummer, stoelnummer)) {
            return plaatsen[rijnummer][stoelnummer].geefVrij();
        } else {
            return false;
        }
    }

    /**
     * Verander reserveringsstatus van stoel (VRIJ <=> GERESERVEERD).
     * Voorwaarde: rijnummer en stoelnummer vallen binnen de zaal
     *
     * @param rijnummer   rijnummer van de plaats
     * @param stoelnummer stoelnummer van de plaats
     * @return true als er een statusverandering plaatsvindt, anders false
     */
    public boolean veranderReservering(int rijnummer, int stoelnummer) {
        if (!inZaal(rijnummer, stoelnummer)) {
            return false;
        }
        Plaats plaats = plaatsen[rijnummer][stoelnummer];
        Plaats.Status status = plaats.getStatus();
        if (status.equals(Plaats.Status.VRIJ)) {
            return plaats.reserveer();
        } else if (status.equals(Plaats.Status.GERESERVEERD)) {
            return plaats.geefVrij();
        } else {
            return false;
        }
    }


    /**
     * Update bezetting
     */
    void updateBezetting(Klant klant) throws TheaterException {
        System.out.println("Aantal spots bezet:" + getBezetting().size());
        for (Plaats p : getBezetting()) {
            Voorstellingbeheer.updateBezetting(getDatum(), p.getRijnummer(), p.getStoelnummer(), klant.getKlantnummer());
        }
    }

    /**
     * Get reserveringen
     * Bepaal welke reserveringen nieuw zijn en geeft deze terug
     */
    private ArrayList<Plaats> getBezetting() {
        ArrayList<Plaats> bezetting = new ArrayList<>();
        for (int i = 1; i < plaatsen.length; i++) {
            for (int j = 1; j < plaatsen[i].length; j++) {
                if (Plaats.Status.GERESERVEERD == plaatsen[i][j].getStatus()) {
                    bezetting.add(plaatsen[i][j]);
                }
            }
        }
        return bezetting;
    }

    /**
     * Plaatst de klant op de aangegeven plaats.
     *
     * @param rijnummer   rijnummer van de plaats
     * @param stoelnummer stoelnummer van de plaats
     * @param klant       de klant
     * @return true als er een statusverandering plaatsvindt, anders false
     */
    public boolean plaatsKlant(int rijnummer, int stoelnummer, Klant klant) {
        if (inZaal(rijnummer, stoelnummer)) {
            return plaatsen[rijnummer][stoelnummer].plaatsKlant(klant);
        } else {
            return false;
        }
    }

    /**
     * Plaatst de klant op alle gereserveerde plaatsen.
     *
     * @param klant de klant
     */
    public void plaatsKlant(Klant klant) {
        for (int i = 1; i < plaatsen.length; i++) {
            for (int j = 1; j < plaatsen[i].length; j++) {
                plaatsen[i][j].plaatsKlant(klant);
            }
        }
    }

    /**
     * Geeft een plaats in de zaal
     *
     * @param rijnummer   rijnummer van de plaats
     * @param stoelnummer stoelnummer van de plaats
     * @return
     */
    public Plaats getPlaats(int rijnummer, int stoelnummer) {
        if (inZaal(rijnummer, stoelnummer)) {
            return plaatsen[rijnummer][stoelnummer];
        } else {
            return null;
        }
    }

    // private methode

    /**
     * Controleert of er een plaats is met dit rij- en stoelnummer
     *
     * @param rijnummer   het rijnummer van de plaats
     * @param stoelnummer het stoelnummer van de plaats
     * @return true als de zaal een plaats heeft met dit rij-
     * en stoelnummer; anders false
     */
    private boolean inZaal(int rijnummer, int stoelnummer) {
        return rijnummer >= 1 && rijnummer <= Theater.AANTALRIJEN
                && stoelnummer >= 1 && stoelnummer <= Theater.AANTALPERRIJ;
    }

}
