package opdr2;
import java.util.*;

public class Thesaurus {

    public static void main(String[] args) {
        Thesaurus woordenlijst = new Thesaurus();
        SynoniemenFrame fr = new SynoniemenFrame(woordenlijst);
        fr.setVisible(true);
    }

    private SortedSet<String> woordenlijst = null;
    private Map<String, String[]> synoniemenlijst = null;

//    TODO: Pass in custom comparator
    public Thesaurus() {
        this.woordenlijst = new TreeSet<>();
        this.synoniemenlijst = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
    }

    public void voegToe(String woord, String[] synoniemen) {
        woordenlijst.add(woord);
        synoniemenlijst.put(woord,synoniemen);
    }

    public String[] getWoordenlijst(){
        return woordenlijst.toArray(new String[0]);
    }

    public String[] getSynoniemenLijst(String woord){
        new TreeSet<>(Arrays.asList(synoniemenlijst.get(woord)));
        return synoniemenlijst.get(woord);
    }
}
