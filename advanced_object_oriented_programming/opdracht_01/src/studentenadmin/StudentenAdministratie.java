package studentenadmin;

import java.util.ArrayList;

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

    //  Getters
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

    public String[] getOpleidingenList() {
        String[] opleidingenList = new String[opleidingen.length];
        for (int i = 0; i < opleidingen.length; i++) {
            opleidingenList[i] = opleidingen[i].getNaam();
        }
        return opleidingenList;
    }

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

    public String[] getCppList() {
        String[] CppList = new String[cpps.length];
        for (int i = 0; i < cpps.length; i++) {
            CppList[i] = cpps[i].getNaam();
        }
        return CppList;
    }

    // Methods
    public void nieuweCPPStudent(String naam, String cpp) {
        studenten.add(new CPPStudent(naam, getCPP(cpp)));
    }

    public void nieuweReguliereStudent(String naam, String opleiding) {
        studenten.add(new ReguliereStudent(naam, getOpleiding(opleiding)));
    }

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

    public String toonStudent(String naam) {
        return zoekStudent(naam) != null ? zoekStudent(naam).toonInfo() : "Student niet gevonden";
    }

    public String toonAlleStudenten() {
        StringBuilder info = new StringBuilder();
        for (Student s : studenten) {
            info.append(s.toonInfo()).append("\n");
        }
        return info.toString();
    }

    public void verhoogPunten(String naam, double punten) {
        if (zoekStudent(naam) instanceof ReguliereStudent) {
            ReguliereStudent student = (ReguliereStudent) zoekStudent(naam);
            student.verhoogBehaaldePunten(punten);
        }
    }

    public void verhoogBehaaldeModules(String naam) {
        if (zoekStudent(naam) instanceof CPPStudent) {
            CPPStudent scholer = (CPPStudent) zoekStudent(naam);
            scholer.verhoogBehaaldeModules();
        }
    }
}
