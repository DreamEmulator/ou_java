package studentenadmin;

public class Student {

    //  Attributes
    String naam;
    Opleiding opleiding;
    boolean geslaagd;

    //  Contstructor
    public Student(String naam) {
        this.naam = naam;
    }

    //  Getters
    public String getNaam() {
        return naam;
    }

    public Opleiding getOpleiding() {
        return opleiding;
    }

    public boolean isGeslaagd() {
        return geslaagd;
    }
}
