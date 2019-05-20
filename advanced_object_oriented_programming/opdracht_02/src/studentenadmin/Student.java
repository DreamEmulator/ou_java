package studentenadmin;

import java.util.regex.Pattern;

abstract class Student {

    //  Attributes
    final String naam;

    //  Contstructor
    Student(String naam) throws StudentAdminException {

        if (naam.length() < 2) {
            throw new StudentAdminException("Let op: " + naam + " is te kort");
        } else if ( Pattern.compile( "[0-9]" ).matcher( naam ).find()) {
            throw new StudentAdminException("Let op: gebruik geen cijfers in namen");
        } else {
            this.naam = naam;
        }
    }

    //  Methods
    String getNaam() {
        return naam;
    }

    /**
     * Een abstracte methode die geïmplementeert wordt door CPPStudent en ReguliereStudent om hun informatie als string terug te geven.
     *
     * @return String met de informatie van een CPPStudent of een ReguliereStudent
     */
    abstract String toonInfo();
}
