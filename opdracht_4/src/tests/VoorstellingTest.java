package tests;

import org.junit.Before;
import org.junit.Test;
import theater.Plaats;
import theater.Voorstelling;

import static org.junit.Assert.*;

public class VoorstellingTest {

    Voorstelling voorstelling;

    @Before
    public void setUp(){
        voorstelling = new Voorstelling("Das Boot","05-05-1945");
    }

}