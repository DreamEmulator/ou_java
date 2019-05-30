package tests;

import studentenadmin.StudentAdminException;

import org.junit.Before;
import studentenadmin.StudentenAdministratie;

public class StudentenAdministratieTest {

    private StudentenAdministratie s;

    @Before
    public void setUp() {
        s = new StudentenAdministratie();
    }

    @org.junit.Test
    public void nieuweCPPScholer() throws StudentAdminException {
        s.nieuweCPPScholer("Jan", "Java");
    }

    @org.junit.Test (expected=StudentAdminException.class)
    public void geenNieuweCPPScholer() throws StudentAdminException {
        s.nieuweCPPScholer("Jan", "Cobol");
    }

    @org.junit.Test
    public void nieuweReguliereStudent() throws StudentAdminException {
        s.nieuweReguliereStudent("Bartel-Jaap", "Wiskunde");
    }

    @org.junit.Test (expected=StudentAdminException.class)
    public void geenNieuweReguliereStudent() throws StudentAdminException {
        s.nieuweReguliereStudent("Bartel-Jaap", "Dieren Telepathie");
    }

    @org.junit.Test
    public void verhoogBehaaldePunten() throws StudentAdminException {
        s.nieuweReguliereStudent("Bartel-Jaap", "Informatica");
        s.verhoogPunten("Bartel-Jaap", 2.67);
    }

    @org.junit.Test (expected=StudentAdminException.class)
    public void verhoogNietBehaaldePunten() throws StudentAdminException {
        s.nieuweReguliereStudent("Bartel-Jaap", "Informatica");
        s.verhoogPunten("Meindert", 2.67);
    }

    @org.junit.Test (expected=StudentAdminException.class)
    public void verlaagNietBehaaldePunten() throws StudentAdminException {
        s.nieuweReguliereStudent("Bartel-Jaap", "Informatica");
        s.verhoogPunten("Bartel-Jaap", -17);
    }

    @org.junit.Test
    public void verhoogBehaaldeModules() throws StudentAdminException {
        s.nieuweCPPScholer("Bartel-Jaap", "Java");
        s.verhoogBehaaldeModules("Bartel-Jaap");
    }

}