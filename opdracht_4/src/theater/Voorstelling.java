package theater;

import java.text.DecimalFormat;

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
    public Voorstelling(String naam, String datum) {
        this.naam = naam;
        this.datum = datum;
        for (int r = 0; r < Theater.AANTALTRIJEN; r++) {
            for (int p = 0; p < Theater.AANTALPERRIJ; p++) {
                voorstelling[r][p] = new Plaats(r + 1, p + 1);
            }
        }
    }

    /**
     * Getter geeft de naam van de voorstelling terug.
     *
     * @return String van de naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Getter datum geeft de datum terug als string.
     *
     * @return datum als String
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Reserveert een stoel voor de klant, als deze stoel niet beschikbaar is gaat deze opzoek naar de dichtsbijzijnde met hogere rij en stoel nummers.
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
     * Loopt alle plekken af en checkt ze tegen de gewenste status, telt deze op en geeft ze terug.
     *
     * @param status de gewenste status
     * @return integer van het aantal plaatsen met de gezochte status
     */
    protected int getStatusPlaatsenAantal(Plaats.Status status) {
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


    /**
     * Print de voorsteeling
     */
    protected void printVoorstelling() {
        String print = "";
        DecimalFormat df = new DecimalFormat("00");
        for (int r = 0; r < Theater.AANTALTRIJEN; r++) {
            print += "Rij " + df.format(r + 1) + ": ";
            for (int p = 0; p < Theater.AANTALPERRIJ; p++) {
                Plaats plaats = voorstelling[r][p];
                switch (plaats.getStatus()) {
                    case VRIJ:
                        print += "V";
                        break;
                    case GERESERVEERD:
                        print += "R";
                        break;
                    case BEZET:
                        print += "B";
                        break;
                }
                if (p == voorstelling[0].length - 1) {
                    System.out.println(print);
                    print = "";
                }
            }
        }
    }
}
