package studentenadmin;

import java.util.ArrayList;

public class StudentenAdministratie {

    private ArrayList<Student> studenten = new ArrayList<Student>();

    //  Attributes
    Opleiding[] opleidingen = {
            new Opleiding("Informatica", 160),
            new Opleiding("Wiskunde", 200)
    };

    CPP[] cpps = {
            new CPP("Java", 6),
            new CPP("Softwarearchitect", 4),
            new CPP("Systeemontwikkelaar", 3)
    };

    //  Getters
    private Opleiding getOpleiding(String naam) {
        Opleiding opleiding = null;
        for (Opleiding o : opleidingen) {
            if (o.getNaam().equals(naam)) opleiding = o;
            break;
        }
        return opleiding;
    }
    private CPP getCPP(String naam) {
        CPP cpp = null;
        for (CPP c : cpps) {
            if (c.getNaam().equals(naam)) cpp = c;
            break;
        }
        return cpp;
    }
    public ArrayList<Student> getStudenten() {
        return studenten;
    }
    public Opleiding[] getOpleidingen() {
        return opleidingen;
    }
    public CPP[] getCpps() {
        return cpps;
    }

    // Methods
    public void nieuweCPPStudent(String naam, String cpp) {
        studenten.add(new CPPStudent(naam, getCPP(cpp)));
    }

    public void nieuweReguliereStudent(String naam, String opleiding) {
        studenten.add(new ReguliereStudent(naam, getOpleiding(opleiding)));
    }

    public Student zoekStudent(String naam) {
        Student student = null;
        for (Student s : studenten) {
            if (s.getNaam().equals(naam)) {
                student = s;
                break;
            }
        }
        return student;
    }

}
