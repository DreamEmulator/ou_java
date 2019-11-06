package opdr2;

import java.util.*;

public class Thesaurus {

    public static void main(String[] args) {
        Thesaurus woordenlijst = new Thesaurus();
        SynoniemenFrame fr = new SynoniemenFrame(woordenlijst);
        fr.setVisible(true);
    }

    /**
     * De thesaurus wordt geïnstantieerd met met een TreeSet voor de woordenlijst, zodat deze uniek en alfabetisch zijn
     * en een TreeMap met keys van het type String en Values van het type TreeSet. Deze tweede TreeSet wordt custom comparator meegegeven.
     */
    private TreeSet<String> woordenlijst = new TreeSet<>();
    private TreeMap<String, TreeSet<String>> synoniemenlijst = new TreeMap<>();

    /**
     * De functie maakt alle woorden en synoniemen lowercase zodat ze niet meerdere maleb voor kunnen komen.
     * De synoniemen set wordt aangemaakt aan de hand van de comparators die samen een nieuwe comparator vormen
     *
     * @param woord
     * @param synoniemen
     * @throws ThesaurusException
     */
    void voegToe(String woord, String[] synoniemen) throws ThesaurusException {
        woord = woord.toLowerCase().trim();
        checkWoordUniek(woord);
        woordenlijst.add(woord);

        TreeSet<String> synoniemenSet = new TreeSet<>(new compareLength().thenComparing(new compareAlphabet()));
        for (int s = 0; s < synoniemen.length; s++) {
            synoniemen[s] = synoniemen[s].toLowerCase().trim();
        }
        synoniemenSet.addAll(Arrays.asList(synoniemen));
        synoniemenlijst.put(woord, synoniemenSet);
    }

    /**
     * Deze functie waarschuwd de gebruiker dat het woord niet toegevoegd zou worden omdat deze al bestaat in de lijst
     *
     * @param woord
     * @throws ThesaurusException
     */
    private void checkWoordUniek(String woord) throws ThesaurusException {
        if (woordenlijst.contains(woord)) {
            throw new ThesaurusException("Let op: Woord bestaat al in de woordenlijst");
        }
    }

    /**
     * Deze comparator vergelijkt de alfabetische volgorde
     */
    static class compareAlphabet implements Comparator<String> {
        public int compare(String str1, String str2) {
            return str1.compareTo(str2);
        }
    }

    /**
     * Deze comparator vergelijkt de lengte
     */
    static class compareLength implements Comparator<String> {
        public int compare(String str1, String str2) {
            return str1.length() - str2.length();
        }
    }

    String[] getWoordenlijst() {
        return woordenlijst.toArray(new String[0]);
    }

    Set<String> getSynoniemenLijst(String woord) {
        return synoniemenlijst.get(woord);
    }
}
