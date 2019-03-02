package tests;

import org.junit.Before;
import org.junit.Test;
import theater.Theater;

import static org.junit.Assert.*;

public class TheaterTest {

    Theater theater;
    @Before
    public void setUp() throws Exception {
        theater = new Theater(1000,"Theater De Glijert");
    }

    @Test
    public void getHoogsteklantnummer() {
    }

    @Test
    public void getNaam() {
    }
}