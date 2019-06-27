package theaterdata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import theater.Klant;
import theater.Theater;
import theater.Voorstelling;

// TODO: Figure out how to go from the theaterGUI layer through the theater through the theaterdata with al the info to update the Bezetting in the DB

// TODO: check dat SQL exceptions als zodanig gegooid kunnnen worden, of dat ze Theater exceptions moeten worden

/**
 * Klasse die met voorstellingen beheert. Op elke datum is er maar ��n
 * voorstelling. Deze klasse moet gewijzigd worden zodat ArrayList vervangen
 * wordt door gebruik database.
 */
public class Voorstellingbeheer {

    private static PreparedStatement prepGetVoorstelling = null;
    private static PreparedStatement prepVoorstellingen = null;
    private static PreparedStatement prepBezetting = null;
    private static PreparedStatement prepUpdateBezetting = null;
    private static ResultSet res = null;

    /**
     * Initialiseert Voorstellingsbeheer.
     */
    public static void init() throws TheaterException {

        String sqlNewBezet = "INSERT INTO bezetting (voorstelling, rijnummer, stoelnummer, klant) VALUES (?,?,?,?)";
        String sqlVoorstellingen = "SELECT *  FROM voorstelling";
        String sqlBezetting = "SELECT * FROM bezetting INNER JOIN klant on bezetting.klant = klant.klantnummer WHERE voorstelling = ?";
        String sqlVoorstelling = "SELECT * FROM theater.voorstelling WHERE datum = ?";

        try {
            prepUpdateBezetting = Connectiebeheer.getCon().prepareStatement(sqlNewBezet);
            prepVoorstellingen = Connectiebeheer.getCon().prepareStatement(sqlVoorstellingen);
            prepBezetting = Connectiebeheer.getCon().prepareStatement(sqlBezetting);
            prepGetVoorstelling = Connectiebeheer.getCon().prepareStatement(sqlVoorstelling);
        } catch (SQLException e) {
            throw new TheaterException("Voorstellingbeheer kon niet starten");
        }
    }


    /**
     * Levert alle data op waarop voorstellingen zijn (voor zover die data in de
     * toekomst liggen).
     *
     * @return lijst met data van voorstellingen
     */
    public static ArrayList<GregorianCalendar> geefVoorstellingsData() throws TheaterException {
        ResultSet res = null;
        ArrayList<GregorianCalendar> data = new ArrayList<GregorianCalendar>();

        try {
            res = prepVoorstellingen.executeQuery();
            while (res.next()) {
                data.add(dToG(res.getDate("datum")));
            }
        } catch (SQLException e) {
            throw new TheaterException("Ophalen van Voorstellingen is mislukt");
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
    public static Voorstelling geefVoorstelling(GregorianCalendar datum) throws TheaterException {

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
            prepGetVoorstelling.setString(1, sqlDatum.toString());
            res = prepGetVoorstelling.executeQuery();

            if (res.next()) {
                voorstellingNaam = res.getString("naam");
                voorstelling = new Voorstelling(voorstellingNaam, datum);
            }
        } catch (SQLException e) {
            throw new TheaterException("Voorstelling kon niet opgehaald worden");
        }

// Get bezetting
        try {

            prepBezetting.setString(1, sqlDatum.toString());
            res = prepBezetting.executeQuery();

            while (res.next()) {

                stoel = res.getInt("stoelnummer");
                rij = res.getInt("rijnummer");
                klant = res.getInt("klant");
                klantNaam = res.getString("naam");
                klantTel = res.getString("telefoon");

                voorstelling.reserveer(rij, stoel);
                voorstelling.plaatsKlant(rij, stoel, new Klant(klant, klantNaam, klantTel));
            }

        } catch (SQLException e) {
            throw new TheaterException("Voorstelling kon niet opgehaald worden");
        }

        return voorstelling;
    }

    /**
     * Plaatst nieuwe bezetting in de database
     *
     * @param datum van de voorstelling, het rijnummer en stoelnummer en het klantnummer
     */

    public static void updateBezetting(GregorianCalendar datum, int rij, int stoel, int kNr) throws TheaterException {
        try {
            prepUpdateBezetting.setString(1, gToD(datum).toString());
            prepUpdateBezetting.setInt(2, rij);
            prepUpdateBezetting.setInt(3, stoel);
            prepUpdateBezetting.setInt(4, kNr);
            prepUpdateBezetting.executeUpdate();
        } catch (SQLException e) {
            throw new TheaterException("Het updaten van de database is mislukt");
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
