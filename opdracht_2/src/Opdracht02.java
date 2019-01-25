import java.util.ArrayList;

public class Opdracht02 {

    public static void main(String[] args) {

        ArrayList<Rekening> rekeningen = new ArrayList();
        rekeningen.add(new Rekening(1111,"Fabian", 14.56));
        rekeningen.add(new Rekening(1234,"Fenia", 24.63));
        rekeningen.add(new Rekening(2222,"Hugo", 15.67));
        rekeningen.add(new Rekening(2345,"Sebas", 5.67));
        rekeningen.add(new Rekening(3333,"Beatrix", 10209.67));

        Bank bank = new Bank(rekeningen);

        new BankTest(bank);
        new RekeningTest(rekeningen.get(0));

    }
}
