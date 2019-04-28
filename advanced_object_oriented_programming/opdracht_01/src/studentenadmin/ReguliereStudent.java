package studentenadmin;

class ReguliereStudent extends Student {

    //  Attributes
    private final Opleiding opleiding;
    private double behaaldePunten = 0;

    //  Constructor
    ReguliereStudent(String naam, Opleiding opleiding) {
        super(naam);
        this.opleiding = opleiding;
    }

    //  Getters
    private boolean isGeslaagd(){ return behaaldePunten >= opleiding.getTotaalPunten(); }
    String toonInfo (){
        String geslaagd = isGeslaagd() ? "Wel" : "Niet";
        return "Naam: " + naam + ", Opleiding: " + opleiding.getNaam() + ", Behaalde punten: " + behaaldePunten + ", " + geslaagd + " geslaagd";
    }

    //  Setters
    void verhoogBehaaldePunten(double behaaldePunten) {
        this.behaaldePunten += behaaldePunten;
    }
}
