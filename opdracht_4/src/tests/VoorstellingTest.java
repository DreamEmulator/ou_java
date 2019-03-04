package tests;

import org.junit.Before;
import org.junit.Test;
import theater.Voorstelling;

import static org.junit.Assert.*;

public class VoorstellingTest {

    Voorstelling voorstelling;
    @Before
    public void setUp() throws Exception {
        voorstelling = new Voorstelling("Das Boot","05-05-1945");
    }

    @Test
    public void getNaam() {
    }

    @Test
    public void getDatum() {
    }

    @Test
    public void printVoorstelling(){
        voorstelling.printVoorstelling();
    }
}