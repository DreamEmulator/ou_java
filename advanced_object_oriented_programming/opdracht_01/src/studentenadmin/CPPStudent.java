package studentenadmin;

public class CPPStudent extends Student {

    //  Attributes
    private CPP cpp;
    private double behaaldePunten = 0;

    //  Constructur
    public CPPStudent(String naam, CPP cpp) {
        super(naam);
        this.opleiding = opleiding;
    }

    //  Getters
    public double getBehaaldePunten() {
        return behaaldePunten;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    //  Setters
    public void setBehaaldePunten(double behaaldePunten) {
        this.behaaldePunten = behaaldePunten;
    }

    public void setOpleiding(Opleiding opleiding) {
        this.opleiding = opleiding;
    }
}
