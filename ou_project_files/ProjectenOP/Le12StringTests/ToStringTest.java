import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import tegels.KruisTegel;
import verkiezingen.Partij;

/*
 * Deze klasse toont het effect van een aanroep van toString() op
 * verschillende soorten objecten.
 */
public class ToStringTest {

  public static void main(String[] args) {
    Integer iobj = 29;
    System.out.println(iobj.toString());
    Double dobj = 30.5;
    System.out.println(dobj.toString());
    Boolean bobj = true;
    System.out.println(bobj.toString());
    
    GregorianCalendar gc = new GregorianCalendar(2008, Calendar.JANUARY, 1);
    System.out.println(gc.toString());
    KruisTegel tegel = new KruisTegel(Color.BLUE);
    System.out.println(tegel.toString());
    Partij sgp = new Partij("SGP");
    System.out.println(sgp);
    
    System.out.println((double)1.1f);
  }

}
