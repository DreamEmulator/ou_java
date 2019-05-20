package studentenadmin;

class CPPStudent extends Student {

    //  Attributes
    private final CPP cpp;
    private int behaaldeModules = 0;

    //Constructor
    CPPStudent(String naam, CPP cpp) throws StudentAdminException {
        super(naam);
        this.cpp = cpp;
    }

    //  Methods
    /**
     * Check of de ReguliereStudent geslaagd is aan de hand zijn/haar behaalde modules en de benodigde modules van de CPP.
     * @return true of false
     */
    private boolean isGeslaagd() {
        return behaaldeModules >= cpp.getTotaalModules();
    }

    /**
     * Verhoogde de behaalde modules met 1.
     */
    void verhoogBehaaldeModules() {
        behaaldeModules++;
    }

    /**
     * Implementeert de abstracte methode van de super klasse Onderwijs
     * @return String met alle informatie van de CPP Student
     */
    String toonInfo() {
        String geslaagd = isGeslaagd() ? "Wel" : "Niet";
        return "Naam: " + naam + ", CPP: " + cpp.getNaam() + ", Behaalde modules: " + behaaldeModules + ", " + geslaagd + " geslaagd";
    }
}
