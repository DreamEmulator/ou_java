package tests;

import bank_domain.Rekening;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRekening {

    private Rekening rekening;
    private static final double DELTA = 0.01;

    @Before
    public void setUp() {
        rekening = new Rekening(1234,  "Sebas",  12.34) {
        };
    }

    @Test
    public void getRekeningNaam() {
        assertEquals("Sebas",rekening.getNaam());
    }

    @Test
    public void getRekeningNr() {
        assertEquals(1234,rekening.getRekeningNr());
    }

    @Test
    public void getSaldo() {
        assertEquals(12.34,rekening.getSaldo(), DELTA);
    }

}