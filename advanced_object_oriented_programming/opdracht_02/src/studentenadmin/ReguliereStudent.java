package studentenadmin;

class ReguliereStudent extends Student {

    //  Attributes
    private final Opleiding opleiding;
    private double behaaldePunten = 0;

    //  Constructor
    ReguliereStudent(String naam, Opleiding opleiding) throws StudentAdminException {
        super(naam);
        this.opleiding = opleiding;
    }

    //  Methods
    /**
     * Check of de ReguliereStudent geslaagd is aan de hand zijn/haar punten en de benodigde punten van de opleiding.
     * @return true of false
     */
    private boolean isGeslaagd() {
        return behaaldePunten >= opleiding.getTotaalPunten();
    }

    /**
     * Verhoogde de behaalde punten met een double waarde die groter is dan 0.
     * @param behaaldePunten
     */
    void verhoogBehaaldePunten(double behaaldePunten) {
        if (behaaldePunten > 0) {
            this.behaaldePunten += behaaldePunten;
        }
    }

    /**
     * Implementeert de abstracte methode van de super klasse Onderwijs.
     * @return String met alle informatie van de Reguliere Student
     */
    String toonInfo() {
        String geslaagd = isGeslaagd() ? "Wel" : "Niet";
        return "Naam: " + naam + ", Opleiding: " + opleiding.getNaam() + ", Behaalde punten: " + behaaldePunten + ", " + geslaagd + " geslaagd";
    }
}
