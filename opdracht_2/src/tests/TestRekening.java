package tests;

import org.junit.Before;
import org.junit.Test;
import rekening.Rekening;

import static org.junit.Assert.*;

public class TestRekening {

    Rekening rekening;
    private static final double DELTA = 0.01;

    @Before
    public void setUp() throws Exception {
        rekening = new Rekening(3333, "Beatrix", 10209.67);
    }

    @Test
    public void getNaam() {
        assertEquals("Beatrix", rekening.getNaam());
    }

    @Test
    public void getSaldo() {
        assertEquals(10209.67, rekening.getSaldo(), DELTA);
    }

    @Test
    public void getRekeningNr() {
        assertEquals(3333, rekening.getRekeningNr(), DELTA);
    }

    @Test
    public void stortBedrag() {
        rekening.stortBedrag(3781);
        assertEquals(13990.67, rekening.getSaldo(), DELTA);
    }

    @Test
    public void neemBedragOp() {
        rekening.neemBedragOp(3781);
        assertEquals(6428.67, rekening.getSaldo(), DELTA);
    }
}