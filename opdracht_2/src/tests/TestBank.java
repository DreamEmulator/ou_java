package tests;

import bank.Bank;
import org.junit.Before;
import org.junit.Test;
import rekening.Rekening;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestBank {

    Bank bank;
    private static final double DELTA = 0.01;
    @Before
    public void setUp() throws Exception {
// Dataset
        ArrayList<Rekening> rekeningen = new ArrayList();
        rekeningen.add(new Rekening(1111, "Fabian", 14.56));
        rekeningen.add(new Rekening(1234, "Fenia", 24.63));
        rekeningen.add(new Rekening(2222, "Hugo", 15.67));
        rekeningen.add(new Rekening(2345, "Sebas", 5.67));
        rekeningen.add(new Rekening(3333, "Beatrix", 10209.67));

// Set intial accounts rekeningen
        int debitRekeningNr = 1111;
        int creditRekeningNr = 1234;

// Create Bank domainlayer and GUI
         bank = new Bank(rekeningen, debitRekeningNr, creditRekeningNr);
    }

    @Test
    public void getDebitRekeningNr() {
        assertEquals(1111,bank.getDebitRekeningNr());
        bank.setDebitRekeningNr(1234);
        assertEquals(1234,bank.getDebitRekeningNr());
        bank.setDebitRekeningNr(7777);
        assertNotEquals(7777,bank.getDebitRekeningNr());
    }

    @Test
    public void getCreditRekeningNr() {
        assertEquals(1234,bank.getCreditRekeningNr());
        bank.setCreditRekeningNr(1234);
        assertEquals(1234,bank.getCreditRekeningNr());
        bank.setCreditRekeningNr(7777);
        assertNotEquals(7777,bank.getCreditRekeningNr());
    }

    @Test
    public void getDebitRekeningNaam() {
        assertEquals("Fabian", bank.getDebitRekeningNaam());
        assertNotEquals("Fenia", bank.getDebitRekeningNaam());
        bank.setDebitRekeningNr(2345);
        assertEquals("Sebas", bank.getDebitRekeningNaam());
        assertNotEquals("Beatrix", bank.getDebitRekeningNaam());
        assertNotEquals("sebas", bank.getDebitRekeningNaam());
    }

    @Test
    public void getCreditRekeningNaam() {
        assertEquals("Fenia", bank.getCreditRekeningNaam());
        assertNotEquals("Fabian", bank.getCreditRekeningNaam());
        bank.setCreditRekeningNr(2345);
        assertEquals("Sebas", bank.getCreditRekeningNaam());
        assertNotEquals("Beatrix", bank.getCreditRekeningNaam());
        assertNotEquals("sebas", bank.getCreditRekeningNaam());
    }

    @Test
    public void getDebitRekeningSaldo() {
        assertEquals(14.56, bank.getDebitRekeningSaldo(), DELTA);
        bank.requestMutatie(0,0,1111,12.32);
        assertEquals(2.24,bank.getDebitRekeningSaldo(), DELTA);
        bank.requestMutatie(1,0,1111,12.32);
        assertEquals(14.56, bank.getDebitRekeningSaldo(), DELTA);
    }

    @Test
    public void getCreditRekeningSaldo() {
        assertEquals(24.63, bank.getCreditRekeningSaldo(), DELTA);
        bank.requestMutatie(0,1,1234,12.32);
        assertEquals(12.31,bank.getCreditRekeningSaldo(), DELTA);
    }

    @Test
    public void setDebitRekeningNr() {
    }

    @Test
    public void setCreditRekeningNr() {
    }

    @Test
    public void requestMutatie() {
    }

    @Test
    public void requestTransactie() {
    }
}