package tests;

import org.junit.Before;
import org.junit.Test;
import theater.Plaats;

import static org.junit.Assert.*;

public class PlaatsTest {

    Plaats plaatsVrij;
    Plaats plaatsBezet;
    Plaats plaatsGereserveerd;

    @Before
    public void setUp() {
        plaatsVrij = new Plaats(Plaats.Status.VRIJ,1,1);
        plaatsBezet = new Plaats(Plaats.Status.BEZET,2,3);
        plaatsGereserveerd = new Plaats(Plaats.Status.GERESERVEERD,5,8);
    }

    @Test
    public void getStatus() {
        assertEquals(Plaats.Status.VRIJ,plaatsVrij.getStatus());
        assertEquals(Plaats.Status.BEZET,plaatsBezet.getStatus());
        assertEquals(Plaats.Status.GERESERVEERD,plaatsGereserveerd.getStatus());
    }

    @Test
    public void getRijnummer() {
        assertEquals(1,plaatsVrij.getRijnummer());
        assertEquals(2,plaatsBezet.getRijnummer());
        assertEquals(5,plaatsGereserveerd.getRijnummer());
    }

    @Test
    public void getStoelnummer() {
        assertEquals(1,plaatsVrij.getStoelnummer());
        assertEquals(3,plaatsBezet.getStoelnummer());
        assertEquals(8,plaatsGereserveerd.getStoelnummer());
    }
}