import java.util.ArrayList;

import croho.Croho;
import croho.Instelling;
import croho.Instellingssoort;
import croho.Plaats;

public class CrohoSysteem {

    public static void main(String[] args) {
// TODO Voeg aan Croho instantie studenten toe
        System.out.println("Croho Systeem is aan!");
        Croho croho = new Croho();

        ArrayList<Instelling> instellingen = croho.getInstellingen();
        croho.init();

        croho.voegtoeInstelling("Rijksuniversiteit", Instellingssoort.WO, "Groningen", 7654);

//  OPDRACHT B
        System.out.println("\nOpdracht B:");
        for (int i = 0; i < instellingen.size(); i++) {
            String naam = instellingen.get(i).getNaam();
            Instellingssoort instellingssoort = instellingen.get(i).getSoort();
            String plaats = instellingen.get(i).getPlaats().getNaam();
            int aantalStudenten = instellingen.get(i).getAantalStudenten();

            System.out.println(naam + " (" + instellingssoort + ") " + "te" + " " + plaats + " " + aantalStudenten);
        }

// OPDRACHT C
        System.out.println("\nOpdracht C:");
        int woStudenten = 0;
        int hboStudenten = 0;

        for (int i = 0; i < instellingen.size(); i++) {
            Instelling instelling = instellingen.get(i);

            if (Instellingssoort.WO == instelling.getSoort()) {
                woStudenten = woStudenten + instelling.getAantalStudenten();
            }

            if (Instellingssoort.HBO == instelling.getSoort()) {
                hboStudenten = hboStudenten + instelling.getAantalStudenten();
            }

        }
        System.out.println("Totaal aantal WO-studenten is " + woStudenten);
        System.out.println("Totaal aantal HBO-studenten is " + hboStudenten);

//  OPDRACHT D
        System.out.println("\nOpdracht D:");

        ArrayList<String> geprintePlaatsen = new ArrayList<String>();

        for (int i = 0; i < instellingen.size(); i++) {

            String naam = instellingen.get(i).getNaam();
            Instellingssoort instellingssoort = instellingen.get(i).getSoort();
            String plaats = instellingen.get(i).getPlaats().getNaam();
            int aantalStudenten = instellingen.get(i).getAantalStudenten();

            for (int x = 0; x < instellingen.size(); x++) {

                String naamAndere = instellingen.get(x).getPlaats().getNaam();
                int aantalStudentenAndere = instellingen.get(x).getAantalStudenten();

                if (i != x && plaats.equals(naamAndere)) {
                    aantalStudenten = aantalStudenten + aantalStudentenAndere;
                }
            }

            if (geprintePlaatsen.contains(plaats) == false) {
                System.out.println("In " + plaats + " studeren " + aantalStudenten + " studenten");
                geprintePlaatsen.add(plaats);
            }
        }

    }

}