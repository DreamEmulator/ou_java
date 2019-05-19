package opdracht_03;

public class Kok {
    private static int BEREIDINGSTIJD = 4000;
    String naam;
    Uitgiftebalie uitgiftebalie;

    public Kok(String naam, Uitgiftebalie uitgiftebalie) {
        this.naam = naam;
        this.uitgiftebalie = uitgiftebalie;
    }

    void kook (){
        // BEREID MAALTIJD
    }

    int kiesTafel(){
        return (int)(Math.random() * Restaurant.AANTALTAFELS) + 1;
    }
}
