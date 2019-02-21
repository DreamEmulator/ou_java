package tests;

import bank_domain.Bank;
import org.junit.Before;
import org.junit.Test;
import bank_domain.Rekening;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 * De Bank is de baas daar worden alle storten, opnemen, overmaken tests uitgevoerd.
 * Rekening is alleen public toegankelijk voor het opvragen van info.
 */

public class TestBank {

    private Bank bank;
    private static final double DELTA = 0.01;

    @Before
    public void setUp() {
// Dataset
        ArrayList<Rekening> rekeningen = new ArrayList();
        rekeningen.add(new Rekening(1111, "Fabian", 14.56));
        rekeningen.add(new Rekening(3333, "Beatrix", 10209.67));
        rekeningen.add(new Rekening(1234, "Fenia", 24.63));

// Create Bank domainlayer and GUI
         bank = new Bank(rekeningen);
    }

    @Test
    public void setDebitRekeningNr() {
        bank.setDebitRekeningNr(1111);
        assertEquals(1111, bank.getDebitRekeningNr());
        bank.setDebitRekeningNr(8888);
        assertNotEquals(8888, bank.getDebitRekeningNr());
    }

    @Test
    public void setCreditRekeningNr() {
        bank.setCreditRekeningNr(1111);
        assertEquals(1111, bank.getCreditRekeningNr());
        bank.setCreditRekeningNr(8888);
        assertNotEquals(8888, bank.getCreditRekeningNr());
    }

    @Test
    public void requestTransactie() {
        bank.setDebitRekeningNr(3333);
        bank.setCreditRekeningNr(1234);

        //Saldo checken
        assertEquals(10209.67, bank.getDebitRekeningSaldo(), DELTA);
        assertEquals(24.63, bank.getCreditRekeningSaldo(), DELTA);

        //Opnemen
        bank.requestTransactie(0,3333, 9.67);
        assertEquals(10200, bank.getDebitRekeningSaldo(), DELTA);
        bank.requestTransactie(0,3333, -5);
        assertEquals(10200, bank.getDebitRekeningSaldo(), DELTA);
        bank.requestTransactie(0,3333, 10201);
        assertEquals(10200, bank.getDebitRekeningSaldo(), DELTA);

        //Storten
        bank.requestTransactie(1,1234, 9.67);
        assertEquals(10200, bank.getDebitRekeningSaldo(), DELTA);
        bank.requestTransactie(1,1234, -5);
        assertEquals(10200, bank.getDebitRekeningSaldo(), DELTA);

        //Overmaken
        bank.requestTransactie(2,3333, 1234, 1020);
        assertEquals(9180, bank.getDebitRekeningSaldo(), DELTA);
        bank.requestTransactie(2,3333, 1234, 10201020);
        assertEquals(9180, bank.getDebitRekeningSaldo(), DELTA);
        bank.requestTransactie(2,3333, 1234, -10201020);
        assertEquals(9180, bank.getDebitRekeningSaldo(), DELTA);
    }
}