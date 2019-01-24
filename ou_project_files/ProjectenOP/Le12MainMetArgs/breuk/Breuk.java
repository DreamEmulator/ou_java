package breuk;

/*
 * Deze klasse representeert een breuk met teller
 * en noemer van type long met teller >= 0 en noemer > 0.
 * @author Medewerker OUNL
 */
public class Breuk {
  private long teller = 0, noemer = 1;
  
  /*
   * Creëert een nieuwe breuk.
   * Als teller of noemer niet aan de voorwaarde voldoet,
   * blijft teller 0 en noemer 1.
   */
  public Breuk(long teller, long noemer){
    if (teller >= 0 && noemer > 0) {
      this.teller = teller;
      this.noemer = noemer;
    }
  }
  
  public long getTeller() {
    return teller;
  }
  
  public long getNoemer() {
    return noemer;
  }
  
  /*
   * Vereenvoudigt de breuk door teller en noemer
   * te delen door hun grootste gemene deler.
   */
  public void vereenvoudig() {
    /* Dit is het inefficiënte algoritme:
     
    if (teller == 0) {
      noemer = 1;
    } else {
      long deler = Math.min(teller, noemer);
      while (!(teller % deler == 0 && noemer % deler == 0)) {
        deler--;
      }
      teller = teller / deler;
      noemer = noemer / deler;
    }
    */
    
    // Dit is het algoritme van Euclides
    long grootste = noemer;
    long kleinste = teller;
    while (kleinste != 0) {
      long rest = grootste % kleinste;
      grootste = kleinste;
      kleinste = rest;
    }
    teller = teller / grootste;
    noemer = noemer / grootste;
  }
}
