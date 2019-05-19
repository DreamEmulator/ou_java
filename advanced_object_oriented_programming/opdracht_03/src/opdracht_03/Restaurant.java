package opdracht_03;

public class Restaurant {

    public static int AANTALTAFELS = 10;
    public static int SIMULATIETIJD = 120000;

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Uitgiftebalie uitgiftebalie = new Uitgiftebalie();
        Kok kok = new Kok( "bart", uitgiftebalie);
    }

}
