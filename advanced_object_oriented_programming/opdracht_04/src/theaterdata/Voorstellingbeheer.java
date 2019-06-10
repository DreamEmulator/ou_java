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


    public static void main(String[] args) throws TheaterException {
        init();
        System.out.println("Alle data worden uit de database ingelezen");
        ArrayList data = geefVoorstellingsData();
        for (Object datum : data){
            if (datum instanceof GregorianCalendar){
                System.out.println(((GregorianCalendar) datum).getTime());
            } else {
                throw new TheaterException("SQL to Gcal conversion failed");
            }
        }
        System.out.println("Alle data zijn succesvol ingelezen");
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
                java.sql.Date sqlDatum = res.getDate("datum");
                GregorianCalendar datum = new GregorianCalendar();
                datum.setTimeInMillis(sqlDatum.getTime());
                data.add(datum);

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

        PreparedStatement prepStmt = null;
        String naam = "";
        ResultSet res = null;

        return new Voorstelling(naam, datum);
    }


}
