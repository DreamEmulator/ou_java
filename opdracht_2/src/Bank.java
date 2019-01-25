import java.util.ArrayList;

public class Bank {

    public static void main(String[] args) {

        System.out.println("\nWelkom bij Hols Bank onze klanten zijn:\n");
        new Bank();

    }

    ArrayList<Rekening> rekeningen;

    public Bank() {
        this.rekeningen = new ArrayList();
        rekeningen.add(new Rekening(8563,"Fabian", 14.56));
        rekeningen.add(new Rekening(7823,"Fenia", 24.63));
        rekeningen.add(new Rekening(9356,"Hugo", 5.67));

        System.out.println(getRekening(8563).getNaam());
    }

    private Rekening getRekening (int rekeningNr) {

        Rekening rekening = null;

        for (Rekening i : rekeningen){
            System.out.println(i.getNaam() + " heeft " + i.getSaldo() + " pingels");
            if (rekeningNr == i.getRekeningNr()){
                rekening = i;
            }
        }

        return rekening;
    }

}
