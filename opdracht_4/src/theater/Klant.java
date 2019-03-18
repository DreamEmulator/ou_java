package theater;

public class Klant {

    private String naam;
    private int klantnummer;
    private String telefoon;

    /**
     * Constructor voor Klant klasse.
     * @param klantnummer iedere klant moet een klantnummer hebben, deze tellen op vanaf 1.
     * @param naam iedere klant heeft een naam, hierbij wordt voor en achternaam samengevoegd.
     * @param telefoon iedere klantheeft een telefoonnummer
     **/
    protected Klant(String naam, int klantnummer, String telefoon) {
        this.naam = naam;
        this.klantnummer = klantnummer;
        this.telefoon = telefoon;
    }

    protected String getNaam() {
        return naam;
    }

    protected String getTelefoon() {
        return telefoon;
    }

    protected int getKlantnummer(){
        return klantnummer;
    }

    protected String klantToString() {
        return "Klant{" +
                "naam='" + naam + '\'' +
                ", klantnummer=" + klantnummer +
                ", telefoon=" + telefoon +
                '}';
    }
}
