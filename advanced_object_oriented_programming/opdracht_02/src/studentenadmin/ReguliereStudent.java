package studentenadmin;

/**
 * Met deze klass kan je een Reguliere student creëren
 */
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
     * @param behaaldePunten het aantal punten die een student in totaal heeft gehaald
     */
    void verhoogBehaaldePunten(double behaaldePunten) throws StudentAdminException {
        if (behaaldePunten > 0) {
            this.behaaldePunten += behaaldePunten;
        } else {
            throw new StudentAdminException("Let op: Punten mogen alleen opgeteld worden");
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
