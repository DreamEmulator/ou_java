package studentenadmin;

import java.util.ArrayList;

public class StudentenAdministratie {

    public ArrayList<Student> studenten = new ArrayList<Student>();

    Opleiding[] opleidingen = {
            new Opleiding("Informatica", 160),
            new Opleiding("Wiskunde", 200)
    };

    CPP[] cpps = {
            new CPP("Java", 6),
            new CPP("Softwarearchitect", 4),
            new CPP("Systeemontwikkelaar", 3)
    };

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

    public void nieuweCPPStudent(String naam, String cpp) {
        studenten.add(new CPPStudent(naam, getCPP(cpp)));
    }

    public void nieuweReguliereStudent(String naam, String opleiding) {
        studenten.add(new ReguliereStudent(naam, getOpleiding(opleiding)));
    }

}
