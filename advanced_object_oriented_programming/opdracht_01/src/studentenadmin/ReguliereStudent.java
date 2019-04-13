package studentenadmin;

public class ReguliereStudent extends Student {

    //  Attributes
    private final Opleiding opleiding;
    private double behaaldePunten = 0;

    //  Constructur
    public ReguliereStudent(String naam, Opleiding opleiding) {
        super(naam);
        this.opleiding = opleiding;
    }

    //  Getters
    public double getBehaaldePunten() {
        return behaaldePunten;
    }
    public String getOpleiding() {
        return opleiding.getNaam();
    }

    //  Setters
    public void setBehaaldePunten(double behaaldePunten) {
        this.behaaldePunten += behaaldePunten;
    }
}
