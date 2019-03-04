// OPDRACHT B:

// Implementeer de klasse Theater.

// DONE - Geef deze klasse een constructor met één parameter, namelijk de naam van het theater.

// Ontwerp en implementeer methoden voor dit beheer van klanten :
//
// DONE - het maken van een nieuwe klant, het uitgeven van een nieuw klantnummer
//
// DONE - het opzoeken van een klant op basis van naam en telefoonnummer.
//
// NOTE: We laten het verwijderen van klanten buiten beschouwing

//-------------------------------------------------------------------------------------------------

// OPDRACHT E:

// Breid de klasse Theater uit. Geef het theater een voorstelling.

//De user interface zal in de uiteindelijke versie van dit programma een associatie met Theater bevatten.

// Geef de klasse Theater daarom een aantal methoden zodat alle beschreven handelingen (reserveren, plaatsen, resetten) door middel van aanroepen op Theater kunnen worden uitgevoerd.

//-------------------------------------------------------------------------------------------------

// CLASS =
// TESTS =
// DOCS =

package theater;

import java.util.ArrayList;

public class Theater {
    public final static int AANTALTRIJEN = 15;
    public final static int AANTALPERRIJ = 10;
    private int hoogsteklantnummer;
    private String naam;

    private ArrayList<Klant> klanten = new ArrayList<>();
    private ArrayList<Plaats> plaatsen = new ArrayList<>();

    public Theater(String naam){
        this.naam = naam;
        for (int r = 1; r <= AANTALTRIJEN; r++){
            for (int p = 1; p <= AANTALPERRIJ; p++){
                plaatsen.add(new Plaats(r,p));
            }
        }
    }

    public String getNaam(){
        return naam;
    }

    public void nieuweKlant (String naam, int telefoon){
        klanten.add(new Klant(naam, klanten.size() + 1, telefoon));
        hoogsteklantnummer = klanten.size();
    }

    public Klant getKlant (String naam, int telefoon){
        Klant klant = null;
        for (Klant k : klanten){
            if (telefoon == k.getTelefoon() && naam.equals(k.getNaam())){
                klant = k;
                break;
            }
        }
        return klant;
    }

    public int getHoogsteklantnummer(){
        return hoogsteklantnummer;
    }

    public void reserveer (int rij, int stoel){
        int plaats = ((rij -1) * AANTALPERRIJ + stoel)-1;
        if (plaatsen.get(plaats).getStatus() != Plaats.Status.GERESERVEERD) {
            plaatsen.get(plaats).setStatus(Plaats.Status.GERESERVEERD);
        } else {
            for (int p = plaats; p < (AANTALTRIJEN * AANTALPERRIJ); p++){
                if (plaatsen.get(p).getStatus() == Plaats.Status.VRIJ){
                    plaatsen.get((rij -1) * AANTALPERRIJ + stoel).setStatus(Plaats.Status.GERESERVEERD);
                    break;
                }
            }
            System.out.println("Helaas: Deze plaats is al gereserveerd, we hebben de eerste volgende vrije plaats gereserveerd");
        }
    }

    public void plaatsKlant(String naam, int telefoon){
        if (getStatusPlaatsenAantal(Plaats.Status.GERESERVEERD) != 0) {
            for (int p = 0; p < plaatsen.size(); p++) {
                if (Plaats.Status.GERESERVEERD == plaatsen.get(p).getStatus()) {
                    plaatsen.get(p).plaatsToekennen(getKlant(naam, telefoon).klantToString());
                }
            }
        } else {
            System.out.println("Er zijn momenteel geen plaatsen gereserveerd");
        }
    }

    public void resetAlleReserveringen(){
        for(Plaats p: plaatsen){
            p.setStatus(Plaats.Status.VRIJ);
        }
    }

    public int getStatusPlaatsenAantal(Plaats.Status status){
        int aantal = 0;
        for(Plaats p: plaatsen){
            if (status == p.getStatus()){
                aantal++;
            }
        }
        return aantal;
    }

    public void printTheater(){
        System.out.println();
        String print = "";
        for (int r = 0; r < AANTALTRIJEN; r++){
            print += "Rij " + (r+1) + ": ";
            for (int p = 0; p < AANTALPERRIJ; p++){
                switch (plaatsen.get(r * AANTALPERRIJ + p).getStatus()){
                    case VRIJ:
                        print += "0";
                        break;
                    case GERESERVEERD:
                        print += "-";
                        break;
                    case BEZET:
                        print += "*";
                        break;
                }
                if (p == AANTALPERRIJ -1){
                    System.out.println(print);
                    print = "";
                }
            }
        }
    }
}