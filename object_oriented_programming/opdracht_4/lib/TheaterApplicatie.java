//Toelichting:
//Ik heb in regel 20 en 21 nieuwe klanten toegevoegd, wellicht hadden deze standaard in het theater geplaatst moeten worden maar dat voelde een beetje vreemd om te doen

import theater.Theater;
import theater.Plaats.Status;

/**
 * Voorbeeldprogramma voor de theaterapplicatie.
 */
public class TheaterApplicatie {

  /**
   * Main programma.
   * @param args niet gebruikt
   */
  public static void main(String[] args) {

    Theater theater = new Theater("Chass Theater");
    theater.nieuweVoorstelling("War Horse", "26-12-2014");
    theater.nieuweKlant("Kok", "0678912345");
    theater.nieuweKlant("Pootjes", "0654321987");
    printInfo(theater);
    // plaatsReserveren een aantal plaatsen
    theater.reserveren(3, 3);
    theater.reserveren(3, 4);
    theater.reserveren(3, 5);
    theater.reserveren(3, 6);
    theater.reserveren(-1, 1); //  buiten grenzen
    theater.reserveren(100, 200); // buiten grenzen
    printInfo(theater);
    // plaats klant op gereserveerde plaatsen
    theater.plaatsen("Kok", "0678912345");
    printInfo(theater);
    // plaatsReserveren een aantal plaatsen
    theater.reserveren(3, 3); // is al bezet
    theater.reserveren(4, 3);
    theater.reserveren(4, 4);
    printInfo(theater);
    // plaats klant op gereserveerde plaatsen
    theater.plaatsen("Pootjes", "0654321987");
    printInfo(theater);
    // plaatsReserveren een aantal plaatsen
    theater.reserveren(5, 1);
    theater.reserveren(5, 2);
    theater.reserveren(5, 3);
    printInfo(theater);
    // cancel reserveringen
    theater.resetten();
    printInfo(theater);
  }


  private static void printInfo(Theater theater) {
    System.out.println("VRIJ: " + theater.getAantalPlaatsen(Status.VRIJ) +
            " / GERESERVEERD: " + theater.getAantalPlaatsen(Status.GERESERVEERD) +
            " / BEZET: " + theater.getAantalPlaatsen(Status.BEZET));
  }
}
