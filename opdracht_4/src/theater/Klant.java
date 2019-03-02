package theater;// Opdracht A:
// Implementeer de klasse theater.Klant.
// Geef deze klasse een constructor waarmee alle attributen via parameters een waarde krijgen.
// Geef de klasse verder alleen get-methoden voor de attributen, en een methode toString die de volledige klantinformatie als één string teruggeeft

public class Klant {

    private String naam;
    private int klantnummer;
    private int telefoon;

    public Klant(String naam, int klantnummer, int telefoon) {
        this.naam = naam;
        this.klantnummer = klantnummer;
        this.telefoon = telefoon;
    }

    public String getNaam() {
        return naam;
    }

    public int getTelefoon() {
        return telefoon;
    }

    public int getKlantnummer(){
        return klantnummer;
    }

    public String klantToString(){
        return naam + klantnummer + telefoon;
    }
}
