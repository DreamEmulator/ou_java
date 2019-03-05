package tests;

import org.junit.Before;
import org.junit.Test;
import theater.Plaats;
import theater.Voorstelling;

import static org.junit.Assert.*;

public class VoorstellingTest {

    Voorstelling voorstelling;
    @Before
    public void setUp(){
        voorstelling = new Voorstelling("Das Boot","05-05-1945");
    }

    @Test
    public void getNaam(){
        assertEquals("Das Boot", voorstelling.getNaam());
    }

    @Test
    public void getDatum(){
        assertEquals("05-05-1945", voorstelling.getDatum());
    }

    @Test
    public void reserveer(){
        voorstelling.reserveer(2,3);
        assertEquals(1,voorstelling.getStatusPlaatsenAantal(Plaats.Status.GERESERVEERD));
    }

    @Test
    public void getStatusPlaatsenAantal(){
        voorstelling.reserveer(2,3);
        assertEquals(1,voorstelling.getStatusPlaatsenAantal(Plaats.Status.GERESERVEERD));
    }
}