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

    @org.junit.Test
    public void nieuweCPPScholer() {
        try {
            s.nieuweCPPScholer("Jan", "Cobol");
        } catch (StudentAdminException err) {
            System.out.println(err.message);
        }
    }

    @org.junit.Test
    public void nieuweReguliereStudent() {
        try {
            s.nieuweReguliereStudent("Bartel-Jaap", "Dieren Telepathie");
        } catch (StudentAdminException err) {
            System.out.println(err.message);
        }
    }
}