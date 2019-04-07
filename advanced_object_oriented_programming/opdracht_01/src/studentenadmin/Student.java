package studentenadmin;

public class Student {

    //  Attributes
    private String naam;
    private String opleiding;
    boolean geslaagd;

    //  Contstructor
    public Student(String naam) {
        this.naam = naam;
    }

    //  Getters
    public String getNaam() {
        return naam;
    }

    public String getOpleiding() {
        return opleiding;
    }

    public boolean isGeslaagd() {
        return geslaagd;
    }
}
