package theater;

/**
 * Representeert klant.
 * @author Open Universiteit
 */
public class Klant {
  private final int klantnummer;
  private final String naam;
  private final String telefoon;
  
  /**
   * Creeert klant.
   * @param klantnummer klantnummer
   * @param naam naam
   * @param telefoon telefoonnummer
   */
  public Klant(int klantnummer, String naam, String telefoon) {
    this.klantnummer = klantnummer;
    this.naam = naam;
    this.telefoon = telefoon;
  }

  /**
   * Geeft klantnummer.
   * @return klantnummer
   */
  public int getKlantnummer() {
    return klantnummer;
  }

  /**
   * Geeft klantnaam.
   * @return naam
   */
  public String getNaam() {
    return naam;
  }

  /**
   * Geeft telefoonnummer.
   * @return telefoonnummer.
   */
  public String getTelefoon() {
    return telefoon;
  }

  /**
   * Geeft stringrepresentatie van klant.
   * @return stringrepresentatie.
   */
  public String toString() {
    return klantnummer + ", " + naam + ", " + telefoon;
  }

}
