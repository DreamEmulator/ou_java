package opdracht_03;

import java.util.ArrayList;

public class Uitgiftebalie {
    private ArrayList<Maaltijd> wachtrij = new ArrayList<Maaltijd>();

    void plaatsMaaltijd(Maaltijd maaltijd){
        wachtrij.add(maaltijd);
    }

    Maaltijd pakMaaltijd(){
        Maaltijd m = wachtrij.get(0);
        wachtrij.remove(0);
        return m;
    }
}
