/*
 * Deze klasse toont het verschil tussen creatie van Strings 
 * met en creatie van Strings zonder new.
 */
public class StringGelijkheidTest {

  public static void main(String[] args) {
    String s1 = new String("Gelijk of niet?");
    String s2 = new String("Gelijk of niet?");   
    System.out.println("s1 == s2 is " + (s1 == s2));
  }
}