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

// Create Bank domainlayer and GUI
         bank = new Bank(rekeningen);
    }

    @Test
    public void getDebitRekeningNr() {
        bank.setDebitRekeningNr(1111);
        assertEquals(1111,bank.getDebitRekeningNr());
        bank.setDebitRekeningNr(1234);
        assertEquals(1234,bank.getDebitRekeningNr());
        bank.setDebitRekeningNr(7777);
        assertNotEquals(7777,bank.getDebitRekeningNr());
    }

    @Test
    public void getCreditRekeningNr() {
        bank.setCreditRekeningNr(1234);
        assertEquals(1234,bank.getCreditRekeningNr());
        bank.setCreditRekeningNr(1234);
        assertEquals(1234,bank.getCreditRekeningNr());
        bank.setCreditRekeningNr(7777);
        assertNotEquals(7777,bank.getCreditRekeningNr());
    }

    @Test
    public void getDebitRekeningNaam() {
        bank.setDebitRekeningNr(1111);
        assertEquals("Fabian", bank.getDebitRekeningNaam());
        assertNotEquals("Fenia", bank.getDebitRekeningNaam());
        bank.setDebitRekeningNr(2345);
        assertEquals("Sebas", bank.getDebitRekeningNaam());
        assertNotEquals("Beatrix", bank.getDebitRekeningNaam());
        assertNotEquals("sebas", bank.getDebitRekeningNaam());
    }

    @Test
    public void getCreditRekeningNaam() {
        bank.setCreditRekeningNr(1234);
        assertEquals("Fenia", bank.getCreditRekeningNaam());
        assertNotEquals("Fabian", bank.getCreditRekeningNaam());
        bank.setCreditRekeningNr(2345);
        assertEquals("Sebas", bank.getCreditRekeningNaam());
        assertNotEquals("Beatrix", bank.getCreditRekeningNaam());
        assertNotEquals("sebas", bank.getCreditRekeningNaam());
    }

    @Test
    public void getDebitRekeningSaldo() {
        bank.setDebitRekeningNr(1111);
        assertEquals(14.56, bank.getDebitRekeningSaldo(), DELTA);
        bank.requestTransactie(0,1111,12.32);
        assertEquals(2.24,bank.getDebitRekeningSaldo(), DELTA);
        bank.requestTransactie(1,1111,12.32);
        assertEquals(14.56, bank.getDebitRekeningSaldo(), DELTA);
    }

    @Test
    public void getCreditRekeningSaldo() {
        bank.setCreditRekeningNr(1234);
        assertEquals(24.63, bank.getCreditRekeningSaldo(), DELTA);
        bank.requestTransactie(0,1234,12.32);
        assertEquals(12.31,bank.getCreditRekeningSaldo(), DELTA);
    }

    @Test
    public void setDebitRekeningNr() {
        bank.setDebitRekeningNr(3333);
        assertEquals(3333, bank.getDebitRekeningNr());
        bank.setDebitRekeningNr(10000000);
        assertNotEquals(10000000, bank.getDebitRekeningNr());
        bank.setDebitRekeningNr(-1);
        assertNotEquals(-1, bank.getDebitRekeningNr());
        bank.setDebitRekeningNr(0);
        assertNotEquals(0, bank.getDebitRekeningNr());
    }

    @Test
    public void setCreditRekeningNr() {
        bank.setCreditRekeningNr(3333);
        assertEquals(3333, bank.getCreditRekeningNr());
        bank.setCreditRekeningNr(10000000);
        assertNotEquals(10000000, bank.getCreditRekeningNr());
        bank.setCreditRekeningNr(-1);
        assertNotEquals(-1, bank.getCreditRekeningNr());
        bank.setCreditRekeningNr(0);
        assertNotEquals(0, bank.getCreditRekeningNr());
    }

    @Test
    public void requestTransactie() {
        bank.setDebitRekeningNr(3333);
        bank.setCreditRekeningNr(1234);

        assertEquals(10209.67, bank.getDebitRekeningSaldo(), DELTA);
        assertEquals(24.63, bank.getCreditRekeningSaldo(), DELTA);

        //Opnemen
        bank.requestTransactie(0,3333, 9.67);
        assertEquals(10200, bank.getDebitRekeningSaldo(), DELTA);

        //Storten
        bank.requestTransactie(1,1234, 9.67);
        assertEquals(10200, bank.getDebitRekeningSaldo(), DELTA);

      //Overmaken
        bank.requestTransactie(2,3333, 1234, 1020);
        System.out.println(bank.getDebitRekeningSaldo());
        assertEquals(9180, bank.getDebitRekeningSaldo(), DELTA);
//TODO: Extra tests BIJV. Probeer het precies op nul te krijgen
    }
}