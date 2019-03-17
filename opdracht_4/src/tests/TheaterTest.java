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
        theater = new Theater("Theater De Glijert");
    }

    @Test
    public void nieuweKlant(){
        theater.nieuweKlant("Bartel-Jaap","06123456");
        theater.nieuweKlant("Bill","06123456");
        theater.nieuweKlant("Margiet","06123456");
    }

    @Test
    public void getStatusPlaatsenAantal(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.reserveer(1,1);
        theater.reserveer(2,2);
        theater.reserveer(3,3);
        theater.reserveer(4,4);
        theater.reserveer(5,5);
        theater.reserveer(6,6);
        theater.reserveer(7,7);
        theater.reserveer(8,8);
        theater.reserveer(9,9);
        theater.reserveer(10,10);
        assertEquals(10, theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));
        System.out.println("\nKlant gereserveerd: ");
        theater.printVoorstelling();
    }

    @Test
    public void plaatsKlant(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");
        theater.reserveer(1,1);
        theater.reserveer(2,2);
        theater.reserveer(3,3);
        theater.reserveer(4,4);
        theater.reserveer(5,5);
        theater.reserveer(6,6);
        theater.reserveer(7,7);
        theater.reserveer(8,8);
        theater.reserveer(9,9);
        theater.reserveer(10,10);
        theater.plaatsKlant("Bartel-Jaap","06123456");
        assertEquals(10, theater.getAantalPlaatsen(Plaats.Status.BEZET));
        System.out.println("\nKlant geplaatst: ");
        theater.printVoorstelling();
    }

    @Test
    public void resetAlleReserveringen(){
        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");
        theater.reserveer(1,1);
        theater.reserveer(2,2);
        theater.reserveer(3,3);
        theater.reserveer(4,4);
        theater.reserveer(5,5);
        theater.reserveer(6,6);
        theater.reserveer(7,7);
        theater.reserveer(8,8);
        theater.reserveer(9,9);
        theater.reserveer(10,10);
        theater.resetReservering();
        assertEquals(0,theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));
        System.out.println("\nVoorstelling geleegd: ");
        theater.printVoorstelling();

        theater.nieuweVoorstelling("Rundfunk de Musical", "13-09-2019");
        theater.nieuweKlant("Bartel-Jaap","06123456");
        theater.reserveer(1,1);
        theater.reserveer(2,2);
        theater.reserveer(3,3);
        theater.reserveer(4,4);
        theater.reserveer(5,5);
        theater.plaatsKlant("Bartel-Jaap","06123456");
        theater.reserveer(6,6);
        theater.reserveer(7,7);
        theater.reserveer(8,8);
        theater.reserveer(9,9);
        theater.reserveer(10,10);
        theater.resetReservering();
        assertEquals(0,theater.getAantalPlaatsen(Plaats.Status.GERESERVEERD));
        System.out.println("\nVoorstelling deels geleegd: ");
        theater.printVoorstelling();
    }

    @Test
    public void getNaam(){
        assertEquals("Theater De Glijert", theater.getNaam());
    }

}