// Toelichting:
// Voorstelling heeft geen publieke methoden omdat alle toegang via Theater moet gaan
// Ik heb alle ongebruikte methodes weggehaald, zodoende zijn er geen getters voor de naam en datum
// Punt 2 van opdracht D was: "Geef de klasse een methode die de reserveringsstatus van een bepaalde plaats (rijnummer, stoelnummer) kan wijzigen van VRIJ naar GERESERVEERD of omgekeerd."
// Ik heb hier twee methodes van gemaakt: reserveer en maakVrij, zodat ik niet weer een methode meerdere mogelijke handelingen uit laat voeren. Het is wat duidelijker zo wat ze precies doen.

package theater;

public class Voorstelling {

    private String naam;
    private String datum;
    private Plaats[][] voorstelling = new Plaats[Theater.AANTALTRIJEN][Theater.AANTALPERRIJ];

    /**
     * Constructor voor de klasse, vraagt de naam en datum van de voorstelling.
     * Maak gebruik van constanten: Theater.AANTALTRIJEN en Theater.AANTALPERRIJ om een twee-dimensionale array op te bouwen van het theater
     *
     * @param naam  naam van de voorstelling
     * @param datum datum van de voorstelling
     */
    protected Voorstelling(String naam, String datum) {
        this.naam = naam;
        this.datum = datum;
        for (int r = 0; r < Theater.AANTALTRIJEN; r++) {
            for (int p = 0; p < Theater.AANTALPERRIJ; p++) {
                voorstelling[r][p] = new Plaats(r + 1, p + 1);
            }
        }
    }

    /**
     * Reserveert een stoel voor de klant.
     * De voorstelling checked alleen of de plaats bestaat is, het is de verantoordelijkheid van de plaats zelf om de status te wijzigen.
     *
     * @param rij   integer rij
     * @param stoel integer stoel
     */
    protected void reserveer(int rij, int stoel) {
        if (rij > 0 && rij <= Theater.AANTALTRIJEN && stoel > 0 && stoel <= Theater.AANTALPERRIJ) {
            voorstelling[rij - 1][stoel - 1].plaatsReserveren();
        }
    }

    /**
     * Maakt een stoel weer vrij.
     * De voorstelling checked alleen of de plaats bestaat is, het is de verantoordelijkheid van de plaats zelf om de status te wijzigen.
     *
     * @param rij   integer rij
     * @param stoel integer stoel
     */
    protected void maakVrij(int rij, int stoel) {
        if (rij > 0 && rij <= Theater.AANTALTRIJEN && stoel > 0 && stoel <= Theater.AANTALPERRIJ) {
            voorstelling[rij - 1][stoel - 1].plaatVrijmaken();
        }
    }

    /**
     * Vraagt de status van iedere plaats op, checkt ze tegen de gewenste status, telt deze op en geeft de totale hoeveelheid terug.
     *
     * @param status de gevraagde status
     * @return totale aantal plaatsen met de gevraagde status
     */
    protected int getPlaatsenStatus(Plaats.Status status) {
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

    /**
     * Plaatst de klant op de reeds gereserveerde plaatsen.
     *
     * @param klant de klant die de plaatsen krijgt
     */
    protected void plaatsKlant(Klant klant) {
        for (Plaats[] rij : voorstelling) {
            for (Plaats plaats : rij) {
                plaats.plaatsBezetten(klant);
            }
        }
    }

    /**
     * Zet de status van alle plaatsen die gereserveerd zijn terug naar vrij
     * Het is de verantoordelijkheid van de plaats zelf om de status te wijzigen
     */
    protected void resetAlleReserveringen() {
        for (Plaats[] rij : voorstelling) {
            for (Plaats plaats : rij) {
                plaats.plaatVrijmaken();
            }
        }
    }

}
