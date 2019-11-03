package opdr2;
import java.util.*;

public class Thesaurus {

    public static void main(String[] args) {
        Thesaurus woordenlijst = new Thesaurus();
        SynoniemenFrame fr = new SynoniemenFrame(woordenlijst);
        fr.setVisible(true);
    }

    private SortedSet<String> woordenlijst = null;
    private Map<String, Set<String>> synoniemenlijst = null;

    private Thesaurus() {
        this.woordenlijst = new TreeSet<>();
        this.synoniemenlijst = new TreeMap<>();
    }

    void voegToe(String woord, String[] synoniemen) throws ThesaurusException {
        checkWoordUniek(woord);
        woordenlijst.add(woord);
        Set<String> synoniemenSet = new TreeSet<>(new compareLength().thenComparing(new compareAlphabet()));
        synoniemenSet.addAll(Arrays.asList(synoniemen));
        synoniemenlijst.put(woord,synoniemenSet);
    }

    void checkWoordUniek(String woord) throws ThesaurusException {
        if (woordenlijst.contains(woord)){
            throw new ThesaurusException("Let op: Woord bestaat al in de woordenlijst");
        }
    }

    class compareAlphabet implements Comparator<String> {
        public int compare(String str1, String str2)
        {
            return str1.compareTo(str2);
        }
    }

    class compareLength implements Comparator<String> {
        public int compare(String str1, String str2)
        {
            return str1.length() - str2.length();
        }
    }

    String[] getWoordenlijst(){
        return woordenlijst.toArray(new String[0]);
    }

    Set<String> getSynoniemenLijst(String woord){
        return synoniemenlijst.get(woord);
    }
}
