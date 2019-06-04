import theatergui.TheaterFrame;

import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static theaterdata.Connectiebeheer.openDB;

public class Opdracht04 {

    public static void main(String[] args) {
        TheaterFrame gui = new TheaterFrame();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setVisible(true);
        openDB();
    }
}
