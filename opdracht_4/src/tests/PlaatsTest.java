package tests;

import org.junit.Before;
import org.junit.Test;
import theater.Klant;
import theater.Plaats;

import static org.junit.Assert.*;

public class PlaatsTest {

    Plaats plaats;

    @Before
    public void setUp() {
        plaats = new Plaats(1,1);
    }

    @Test
    public void getStatus() {
        assertEquals(Plaats.Status.VRIJ,plaats.getStatus());

        plaats.setStatus(Plaats.Status.BEZET);
        assertEquals(Plaats.Status.BEZET,plaats.getStatus());

        plaats.setStatus(Plaats.Status.GERESERVEERD);
        assertEquals(Plaats.Status.GERESERVEERD,plaats.getStatus());
    }

    @Test
    public void getRijnummer() {
        assertEquals(1,plaats.getRijnummer());
    }

    @Test
    public void getStoelnummer() {
        assertEquals(1,plaats.getStoelnummer());
    }

    @Test
    public void plaatsToekennen(){
        Klant klant = new Klant("Arend",1,12345678);
        plaats.plaatsToekennen(klant);
        assertEquals(Plaats.Status.BEZET, plaats.getStatus());
    }

    @Test
    public void plaatsToString(){
        assertEquals("Plaats{status=VRIJ, rijnummer=1, stoelnummer=1, klantInfo='null'}", plaats.plaatsToString());

    }
}