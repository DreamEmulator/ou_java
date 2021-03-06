package opdr2;

import java.util.*;

public class Thesaurus {

    public static void main(String[] args) {
        Thesaurus woordenlijst = new Thesaurus();
        SynoniemenFrame fr = new SynoniemenFrame(woordenlijst);
        fr.setVisible(true);
    }

    /**
     * De thesaurus wordt geïnstantieerd met met een TreeMap met daarin een TreeSet. De TreeMap sorteert automatich de keys (de woorden) op Alfabet
     * De Synoniemen komen in de TreeSet en krijgen een custom comparator die twee comparators combineert: eerst lengte, dan alfabeet.
     */
    private TreeMap<String, TreeSet<String>> synoniemenlijst = new TreeMap<>();

    /**
     * De functie maakt alle woorden en synoniemen lowercase zodat ze niet meerdere malen voor kunnen komen ongeacht case.
     * Voor het woord is een duplicatie check als waarschuwing, maar voor de synoniemenlijst niet. Deze is immers een set en zal automatisch filteren.
     * De synoniemen set wordt aangemaakt aan de hand van de comparators die samen een nieuwe comparator vormen
     *
     * @param woord het woord die mede de key vormt voor de synoniemenset
     * @param synoniemen een array van synoniemen
     * @throws ThesaurusException
     */
    void voegToe(String woord, String[] synoniemen) throws ThesaurusException {
        woord = woord.toLowerCase().trim();
        checkWoordUniek(woord);
        TreeSet<String> synoniemenSet = new TreeSet<>(new compareLength().thenComparing(new compareAlphabet()));
        for (int s = 0; s < synoniemen.length; s++) {
            synoniemen[s] = synoniemen[s].toLowerCase().trim();
        }
        synoniemenSet.addAll(Arrays.asList(synoniemen));
        synoniemenlijst.put(woord, synoniemenSet);
    }

    /**
     * Deze functie waarschuwd de gebruiker dat het woord niet toegevoegd zou worden omdat deze al bestaat in de lijst
     * @param woord het te checken woord in lowercase
     * @throws ThesaurusException
     */
    private void checkWoordUniek(String woord) throws ThesaurusException {
        if (synoniemenlijst.containsKey(woord)) {
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
        return synoniemenlijst.keySet().toArray(new String[0]);
    }

    String[] getSynoniemenLijst(String woord) {
        return synoniemenlijst.get(woord).toArray(new String[0]);
    }
}
