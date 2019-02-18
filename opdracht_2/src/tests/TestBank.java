package tests;

import bank.Bank;
import org.junit.Before;
import org.junit.Test;
import rekening.Rekening;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestBank {

    Bank bank;
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
        assertEquals(bank.getDebitRekeningNr(),1111);
    }

    @Test
    public void getCreditRekeningNr() {
    }

    @Test
    public void getDebitRekeningNaam() {
    }

    @Test
    public void getCreditRekeningNaam() {
    }

    @Test
    public void getDebitRekeningSaldo() {
    }

    @Test
    public void getCreditRekeningSaldo() {
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