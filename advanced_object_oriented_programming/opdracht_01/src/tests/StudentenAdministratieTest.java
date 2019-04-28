package tests;

import studentenadmin.StudentenAdministratie;

import static junit.framework.TestCase.assertEquals;

public class StudentenAdministratieTest {

    @org.junit.Test
    public void nieuweCPPStudent() {
        StudentenAdministratie s = new StudentenAdministratie();
        s.nieuweCPPStudent("Bart","Java");
    }

    @org.junit.Test
    public void nieuweReguliereStudent() {
        StudentenAdministratie s = new StudentenAdministratie();
        s.nieuweReguliereStudent("Bart","Wiskunde");
        s.nieuweReguliereStudent("Angela","Informatica");
    }
}
