package schrikkeltest;

import org.junit.Test;
import static org.junit.Assert.*;

public class SchrikkelTest {
  
  /**
   * Gaat na of het gegeven jaartal (na 1582) een schrikkeljaar is.
   * Een jaar na 1582 is een schrikkeljaar als het jaartal deelbaar 
   * is door 4 maar niet door 100, tenzij ook door 400.
   * Voorwaarde: jaartal is groter dan 1582.
   * @param   jaartal  het jaartal
   * @return  true als jaartal een schrikkeljaar is, anders  
   * false
   */
  public boolean isSchrikkeljaar(int jaartal) {
    if ((jaartal % 400 == 0) || (jaartal % 4 == 0) && 
        (jaartal % 100 != 0)) {
      return true;
    }
    return false;
  }

  @Test
  public void testIsSchrikkeljaar() {
    //1782 is geen schrikkeljaar
    assertEquals(false, isSchrikkeljaar(1782));
    
    //1972 is wel een schrikkeljaar
    assertEquals(true, isSchrikkeljaar(1972));    
    
    //1500 is geen schrikkeljaar
    assertFalse(isSchrikkeljaar(1500));

    //2000 is wel een schrikkeljaar
    assertTrue(isSchrikkeljaar(2000));

    //2001, 2002, 2003 zijn geen schrikkeljaren
    for (int i = 1; i <=3; i++)
      assertFalse(isSchrikkeljaar(2000+i));

    //2004 is wel een schrikkeljaar
    assertTrue(isSchrikkeljaar(2004));
    
    //1789 is geen schrikkeljaar
    assertFalse(isSchrikkeljaar(1789));
  }
}
