package studentenadmin.tests;

import studentenadmin.StudentenAdministratie;

import static junit.framework.TestCase.assertEquals;

public class StudentenAdministratieTest {

    @org.junit.Test
    public void nieuweCPPStudent() {
        StudentenAdministratie s = new StudentenAdministratie();
        s.nieuweCPPStudent("Bart","Java");
        assertEquals(1, s.getStudenten().size());
    }

    @org.junit.Test
    public void nieuweReguliereStudent() {
        StudentenAdministratie s = new StudentenAdministratie();
        s.nieuweReguliereStudent("Bart","Wiskunde");
        s.nieuweReguliereStudent("Angela","Informatica");
        assertEquals(2, s.getStudenten().size());
    }
}
