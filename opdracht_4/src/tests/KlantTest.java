package tests;

import org.junit.Before;
import org.junit.Test;
import theater.Klant;

import static org.junit.Assert.*;

public class KlantTest {

    Klant klant;

    @Before
    public void setUp() throws Exception {
        klant = new Klant("Bartel-Jaap",01,"06123456");
    }

    @Test
    public void klantToString(){
        assertEquals("Klant{naam='Bartel-Jaap', klantnummer=1, telefoon=1615662}",klant.klantToString());
    }
}