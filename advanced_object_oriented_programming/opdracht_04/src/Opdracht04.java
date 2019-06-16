import theaterdata.Connectiebeheer;
import theatergui.TheaterFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static theaterdata.Connectiebeheer.closeDB;

public class Opdracht04 {

    public static void main(String[] args) {
        Connectiebeheer.openDB();
        TheaterFrame gui = new TheaterFrame();
        gui.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                closeDB();
            }
        });
        gui.setVisible(true);
    }
}
