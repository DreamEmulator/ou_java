// Toelichting:
// Ik heb de les gevolgd en alle methodes zo dicht mogelijk gezet. Hierdoor wordt alleen Theater publiekelijk beschikbaar en worden alle moethodes van Voorstelling, Plaats en Klant getest door theater.
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
        theater = new Theater("Theater De Kaap");
    }

    @Test
    public void reserveren(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");

        theater.reserveren(1,1);
        theater.reserveren(2,2);
        theater.reserveren(3,3);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveren(1,Theater.AANTALPERRIJ + 10);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveren(Theater.AANTALTRIJEN + 10,1);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveren(-1,1);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveren(1,-1);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveren(0,0);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));
    }

    @Test
    public void plaatsen(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");

        theater.reserveren(4,4);
        theater.reserveren(5,5);
        theater.reserveren(6,6);

        theater.plaatsen("Bartel-Jaap","06123456");
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.BEZET));

        theater.reserveren(0,1);
        theater.reserveren(1,0);
        theater.reserveren(1,-1);
        theater.reserveren(-1,1);
        theater.reserveren(Theater.AANTALTRIJEN + 10,Theater.AANTALPERRIJ + 10);

        theater.plaatsen("Bartel-Jaap","06123456");
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.BEZET));
    }

    @Test
    public void resetten(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");

        theater.reserveren(8,8);
        theater.reserveren(9,9);
        theater.reserveren(10,10);

        theater.resetten();

        assertEquals(0,theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");

        theater.reserveren(1,1);
        theater.reserveren(2,2);
        theater.reserveren(3,3);
        theater.reserveren(Theater.AANTALTRIJEN + 10,Theater.AANTALPERRIJ + 10);

        theater.plaatsen("Bartel-Jaap","06123456");

        theater.reserveren(4,4);
        theater.reserveren(5,5);
        theater.reserveren(6,6);
        theater.reserveren(Theater.AANTALTRIJEN + 10,Theater.AANTALPERRIJ + 10);

        theater.resetten();

        assertEquals(3,theater.getAantalPlaatsen(Plaats.Status.BEZET));
        assertEquals(0,theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));
    }

    @Test
    public void getAantalPlaatsen(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");

        theater.reserveren(8,8);
        theater.reserveren(9,9);
        theater.reserveren(10,10);
        assertEquals(147, theater.getAantalPlaatsen(Plaats.Status.VRIJ));
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.plaatsen("Bartel-Jaap","06123456");
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.BEZET));

        theater.reserveren(-1,1);
        theater.reserveren(0,0);
        theater.reserveren(Theater.AANTALTRIJEN + 10,Theater.AANTALPERRIJ + 10);
        assertEquals(0, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.plaatsen("Bartel-Jaap","06123456");
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.BEZET));
    }

}