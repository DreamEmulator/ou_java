package test;

import rekening.Rekening;

/*
 * Testklasse voor klasse Rekening.
 */
public class RekeningTest {

   public static void main(String[] args) {
    String naam = "OUNL";
    int nummer = 1111;
    double storting = 12.50;
    double opname = 7.0; 
    
    Rekening mijnRekening = new Rekening(naam, nummer);
    
    System.out.println("naam  :" + mijnRekening.getNaam());
    System.out.println("nummer:" + mijnRekening.getNummer());
    System.out.println("saldo :" + mijnRekening.getSaldo());
    
    mijnRekening.stort(storting);
    System.out.println("saldo na storting van " + storting + ": " + mijnRekening.getSaldo());
    
    mijnRekening.neemOp(opname);
    System.out.println("saldo na opname van    " + opname + ": " + mijnRekening.getSaldo());

  }

}
