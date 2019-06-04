package theaterdata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import theater.Voorstelling;

/**
 * Klasse die met voorstellingen beheert. Op elke datum is er maar ��n
 * voorstelling. Deze klasse moet gewijzigd worden zodat ArrayList vervangen
 * wordt door gebruik database.
 */
public class Voorstellingbeheer {

    /**
     * Vult voorstellingbeheer met een aantal voorstellingen.
     */
    public static void init() {
        Connectiebeheer.openDB();
    }

    public static int ParseDateHelper(int date) {
        switch (date) {
            case 0:
                return Calendar.JANUARY;
            case 1:
                return Calendar.FEBRUARY;
            case 2:
                return Calendar.MARCH;
            case 3:
                return Calendar.APRIL;
            case 4:
                return Calendar.MAY;
            case 5:
                return Calendar.JUNE;
            case 6:
                return Calendar.JULY;
            case 7:
                return Calendar.AUGUST;
            case 8:
                return Calendar.SEPTEMBER;
            case 9:
                return Calendar.OCTOBER;
            case 10:
                return Calendar.NOVEMBER;
            default:
                return Calendar.DECEMBER;
        }
    }

    /**
     * Levert alle data op waarop voorstellingen zijn (voor zover die data in de
     * toekomst liggen).
     *
     * @return lijst met data van voorstellingen
     */
    public static ArrayList<GregorianCalendar> geefVoorstellingsData() {

        String sql = "SELECT datum FROM voorstelling";
        PreparedStatement prepStmt = null;
        ResultSet res = null;

        try {
            prepStmt = Connectiebeheer.con.prepareStatement(sql);
            res = prepStmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<GregorianCalendar> data = new ArrayList<GregorianCalendar>();
        while (true) {
            try {
                if (res.next()) {
                    String[] arrOfStr = res.getString("datum").split("-");
                    int Y = Integer.parseInt(arrOfStr[0]);
                    int M = ParseDateHelper(Integer.parseInt(arrOfStr[0]));
                    int D = Integer.parseInt(arrOfStr[2]);

                    data.add(new GregorianCalendar(Y, M, D));
                } else {
                    break;
                }
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

        int Y = datum.get(Calendar.YEAR);
        int M = datum.get(Calendar.MONTH);      // 0 - 11
        int D = datum.get(Calendar.DAY_OF_MONTH);

        String d = "" + Y + "-" + M + "-" + D;

        String sql = "SELECT * FROM voorstelling";

        System.out.println(sql);

        try {
            prepStmt = Connectiebeheer.con.prepareStatement(sql);
            res = prepStmt.executeQuery();
            System.out.println(res);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("naam!!!");
            naam = res.getString("datum");
            System.out.println(naam);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Voorstelling(naam, datum);
    }


}
