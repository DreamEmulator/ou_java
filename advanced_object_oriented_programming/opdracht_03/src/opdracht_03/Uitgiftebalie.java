package opdracht_03;

import java.util.ArrayList;
import java.util.List;

/**
 * De klasse uitgiftebalie vormt de connectie tussen de threads van koks en obers en vormt zodoemde eem risico. Daarom zijn de methodes syncrhonized gemaakt en is de ArrayList wachtrij omgezet in een Vector.
 */
class Uitgiftebalie {
    private final List<Maaltijd> wachtrij = new ArrayList<>();

    /**
     * Een synchronized methode waarbij de verschillende threads van koks 1 voor 1 een maaltijd van de balie kunnnen plaatsen
     */
    synchronized void plaatsMaaltijd(Maaltijd maaltijd) {
        System.out.println("Maaltijd geplaatst: " + maaltijd.toString());
        wachtrij.add(maaltijd);
    }

    /**
     * Een synchronized methode waarbij de verschillende threads van obers 1 voor 1 een maaltijd van de balie kunnnen pakkenem
     * @return een maaltijd
     */
     synchronized Maaltijd pakMaaltijd() {
        Maaltijd m = null;
        if (wachtrij.size() > 0) {
            m = wachtrij.remove(0);
        }
        return m;
    }
}
