package opdracht_03;

import java.util.Timer;
import java.util.TimerTask;

public class Restaurant {

    public static int AANTALTAFELS = 10;
    public static int SIMULATIETIJD = 120000;

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Uitgiftebalie uitgiftebalie = new Uitgiftebalie();
        Kok kok01 = new Kok( "Bart", uitgiftebalie);
        Kok kok02 = new Kok( "Jan", uitgiftebalie);
        Kok kok03 = new Kok( "Truus", uitgiftebalie);
        Ober ober01 = new Ober("Machteld", uitgiftebalie);
        Ober ober02 = new Ober("Arjen", uitgiftebalie);

        Timer timer = new Timer("One Time Timer Test");
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("De simulatietijd is verstreken");
            }
        };

        timer.schedule(task, SIMULATIETIJD);
    }

}
