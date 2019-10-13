package opdr2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Woordenlijst {

    public static void main(String[] args) {
        Woordenlijst woordenlijst = new Woordenlijst();
        SynoniemenFrame fr = new SynoniemenFrame(woordenlijst);
        fr.setVisible(true);
    }

    private SortedSet<String> woorden = null;

//    TODO: Pass in custom comparator
    public Woordenlijst() {
        this.woorden = new TreeSet<>();
    }

    public void voegToe(String woord) {
        this.woorden.add(woord);
    }

    public String[] getWoordenlijst(){
        return this.woorden.toArray(new String[0]);
    }
}
