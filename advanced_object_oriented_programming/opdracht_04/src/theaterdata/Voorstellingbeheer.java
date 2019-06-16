package theaterdata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import theater.Klant;
import theater.Theater;
import theater.Voorstelling;

// TODO: check dat SQL exceptions als zodanig gegooid kunnnen worden, of dat ze Theater exceptions moeten worden

/**
 * Klasse die met voorstellingen beheert. Op elke datum is er maar ��n
 * voorstelling. Deze klasse moet gewijzigd worden zodat ArrayList vervangen
 * wordt door gebruik database.
 */
public class Voorstellingbeheer {

    private static PreparedStatement prep = null;
    private static ResultSet res = null;

    public static void main(String[] args) {
        init();
        System.out.println("Alle data worden uit de database ingelezen");
        ArrayList<GregorianCalendar> data = geefVoorstellingsData();
        for (GregorianCalendar datum : data) {
            System.out.println(datum.getTime());
        }
        System.out.println("Alle data zijn succesvol ingelezen");

        System.out.println("Geef voorstelling: ");
        Voorstelling v = geefVoorstelling(data.get(0));

        System.out.println(v.getNaam());
        System.out.println(v.getPlaats(2,4));

    }

    /**
     * Initialiseert Voorstellingsbeheer.
     */
    public static void init() {
    }


    /**
     * Levert alle data op waarop voorstellingen zijn (voor zover die data in de
     * toekomst liggen).
     *
     * @return lijst met data van voorstellingen
     */
    public static ArrayList<GregorianCalendar> geefVoorstellingsData() {
        String sql = "SELECT *  FROM voorstelling";
        PreparedStatement prep = null;
        ResultSet res = null;
        ArrayList<GregorianCalendar> data = new ArrayList<GregorianCalendar>();

        try {
            prep = Connectiebeheer.getCon().prepareStatement(sql);
            res = prep.executeQuery();
            while (res.next()){
                data.add(dToG(res.getDate("datum")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Zoekt een voorstelling op de gegeven datum.
     *
     * @param datum
     * @return een voorstelling op de gegeven datum of null wanneer die
     * voorstelling er niet is.
     */
    public static Voorstelling geefVoorstelling(GregorianCalendar datum) {
        String sqlVoorstelling = "SELECT * FROM theater.voorstelling WHERE datum = ?";
        String sqlBezetting= "SELECT * FROM bezetting INNER JOIN klant on bezetting.klant = klant.klantnummer WHERE voorstelling = ?";

        java.sql.Date sqlDatum = gToD(datum);

        Voorstelling voorstelling = null;
        String voorstellingNaam;

        int stoel;
        int rij;
        int klant;
        String klantNaam;
        String klantTel;


// Get voorstelling
        try {
            prep = Connectiebeheer.getCon().prepareStatement(sqlVoorstelling);
            prep.setString(1, sqlDatum.toString());
            res = prep.executeQuery();

            if(res.next()) {
                voorstellingNaam = res.getString("naam");
                voorstelling = new Voorstelling(voorstellingNaam, datum);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

// Get bezetting
        try {
            prep = Connectiebeheer.getCon().prepareStatement(sqlBezetting);
            prep.setString(1, sqlDatum.toString());
            res= prep.executeQuery();

            while (res.next()) {

                stoel = res.getInt("stoelnummer");
                rij = res.getInt("rijnummer");
                klant = res.getInt("klant");
                klantNaam = res.getString("naam");
                klantTel = res.getString("telefoon");

                voorstelling.reserveer(rij,stoel);
                voorstelling.plaatsKlant(rij,stoel, new Klant( klant,klantNaam, klantTel));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voorstelling;
    }

    /**
     * Plaatst nieuwe bezetting in de database
     * @param datum van de voorstelling, het rijnummer en stoelnummer en het klantnummer
     */

    public static void updateBezetting(GregorianCalendar datum, int rij, int stoel, int kNr){
        String sqlNewBezet = "INSERT INTO bezetting (voorstelling, rijnummer, stoelnummer, klant) VALUES (?,?,?,?)";
        try {
            prep = Connectiebeheer.getCon().prepareStatement(sqlNewBezet);
            prep.setString(1, datum.toString());
            prep.setInt(2, rij);
            prep.setInt(3, stoel);
            prep.setInt(4, kNr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Helper method to convert gregorian to sql
     */
    public static java.sql.Date gToD(GregorianCalendar g) {
        return new java.sql.Date(g.getTimeInMillis());
    }

    /**
     * Helper method to convert gregorian to sql
     */
    public static GregorianCalendar dToG(java.sql.Date d) {
        GregorianCalendar datum = new GregorianCalendar();
        datum.setTimeInMillis(d.getTime());
        return datum;
    }

}
