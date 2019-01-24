package life;
/*
 * Deze klasse representeert een generatie van cellen
 * op een veld. De afmeting van het veld is vastgelegd door
 * de constanten BREEDTE en HOOGTE.
 * Cellen kunnen groeien naar een volgende generatie
 * volgens de regels van Game of Life van John Conway.
 */
public class Life {
  // constanten  
  public static final int BREEDTE = 40;
  public static final int HOOGTE = 25;

  // attributen  

  // constructor
  public Life() {
  }
  
  /*
   * Geeft de status van de cel op rij i en kolom j.
   * Voorwaarde: 0 <= i < HOOGTE en 0 <= j < BREEDTE
   */
  public boolean isBevolkt(int i, int j) {
    return false;
  }
  
  /*
   * Verandert de status van een cel. Een bevolkte cel
   * wordt onbevolkt en andersom.
   * Voorwaarde: 0 <= i < HOOGTE en 0 <= j < BREEDTE
   */
  public void wisselBevolking(int i, int j) {
  }
  
  /*
   * Kent aan lifecel de volgende generatie cellen toe
   */ 
  public void nieuweGeneratie() {
  }

}

