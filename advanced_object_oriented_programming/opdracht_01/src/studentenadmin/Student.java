package studentenadmin;

public class Student {

    //  Attributes
    private final String naam;
    private String opleiding;
    private boolean geslaagd;

    //  Contstructor
    Student(String naam) {
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
