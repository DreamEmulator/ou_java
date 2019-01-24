package dobbelsteen;

import java.util.Random;

/*
 * Klasse die verantwoordelijk is voor het genereren en 
 * toegankelijk maken van een willekeurig getal tussen 
 * 1 en 6.
 */
public class Dobbelsteen {
  private int ogen = 0;
  
  /*
   * Maakt een nieuwe Dobbelsteen-instantie en genereert en 
   * bewaart een waarde tussen 1 en 6.
   */
  public Dobbelsteen(){
    this.werp();
  }
  
  public int getOgen(){
    return ogen;
  }
  
  /*
   * Genereert en bewaart een waarde tussen 1 en 6.
   */
  public void werp(){
    Random r= new Random();
    ogen = r.nextInt(6) + 1;
  }
}
