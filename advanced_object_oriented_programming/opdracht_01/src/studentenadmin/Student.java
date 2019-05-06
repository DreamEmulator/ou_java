package studentenadmin;

abstract class Student {

    //  Attributes
    final String naam;

    //  Contstructor
    Student(String naam) {
        this.naam = naam;
    }

    //  Methods
    String getNaam() {
        return naam;
    }

    /**
     * Een abstracte methode die geïmplementeert wordt door CPPStudent en ReguliereStudent om hun informatie als string terug te geven.
     * @return String met de informatie van een CPPStudent of een ReguliereStudent
     */
    abstract String toonInfo();
}
