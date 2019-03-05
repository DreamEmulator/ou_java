// OPDRACHT A:

// Implementeer de klasse theater.Klant.
// Geef deze klasse een constructor waarmee alle attributen via parameters een waarde krijgen.
// Geef de klasse verder alleen get-methoden voor de attributen, en een methode toString die de volledige klantinformatie als één string teruggeeft

//-------------------------------------------------------------------------------------------------

// CLASS = DONE
// TESTS =
// DOCS = DONE

package theater;

public class Klant {

    private String naam;
    private int klantnummer;
    private int telefoon;

    /**
     * Constructor voor Klant klasse.
     * @param klantnummer iedere klant moet een klantnummer hebben, deze tellen op vanaf 1.
     * @param naam iedere klant heeft een naam, hierbij wordt voor en achternaam samengevoegd.
     * @param telefoon iedere klantheeft een telefoonnummer
     **/
    public Klant(String naam, int klantnummer, int telefoon) {
        this.naam = naam;
        this.klantnummer = klantnummer;
        this.telefoon = telefoon;
    }

    /**
     * Getter.
     * @return Returns naam van de klant
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Getter.
     * @return Returns telefoonnummer van de klant
     */
    public int getTelefoon() {
        return telefoon;
    }

    /**
     * Getter.
     * @return Returns klantnummer van de klant
     */
    public int getKlantnummer(){
        return klantnummer;
    }

    /**
     * Getter.
     * @return Returns concatenated string van alle klant attributen
     */
    public String klantToString() {
        return "Klant{" +
                "naam='" + naam + '\'' +
                ", klantnummer=" + klantnummer +
                ", telefoon=" + telefoon +
                '}';
    }
}
