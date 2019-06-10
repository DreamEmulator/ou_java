package theaterdata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

import theater.Voorstelling;

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
        System.out.println(geefVoorstelling(data.get(0)).getNaam());
    }

    /**
     * Vult voorstellingbeheer met een aantal voorstellingen.
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
        String sql = "SELECT datum FROM voorstelling";
        PreparedStatement prep = null;
        ResultSet res = null;
        ArrayList<GregorianCalendar> data = new ArrayList<GregorianCalendar>();

// TODO: check dat SQL exceptions als zodanig gegooid kunnnen worden, of dat ze Theater exceptions moeten worden
        try {
            prep = Connectiebeheer.con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            res = prep.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (!res.next()) break;
                data.add(Connectiebeheer.dToG(res.getDate("datum")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
        String naam = "";
        ResultSet res = null;
        Voorstelling voorstelling = null;
        java.sql.Date sqlDatum = Connectiebeheer.gToD(datum);
        String sql = "SELECT * FROM theater.voorstelling WHERE datum = ?";
        try {
            prep = Connectiebeheer.con.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            prep.setDate(1, sqlDatum);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            res = prep.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
// TODO: Add TheaterException
            if (res.next()) {
                voorstelling = new Voorstelling(res.getString("naam"), Connectiebeheer.dToG(res.getDate("datum")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return voorstelling;
    }


}
