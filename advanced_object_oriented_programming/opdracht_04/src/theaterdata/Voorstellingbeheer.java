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
        Connectiebeheer.openDB();
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
            prep = Connectiebeheer.con.prepareStatement(sql);
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
        PreparedStatement prep = null;
        ResultSet res = null;
        Voorstelling voorstelling = null;
        String sqlVoorstelling = "SELECT * FROM theater.voorstelling WHERE datum = ?";
        String sqlBezetting = "SELECT * FROM theater.bezetting WHERE voorstelling = ?";
        java.sql.Date sqlDatum = gToD(datum);

        try {

            prep = Connectiebeheer.con.prepareStatement(sqlVoorstelling);
            prep.setString(1, sqlDatum.toString());
            res = prep.executeQuery();

            if(res.next()) {
                voorstelling = new Voorstelling(res.getString("naam"), datum);
            } else {
                //TODO: throw theater exception
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            prep = Connectiebeheer.con.prepareStatement(sqlBezetting);
            prep.setString(1, sqlDatum.toString());
            res = prep.executeQuery();

            while (res.next()) {

                int stoel = res.getInt("stoelnummer");
                int rij = res.getInt("rijnummer");
                int klant = res.getInt("klant");

                voorstelling.reserveer(rij,stoel);
                voorstelling.plaatsKlant(res.getInt("rijnummer"),res.getInt("stoelnummer"), new Klant( klant,"Temp", "030123456"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voorstelling;
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
