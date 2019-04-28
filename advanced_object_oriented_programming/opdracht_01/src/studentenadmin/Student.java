package studentenadmin;

abstract class Student {

    //  Attributes
    final String naam;

    //  Contstructor
    Student(String naam) {
        this.naam = naam;
    }

    //  Getters
    String getNaam() {
        return naam;
    }

    abstract String toonInfo();
}
