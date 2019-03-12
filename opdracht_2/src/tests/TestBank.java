package tests;

import bank_domain.Bank;
import bank_domain.Rekening;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBank {

    private Bank bank;
    private static final double DELTA = 0.01;

    @Before
    public void setUp() {
         bank = new Bank();
    }

    @Test
    public void zoekRekening(){
        Rekening rekening = bank.zoekRekening(1111);
        assertNotEquals(null,rekening);
        rekening = bank.zoekRekening(0000);
        assertEquals(null,rekening);
    }

    @Test
    public void storten(){
        bank.storten(1111,12.00);
        assertEquals(26.56,bank.zoekRekening(1111).getSaldo(),DELTA);
        bank.storten(1111,-12.00);
        assertEquals(26.56,bank.zoekRekening(1111).getSaldo(),DELTA);
    }

    @Test
    public void opnemen(){
        bank.opnemen(1111,12.00);
        assertEquals(2.56,bank.zoekRekening(1111).getSaldo(),DELTA);
        bank.opnemen(1111,3.00);
        assertEquals(2.56,bank.zoekRekening(1111).getSaldo(),DELTA);
        bank.opnemen(1111,-5.00);
        assertEquals(2.56,bank.zoekRekening(1111).getSaldo(),DELTA);
    }

    @Test
    public void overmaken(){
        bank.overmaken(1111,1234, 12.00);
        assertEquals(2.56,bank.zoekRekening(1111).getSaldo(),DELTA);
        assertEquals(36.62,bank.zoekRekening(1234).getSaldo(),DELTA);
        bank.overmaken(1111,1234, 3);
        assertEquals(2.56,bank.zoekRekening(1111).getSaldo(),DELTA);
        assertEquals(36.62,bank.zoekRekening(1234).getSaldo(),DELTA);
        bank.overmaken(1111,1234, -5);
        assertEquals(2.56,bank.zoekRekening(1111).getSaldo(),DELTA);
        assertEquals(36.62,bank.zoekRekening(1234).getSaldo(),DELTA);
    }
}