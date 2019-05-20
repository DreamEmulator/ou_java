package studentenadmin;

import java.util.ArrayList;

/**
 * Dit is de kapstokklasse van de domeinlaag.
 */
public class StudentenAdministratie {

    //  Attributes
    private final ArrayList<Student> studenten = new ArrayList<Student>();
    private final Opleiding[] opleidingen = {
            new Opleiding("Informatica", 160),
            new Opleiding("Wiskunde", 200)
    };
    private final CPP[] cpps = {
            new CPP("Java", 6),
            new CPP("Softwarearchitect", 4),
            new CPP("Systeemontwikkelaar", 3)
    };

    //  Methods

    /**
     * Private methode om een Student object op te zoeken aan de hand van de naam
     *
     * @return Student
     */
    private Student zoekStudent(String naam) {

        Student student = null;
        for (Student s : studenten) {
            if (s.getNaam().equals(naam)) {
                student = s;
                break;
            }
        }
        return student;
    }

    /**
     * Private methode om een Opleiding object op te zoeken aan de hand van de naam
     *
     * @return Opleiding
     */
    private Opleiding getOpleiding(String naam) throws StudentAdminException {
        for (Opleiding o : opleidingen) {
            if (o.getNaam().equals(naam)) {
                return o;
            }
        }
        throw new StudentAdminException("Let op: De opleiding " + naam + " bestaat niet.");
    }

    /**
     * Private methode om een CPP object op te zoeken aan de hand van de naam
     *
     * @return CPP
     */
    private CPP getCPP(String naam) throws StudentAdminException {
        for (CPP c : cpps) {
            if (c.getNaam().equals(naam)) {
                return c;
            }
        }
        throw new StudentAdminException("Let op: De CPP " + naam + " bestaat niet");
    }

    /**
     * Methode om alle opleidingen terug te geven als een array van type String
     *
     * @return array of String
     */
    public String[] getOpleidingenList() {
        String[] opleidingenList = new String[opleidingen.length];
        for (int i = 0; i < opleidingen.length; i++) {
            opleidingenList[i] = opleidingen[i].getNaam();
        }
        return opleidingenList;
    }

    /**
     * Methode om alle CPP's terug te geven als een array van type String
     *
     * @return array of String
     */
    public String[] getCppList() {
        String[] CppList = new String[cpps.length];
        for (int i = 0; i < cpps.length; i++) {
            CppList[i] = cpps[i].getNaam();
        }
        return CppList;
    }

    /**
     * Met deze methode kan je een nieuwe CPP scholer aanmaken. Er wordt niet gecheckt of deze reeds bestaat.
     *
     * @param naam Achternaam van de CPP scholer
     * @param cpp  Naam van de CPP
     */
    public void nieuweCPPScholer(String naam, String cpp) throws StudentAdminException {
        if (naam.length() < 2) {
            throw new StudentAdminException("Let op: Een naam moet uit meer dan twee karakters bestaan");
        } else if (zoekStudent(naam) != null) {
            throw new StudentAdminException("Let op: " + naam + " staat al ingeschreven");
        } else {
            studenten.add(new CPPStudent(naam, getCPP(cpp)));
        }
    }

    /**
     * Met deze methode kan je een nieuwe Reguliere Student aanmaken. Er wordt niet gecheckt of deze reeds bestaat.
     *
     * @param naam      Achternaam van de Reguliere Student
     * @param opleiding Naam van de opleiding
     */
    public void nieuweReguliereStudent(String naam, String opleiding) throws StudentAdminException {
        if (naam.length() < 2) {
            throw new StudentAdminException("Let op: Een naam moet uit meer dan twee karakters bestaan");
        } else if (zoekStudent(naam) != null) {
            throw new StudentAdminException("Let op: " + naam + " staat al ingeschreven");
        } else {
            studenten.add(new ReguliereStudent(naam, getOpleiding(opleiding)));
        }
    }

    /**
     * Toont alle informatie van een student of een scholer
     *
     * @param naam Achternaam van de student of scholer
     * @return String met informatie van de scholer of student
     */
    public String toonStudent(String naam) throws StudentAdminException {
        if (naam.length() < 3) {
            throw new StudentAdminException("Let op: Naam moet uit meer dan twee karakters bestaan");
        } else if (zoekStudent(naam) == null) {
            throw new StudentAdminException("Let op: " + naam + " bestaat niet");
        } else {
            return zoekStudent(naam).toonInfo();
        }
    }

    /**
     * Toont een String met alle informatie van alle studenten en scholers
     *
     * @return String met alle informatie
     */
    public String toonAlleStudenten() {
        StringBuilder info = new StringBuilder();
        for (Student s : studenten) {
            info.append(s.toonInfo()).append("\n");
        }
        return info.toString();
    }

    /**
     * Verhoogt het aantal punten van een student
     *
     * @param naam   Achternaam van de student
     * @param punten Het aantal punten de student moet ontvangen
     */
    public void verhoogPunten(String naam, double punten) throws StudentAdminException {
        if (zoekStudent(naam) instanceof ReguliereStudent) {
            ReguliereStudent student = (ReguliereStudent) zoekStudent(naam);
            student.verhoogBehaaldePunten(punten);
        } else {
            throw new StudentAdminException("Let op: Punten kunnen alleen verhoogd worden voor een Reguliere Student");
        }
    }

    /**
     * Verhoogt de behaalde modules van scholer met 1 module
     *
     * @param naam Achternaam van de scholer
     */
    public void verhoogBehaaldeModules(String naam) throws StudentAdminException {
        if (zoekStudent(naam) instanceof CPPStudent) {
            CPPStudent scholer = (CPPStudent) zoekStudent(naam);
            scholer.verhoogBehaaldeModules();
        } else {
            throw new StudentAdminException("Let op: Modules kunnen alleen verhoogd worden voor een CPP Student");
        }
    }
}
