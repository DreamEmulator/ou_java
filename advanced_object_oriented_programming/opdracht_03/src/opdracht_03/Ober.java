package opdracht_03;

public class Ober {

    private static int LOOPTIJD = 500;
    private static int WACHTIJD = 1000;
    private String naam;
    private Uitgiftebalie uitgiftebalie;

    public Ober(String naam, Uitgiftebalie uitgiftebalie) {
        this.naam = naam;
        this.uitgiftebalie = uitgiftebalie;
    }

    void serveer(Maaltijd maaltijd){

    }
}
