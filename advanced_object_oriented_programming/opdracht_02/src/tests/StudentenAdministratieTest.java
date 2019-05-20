package tests;

import studentenadmin.StudentAdminException;

import org.junit.Before;
import studentenadmin.StudentenAdministratie;

public class StudentenAdministratieTest {

    StudentenAdministratie s;

    @Before
    public void setUp() throws Exception {
        s = new StudentenAdministratie();
    }

    @org.junit.Test (expected=StudentAdminException.class)
    public void nieuweCPPScholer() throws StudentAdminException {
            s.nieuweCPPScholer("Jan", "Cobol");
    }

    @org.junit.Test (expected=StudentAdminException.class)
    public void nieuweReguliereStudent() throws StudentAdminException {
        s.nieuweReguliereStudent("Bartel-Jaap", "Dieren Telepathie");
    }
}