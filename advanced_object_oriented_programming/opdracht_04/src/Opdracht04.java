import theaterdata.Connectiebeheer;
import theaterdata.TheaterException;
import theatergui.TheaterFrame;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static theaterdata.Connectiebeheer.closeDB;

public class Opdracht04 {

    public static void main(String[] args) {
        TheaterFrame gui = null;
        try {
            Connectiebeheer.openDB();
             gui = new TheaterFrame();
        } catch (TheaterException e) {
            e.printStackTrace();
        }

        gui.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                try {
                    closeDB();
                } catch (TheaterException e) {
                    e.printStackTrace();
                }
            }
        });
        gui.setVisible(true);
    }
}
