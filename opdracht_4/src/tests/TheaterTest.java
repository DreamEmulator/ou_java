//TODO:
//        - Het is de bedoeling dat de bijgeleverde TheaterApplicatie.java je programma kan aansturen. Er zou dus, bijvoorbeeld, een nieuweVoorstelling en getAantalPlaatsen methoden in Theater moeten zijn.
//        - Hoewel het een leuk ontwerp is, is het hierdoor dus ook niet de bedoeling dat de dichtsbijzijnste plaats gezocht wordt als een niet vrije plaats wordt gereserveerd
//        - De functie getHoogsteKlantnummer is onnodig. Je slaat het hoogste klantnummer al op in een attribuut, deze kun je zo aanspreken.
//        - Het afhandelen van Klant en Voortelling objecten is de verantwoordelijkheid van de Theater klasse. Maw, er is geen reden om publieke getters te maken die deze objecten teruggeven.
//        - Dezelfde klant kan nu meerdere keren toegevoegd worden.
//        - Plaats heeft volgens het klasse diagram een referentie naar Klant. De link is dus geen klantInfo attribuut, maar gewoon een Klant attribuut.
//        - Het is de verantwoordelijkheid van Plaats om de status te wijzigen. Ik zou setStatus dus private maken en een publieke functie die de status naar gereserveerd en vrij zet (zoals nu ook voor plaatsBezetten). Op deze manier voorkom je ook het zetten op BEZET, zonder een klant.
//        - Ik heb met de corrector overlegd en het is alleen nodig om alle niet-triviale publieke methoden te testen (getters en setters die niks aanpassen kun je negeren).
//        - Breidt je testen uit. Test ook voor zaken die fout kunnen gaan (een stoel plaatsReserveren buiten de array, een klant zoeken die niet bestaat, etc.)

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
    public void reserveren(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");

        theater.reserveren(1,1);
        theater.reserveren(2,2);
        theater.reserveren(3,3);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveren(1,21);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveren(21,1);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveren(-1,1);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveren(1,-1);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.reserveren(0,0);
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));
    }

    @Test
    public void plaatsen(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");

        theater.reserveren(4,4);
        theater.reserveren(5,5);
        theater.reserveren(6,6);

        theater.plaatsen("Bartel-Jaap","06123456");
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.BEZET));

        theater.reserveren(0,1);
        theater.reserveren(1,0);
        theater.reserveren(1,-1);
        theater.reserveren(-1,1);

        theater.reserveren(100,-1);
        theater.reserveren(-1,100);

        theater.plaatsen("Bartel-Jaap","06123456");
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.BEZET));
    }

    @Test
    public void resetten(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");

        theater.reserveren(8,8);
        theater.reserveren(9,9);
        theater.reserveren(10,10);

        theater.resetten();

        assertEquals(0,theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");

        theater.reserveren(1,1);
        theater.reserveren(2,2);
        theater.reserveren(3,3);

        theater.plaatsen("Bartel-Jaap","06123456");

        theater.reserveren(4,4);
        theater.reserveren(5,5);
        theater.reserveren(6,6);

        theater.resetten();

        assertEquals(0,theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));
    }

    @Test
    public void getAantalPlaatsen(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");

        theater.reserveren(8,8);
        theater.reserveren(9,9);
        theater.reserveren(10,10);
        assertEquals(147, theater.getAantalPlaatsen(Plaats.Status.VRIJ));
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));

        theater.plaatsen("Bartel-Jaap","06123456");
        assertEquals(3, theater.getAantalPlaatsen(Plaats.Status.BEZET));
    }

}