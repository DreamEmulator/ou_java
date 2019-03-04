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
        theater.nieuweKlant("Bartel-Jaap",06123456);
        theater.nieuweKlant("Bill",06123456);
        theater.nieuweKlant("Margiet",06123456);
    }

    @Test
    public void getHoogsteklantnummer(){
        theater.nieuweKlant("Bartel-Jaap",06123456);
        theater.nieuweKlant("Bill",06123456);
        theater.nieuweKlant("Margiet",06123456);
        assertEquals(3,theater.getHoogsteklantnummer());
    }

    @Test
    public void getStatusPlaatsenAantal(){
        theater.nieuweVoorstellijng("Rundfunk de Musical", "13-09-2019");
        theater.reserveer(1,1);
        theater.reserveer(2,2);
        theater.reserveer(3,3);
        theater.reserveer(4,4);
        theater.reserveer(5,5);
        theater.reserveer(6,6);
        theater.reserveer(7,7);
        theater.reserveer(8,8);
        theater.reserveer(9,9);
        theater.reserveer(10,10);
        assertEquals(10, theater.getStatusPlaatsenAantal(Plaats.Status.GERESERVEERD));
        System.out.println("\nKlant gereserveerd: ");
        theater.printVoorstelling();
    }

    @Test
    public void getKlant(){
        theater.nieuweKlant("Bartel-Jaap",06123456);
        assertEquals("Bartel-Jaap",theater.getKlant("Bartel-Jaap", 06123456).getNaam());
    }

    @Test
    public void plaatsKlant(){
        theater.nieuweVoorstellijng("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap",06123456);
        theater.reserveer(1,1);
        theater.reserveer(2,2);
        theater.reserveer(3,3);
        theater.reserveer(4,4);
        theater.reserveer(5,5);
        theater.reserveer(6,6);
        theater.reserveer(7,7);
        theater.reserveer(8,8);
        theater.reserveer(9,9);
        theater.reserveer(10,10);
        theater.plaatsKlant("Bartel-Jaap",06123456);
        assertEquals(10, theater.getStatusPlaatsenAantal(Plaats.Status.BEZET));
        System.out.println("\nKlant geplaatst: ");
        theater.printVoorstelling();
        theater.printVerkochtePlaatsen();
    }

    @Test
    public void resetAlleReserveringen(){
        theater.nieuweVoorstellijng("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap",06123456);
        theater.reserveer(1,1);
        theater.reserveer(2,2);
        theater.reserveer(3,3);
        theater.reserveer(4,4);
        theater.reserveer(5,5);
        theater.reserveer(6,6);
        theater.reserveer(7,7);
        theater.reserveer(8,8);
        theater.reserveer(9,9);
        theater.reserveer(10,10);
        theater.resetAlleReserveringen();
        assertEquals(0,theater.getStatusPlaatsenAantal(Plaats.Status.GERESERVEERD));
        System.out.println("\nVoorstelling geleegd: ");
        theater.printVoorstelling();

        theater.nieuweVoorstellijng("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap",06123456);
        theater.reserveer(1,1);
        theater.reserveer(2,2);
        theater.reserveer(3,3);
        theater.reserveer(4,4);
        theater.reserveer(5,5);
        theater.plaatsKlant("Bartel-Jaap",06123456);
        theater.reserveer(6,6);
        theater.reserveer(7,7);
        theater.reserveer(8,8);
        theater.reserveer(9,9);
        theater.reserveer(10,10);
        theater.resetAlleReserveringen();
        assertEquals(0,theater.getStatusPlaatsenAantal(Plaats.Status.GERESERVEERD));
        System.out.println("\nVoorstelling deels geleegd: ");
        theater.printVoorstelling();
    }

    @Test
    public void getNaam(){
        assertEquals("Theater De Glijert", theater.getNaam());
    }

    @Test
    public void klantToString(){
        theater.nieuweKlant("Bartel-Jaap",06123456);
        assertEquals("Klant{naam='Bartel-Jaap', klantnummer=1, telefoon=1615662}",theater.getKlant("Bartel-Jaap", 06123456).klantToString());
    }

}