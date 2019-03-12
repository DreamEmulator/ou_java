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
         bank = new Bank();
    }

    @Test
    public void overmaken(){
        bank.overmaken(1111,1234, 12.00);
    }

    @Test
    public void storten(){
        bank.storten(1111,12.00);
    }

    @Test
    public void opnemen(){
        bank.opnemen(1111,12.00);
    }
}