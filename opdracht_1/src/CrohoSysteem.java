import croho.Croho;
import croho.Instelling;
import croho.Instellingssoort;
import croho.Plaats;

import java.util.HashMap;

public class CrohoSysteem {
    public static void main(String[] args) {
        Croho croho = new Croho();
        croho.init();

// Opdracht A:
        croho.voegtoeInstelling("Rijksuniversiteit Groningen", Instellingssoort.WO, "Groningen", 7654);
        System.out.println("\n Output Opdracht A:\nRijksuniversiteit Groningen toegevoegd");

// Opdracht B:  Print instellingen
        System.out.println("\n Output Opdracht B:");

        int wo = 0;
        int hbo = 0;

        for (Instelling i : croho.getInstellingen()) {

            if (Instellingssoort.WO.equals(i.getSoort())) {
                wo += i.getAantalStudenten();
            } else if (Instellingssoort.HBO.equals(i.getSoort())) {
                hbo += i.getAantalStudenten();
            }

            System.out.println(i.getNaam() + "(" + i.getSoort() + ") te " + i.getPlaats().getNaam());

        }

// Opdracht C: Print studenten
        System.out.println("\n Output Opdracht C: \n Totaal aantal WO-studenten is " + wo + "\n Totaal aantal HBO-studenten is " + hbo);

// Opdracht D: Print locaties en aantal studenten

        System.out.println("\n Output Opdracht D:");

        HashMap<String, Integer> plaatsTotalen = new HashMap<String, Integer>();

        for (Plaats i : croho.getPlaatsen()) {
            plaatsTotalen.put(i.getNaam(), 0);
        }

        for (Instelling i : croho.getInstellingen()) {
            String plaatsnaam = i.getPlaats().getNaam();
            int huidigAantaal = plaatsTotalen.get(plaatsnaam);
            int nieuwAantal = i.getAantalStudenten();

            plaatsTotalen.put(plaatsnaam, (huidigAantaal + nieuwAantal));
        }

        for (String i: plaatsTotalen.keySet()) {
            System.out.println("In " + i + " studeren " + plaatsTotalen.get(i)  + " studenten");
        }
    }
}
