package tests;

import bank.Bank;
import org.junit.Before;
import org.junit.Test;
import bank.Rekening;

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
        assertEquals(9180, bank.getDebitRekeningSaldo(), DELTA);
//TODO: Extra tests BIJV. Probeer het precies op nul te krijgen
    }
}