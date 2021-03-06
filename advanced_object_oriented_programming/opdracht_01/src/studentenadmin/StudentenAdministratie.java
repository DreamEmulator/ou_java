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
     * @return Opleiding
     */
    private Opleiding getOpleiding(String naam) {

        Opleiding opleiding = null;
        for (Opleiding o : opleidingen) {
            if (o.getNaam().equals(naam)) {
                opleiding = o;
                break;
            }
        }
        return opleiding;
    }

    /**
     * Private methode om een CPP object op te zoeken aan de hand van de naam
     * @return CPP
     */
    private CPP getCPP(String naam) {

        CPP cpp = null;
        for (CPP c : cpps) {
            if (c.getNaam().equals(naam)) {
                cpp = c;
                break;
            }
        }
        return cpp;
    }

    /**
     * Methode om alle opleidingen terug te geven als een array van type String
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
     * @param naam Achternaam van de CPP scholer
     * @param cpp Naam van de CPP
     */
    public void nieuweCPPScholer(String naam, String cpp) {
        studenten.add(new CPPStudent(naam, getCPP(cpp)));
    }

    /**
     * Met deze methode kan je een nieuwe Reguliere Student aanmaken. Er wordt niet gecheckt of deze reeds bestaat.
     * @param naam Achternaam van de Reguliere Student
     * @param opleiding Naam van de opleiding
     */
    public void nieuweReguliereStudent(String naam, String opleiding) {
        studenten.add(new ReguliereStudent(naam, getOpleiding(opleiding)));
    }

    /**
     * Toont alle informatie van een student of een scholer
     * @param naam Achternaam van de student of scholer
     * @return String met informatie van de scholer of student
     */
    public String toonStudent(String naam) {
        return zoekStudent(naam) != null ? zoekStudent(naam).toonInfo() : "Student niet gevonden";
    }

    /**
     * Toont een String met alle informatie van alle studenten en scholers
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
     * @param naam Achternaam van de student
     * @param punten Het aantal punten de student moet ontvangen
     */
    public void verhoogPunten(String naam, double punten) {
        if (zoekStudent(naam) instanceof ReguliereStudent) {
            ReguliereStudent student = (ReguliereStudent) zoekStudent(naam);
            student.verhoogBehaaldePunten(punten);
        }
    }

    /**
     * Verhoogt de behaalde modules van scholer met 1 module
     * @param naam Achternaam van de scholer
     */
    public void verhoogBehaaldeModules(String naam) {
        if (zoekStudent(naam) instanceof CPPStudent) {
            CPPStudent scholer = (CPPStudent) zoekStudent(naam);
            scholer.verhoogBehaaldeModules();
        }
    }
}
