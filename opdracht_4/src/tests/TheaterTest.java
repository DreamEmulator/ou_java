package tests;

import org.junit.Before;
import org.junit.Test;
import theater.Theater;

import static org.junit.Assert.*;

public class TheaterTest {

    Theater theater;
    @Before
    public void setUp() throws Exception {
        theater = new Theater("Theater De Glijert");
    }

    @Test
    public void nieuweKlant() {
        theater.nieuweKlant("Arend",06123456);
        theater.nieuweKlant("Bill",06123456);
        theater.nieuweKlant("Margiet",06123456);
    }

    @Test
    public void getHoogsteklantnummer() {
        theater.nieuweKlant("Arend",06123456);
        theater.nieuweKlant("Bill",06123456);
        theater.nieuweKlant("Margiet",06123456);
        System.out.println(theater.getHoogsteklantnummer());
    }

    @Test
    public void getKlant() {
        theater.nieuweKlant("Arend",06123456);
        assertEquals("Arend",theater.getKlant("Arend").getNaam());
    }

    @Test
    public void getNaam() {
        assertEquals("Theater De Glijert", theater.getNaam());
    }
}