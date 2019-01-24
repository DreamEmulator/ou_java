package somtest;

import org.junit.Test;
import static org.junit.Assert.*;

public class SomTest {

  /**
   * Berekent de som van de eerste n niet-negatieve gehele  
   * getallen.
   * @param   n  het aantal op te tellen getallen
   * @return  de som van de eerste n niet-negatieve gehele 
   *          getallen
   */
  public static int som(int n) {
    int resultaat = 0;
    for (int i = 0; i <= n; i++)
      resultaat = resultaat + i;
    return resultaat;
  }
  
  @Test
  public void testSom() {
    //test nog te implementeren
  }

}
