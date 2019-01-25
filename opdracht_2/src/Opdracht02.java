import java.util.ArrayList;

public class Opdracht02 {

    public static void main(String[] args) {

        ArrayList<Rekening> rekeningen = new ArrayList();

        rekeningen.add(new Rekening(8563,"Fabian", 14.56));
        rekeningen.add(new Rekening(7823,"Fenia", 24.63));
        rekeningen.add(new Rekening(9356,"Hugo", 5.67));

        Bank bank = new Bank(rekeningen);

        Rekening rekening = bank.getRekening(8563);

        System.out.println("\n" + rekening.getNaam() + " heeft " + rekening.getSaldo() + " pingels");

        System.out.println("\nNu krijgt "  + rekening.getNaam() + " 15 extra \n");

        rekening.setSaldo(15.00);

    }
}
