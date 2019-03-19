// Toelichting:
// Ik heb alle ongebruikte methodes weggehaald, zodoende zijn er geen getters voor de naam en datum
// Volgens de opdracht moezst ik: "Geef de klasse een methode die de reserveringsstatus van een bepaalde plaats (rijnummer, stoelnummer) kan wijzigen van VRIJ naar GERESERVEERD of omgekeerd."
// Ik heb hier twee methodes van gemaakt :reserveer en maakVrij. Dit vind ik wat duidelijker dan een reserveer methode die ook het omgekeerde kan doen.

package theater;

public class Voorstelling {

    private String naam;
    private String datum;
    private Plaats[][] voorstelling = new Plaats[Theater.AANTALTRIJEN][Theater.AANTALPERRIJ];

    /**
     * Constructor voor de klasse, vraagt de naam en datum van de voorstelling.
     *
     * @param naam  nama van de voorstelling
     * @param datum datum van de voorstelling als string
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
     *
     * @param rij   integernrij nummer
     * @param stoel integer stoel
     */
    protected void reserveer(int rij, int stoel) {
        if (rij > 0 && rij <= Theater.AANTALTRIJEN && stoel > 0 && stoel <= Theater.AANTALPERRIJ) {
            voorstelling[rij - 1][stoel - 1].reserveren();
        }
    }

    /**
     * Maak een stoel weer vrij.
     *
     * @param rij   integernrij nummer
     * @param stoel integer stoel
     */
    protected void maakVrij(int rij, int stoel) {
        if (rij > 0 && rij <= Theater.AANTALTRIJEN && stoel > 0 && stoel <= Theater.AANTALPERRIJ) {
            voorstelling[rij - 1][stoel - 1].vrijmaken();
        }
    }

    /**
     * Loopt alle plekken af en checkt ze tegen de gewenste status, telt deze op en geeft ze terug.
     *
     * @param status de gewenste status
     * @return integer van het aantal plaatsen met de gezochte status
     */
    public int getPlaatsenStatus(Plaats.Status status) {
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
     * Plaatst de klant op de reeds gereserveerde plaatsen. Ik hen nagedacht om eerst de aantal gereserveerde op te zoeken en dan op te houden als dat bereikt is. Hier is alleen geen efficientie slag omdat je dan ook al een keer helemaal door de array bent gegaan.
     *
     * @param klant de klant die de olaatsen krijgt
     */
    protected void plaatsKlant(Klant klant) {
        for (Plaats[] rij : voorstelling) {
            for (Plaats plaats : rij) {
                plaats.plaatsToekennen(klant);
            }
        }
    }

    /**
     * Zet de status van alle plaatsen die gereserveerd zijn terug naar vrij
     */
    protected void resetAlleReserveringen() {
        for (Plaats[] rij : voorstelling) {
            for (Plaats plaats : rij) {
                plaats.vrijmaken();
            }
        }
    }

}
