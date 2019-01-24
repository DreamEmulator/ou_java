package breuk;

/*
 * Testklasse voor de klasse Breuk.
 * Deze klasse heeft een methode main met parameters.
 */
public class TestBreuk {

  public static void main(String[] args) {
    long teller = Long.parseLong(args[0]);
    long noemer = Long.parseLong (args[1]);
    Breuk b = new Breuk(teller, noemer);
    b.vereenvoudig();
    System.out.println(
            teller + "/" + noemer + " = "
            + b.getTeller() + "/" + b.getNoemer());

  }
}

