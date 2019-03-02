package tests;

import theater.Klant;

import static org.junit.Assert.*;

public class KlantTest {

    Klant klant;

    @org.junit.Before
    public void setUp() throws Exception {
        klant = new Klant("Bartel-Jaap",01,06123456);
    }

    @org.junit.Test
    public void getNaam() {
    }

    @org.junit.Test
    public void getTelefoon() {
    }

    @org.junit.Test
    public void getKlantnummer() {
    }

    @org.junit.Test
    public void klantToString() {

    }
}