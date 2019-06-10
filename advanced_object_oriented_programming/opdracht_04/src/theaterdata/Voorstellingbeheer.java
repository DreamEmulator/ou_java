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
        ResultSet resVoorstelling = null;
        ResultSet resBezetting = null;
        ResultSet resKlant = null;
        String sqlVoorstelling = "SELECT * FROM theater.voorstelling WHERE datum = ?";
        String sqlBezetting = "SELECT * FROM theater.bezetting WHERE voorstelling = ?";
        String sqlKlant = "SELECT * FROM theater.klant WHERE klantnummer = ?";
        java.sql.Date sqlDatum = gToD(datum);

        Voorstelling voorstelling = null;
        String voorstellingNaam = null;

        int stoel;
        int rij;
        int klant;
        String klantNaam = null;
        String klantTel = null;

        try {

            prep = Connectiebeheer.con.prepareStatement(sqlVoorstelling);
            prep.setString(1, sqlDatum.toString());
            resVoorstelling = prep.executeQuery();

            if(resVoorstelling.next()) {
                voorstellingNaam = resVoorstelling.getString("naam");
                voorstelling = new Voorstelling(voorstellingNaam, datum);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            prep = Connectiebeheer.con.prepareStatement(sqlBezetting);
            prep.setString(1, sqlDatum.toString());
            resBezetting = prep.executeQuery();

            while (resBezetting.next()) {

                stoel = resBezetting.getInt("stoelnummer");
                rij = resBezetting.getInt("rijnummer");
                klant = resBezetting.getInt("klant");

                prep = Connectiebeheer.con.prepareStatement(sqlKlant);
                prep.setInt(1, klant);
                resKlant = prep.executeQuery();

                resKlant.next();
                klantNaam = resKlant.getString("naam");
                klantTel = resKlant.getString("telefoon");

                voorstelling.reserveer(rij,stoel);
                voorstelling.plaatsKlant(rij,stoel, new Klant( klant,klantNaam, klantTel));
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
