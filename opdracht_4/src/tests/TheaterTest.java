package tests;

import org.junit.Before;
import org.junit.Test;
import theater.Plaats;
import theater.Theater;

import static org.junit.Assert.*;

public class TheaterTest {

    Theater theater;
    @Before
    public void setUp() throws Exception{
        theater = new Theater("Theater De Glijert");
    }

    @Test
    public void nieuweKlant(){
        theater.nieuweKlant("Arend",06123456);
        theater.nieuweKlant("Bill",06123456);
        theater.nieuweKlant("Margiet",06123456);
    }

    @Test
    public void getHoogsteklantnummer(){
        theater.nieuweKlant("Arend",06123456);
        theater.nieuweKlant("Bill",06123456);
        theater.nieuweKlant("Margiet",06123456);
        assertEquals(3,theater.getHoogsteklantnummer());
    }

    @Test
    public void getStatusPlaatsenAantal(){
        theater.reserveer(5,3);
        theater.reserveer(2,3);
        theater.reserveer(4,3);
        assertEquals(3,theater.getStatusPlaatsenAantal(Plaats.Status.GERESERVEERD));
    }

    @Test
    public void getKlant(){
        theater.nieuweKlant("Arend",06123456);
        assertEquals("Arend",theater.getKlant("Arend").getNaam());
    }

    @Test
    public void getNaam(){
        assertEquals("Theater De Glijert", theater.getNaam());
    }

    @Test
    public void klantToString(){
        theater.nieuweKlant("Arend",06123456);
        assertEquals("Klant{naam='Arend', klantnummer=1, telefoon=1615662}",theater.getKlant("Arend", 06123456));
    }

    @Test
    public void printTheater(){
        theater.printTheater();
    }
}