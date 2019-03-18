//TODO:
//        - Het is de bedoeling dat de bijgeleverde TheaterApplicatie.java je programma kan aansturen. Er zou dus, bijvoorbeeld, een nieuweVoorstelling en getAantalPlaatsen methoden in Theater moeten zijn.
//        - Hoewel het een leuk ontwerp is, is het hierdoor dus ook niet de bedoeling dat de dichtsbijzijnste plaats gezocht wordt als een niet vrije plaats wordt gereserveerd
//        - De functie getHoogsteKlantnummer is onnodig. Je slaat het hoogste klantnummer al op in een attribuut, deze kun je zo aanspreken.
//        - Het afhandelen van Klant en Voortelling objecten is de verantwoordelijkheid van de Theater klasse. Maw, er is geen reden om publieke getters te maken die deze objecten teruggeven.
//        - Dezelfde klant kan nu meerdere keren toegevoegd worden.
//        - Plaats heeft volgens het klasse diagram een referentie naar Klant. De link is dus geen klantInfo attribuut, maar gewoon een Klant attribuut.
//        - Het is de verantwoordelijkheid van Plaats om de status te wijzigen. Ik zou setStatus dus private maken en een publieke functie die de status naar gereserveerd en vrij zet (zoals nu ook voor plaatsToekennen). Op deze manier voorkom je ook het zetten op BEZET, zonder een klant.
//        - Ik heb met de corrector overlegd en het is alleen nodig om alle niet-triviale publieke methoden te testen (getters en setters die niks aanpassen kun je negeren).
//        - Breidt je testen uit. Test ook voor zaken die fout kunnen gaan (een stoel reserveren buiten de array, een klant zoeken die niet bestaat, etc.)

// Toelichting:
// Ik heb de les gevolgd en alle methodes zo dicht mogelijk gezet. Hierdoor wordt alleen Theater publiekelijk beschikbaar en worden alle moethodes van Voorstelling, Plaats en Klant getest door theater.


        package tests;

import org.junit.Before;
import org.junit.Test;
import theater.Plaats;
import theater.Theater;

import static org.junit.Assert.*;

public class TheaterTest {

    Theater theater;
    @Before
    public void setUp() throws Exception{
        theater = new Theater("Theater De Kaap");
    }

    @Test
    public void nieuweKlant(){
        theater.nieuweKlant("Bartel-Jaap","06123456");
        theater.nieuweKlant("Bill","06123456");
        theater.nieuweKlant("Margiet","06123456");
    }

    @Test
    public void reserveer(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");

        theater.reserveer(1,1);
        theater.reserveer(2,2);
        theater.reserveer(3,3);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveer(1,21);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveer(21,1);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveer(-1,1);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveer(1,-1);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveer(0,0);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));
    }

    @Test
    public void plaatsKlant(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");

        theater.reserveer(4,4);
        theater.reserveer(5,5);
        theater.reserveer(6,6);

        theater.plaatsKlant("Bartel-Jaap","06123456");
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.BEZET));

        theater.reserveer(0,1);
        theater.reserveer(1,0);
        theater.reserveer(1,-1);
        theater.reserveer(-1,1);

        theater.reserveer(100,-1);
        theater.reserveer(-1,100);

        theater.plaatsKlant("Bartel-Jaap","06123456");
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.BEZET));
    }

    @Test
    public void resetAlleReserveringen(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");

        theater.reserveer(8,8);
        theater.reserveer(9,9);
        theater.reserveer(10,10);

        theater.resetReservering();

        assertEquals(0,theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");

        theater.reserveer(1,1);
        theater.reserveer(2,2);
        theater.reserveer(3,3);

        theater.plaatsKlant("Bartel-Jaap","06123456");

        theater.reserveer(4,4);
        theater.reserveer(5,5);
        theater.reserveer(6,6);

        theater.resetReservering();

        assertEquals(0,theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));
    }

    @Test public void getAantalPlaatsen(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");

        theater.reserveer(8,8);
        theater.reserveer(9,9);
        theater.reserveer(10,10);
        assertEquals(147, theater.getAantalPlaatsen(Plaats.Status.VRIJ));
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.plaatsKlant("Bartel-Jaap","06123456");
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.BEZET));
    }

}