package opdr2;
import java.util.*;

public class Thesaurus {

    public static void main(String[] args) {
        Thesaurus woordenlijst = new Thesaurus();
        SynoniemenFrame fr = new SynoniemenFrame(woordenlijst);
        fr.setVisible(true);
    }

    private SortedSet<String> woorden = null;
    private Map<String, String[]> synoniemen = null;

//    TODO: Pass in custom comparator
    public Thesaurus() {
        this.woorden = new TreeSet<>();
        this.synoniemen = new TreeMap<>();
    }

    public void voegToe(String woord, String[] synoniemen) {
        this.woorden.add(woord);
        this.synoniemen.put(woord,synoniemen);
    }

    public String[] getWoordenlijst(){
        return this.woorden.toArray(new String[0]);
    }
}
