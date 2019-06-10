package theaterdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.GregorianCalendar;

/**
 * Beheert de connectie met de database.
 * Bevat methoden voor openen en sluiten van connectie met database,
 * en voor opvragen van de connectie.
 *
 * @author Open Universiteit
 */
public class Connectiebeheer {

    //TODO: Check met Jeffrey of het goed is om de connectie hier te bewaren
    static Connection con;

    public static void main(String[] args) {

        System.out.println("Database verbinding wordt geopend");
        openDB();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Database verbinding wordt gesloten");
        closeDB();
    }

    /**
     * Maakt een connectie met de database en initialiseert
     * Klantbeheer en VoostellingBeheer.
     *
     * @throws 'TheaterException' als de initialisatie mislukt.
     */


    public static void openDB() {

        try {
            Class.forName(DBConst.DRIVERNAAM);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            con = DriverManager.getConnection(DBConst.URL, DBConst.GEBRUIKERSNAAM, DBConst.WACHTWOORD);
            System.out.println("Opening Connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    /**
     * Sluit de connectie met de database
     */
    public static void closeDB() {
        try {
            con.close();
            System.out.println("Closing Connection");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Helper method to convert gregorian to sql
     */
    public static java.sql.Date gToD (GregorianCalendar g){
        return new java.sql.Date(g.getTimeInMillis());
    }

    /**
     * Helper method to convert gregorian to sql
     */
    public static GregorianCalendar dToG (java.sql.Date d){
        GregorianCalendar datum = new GregorianCalendar();
        datum.setTimeInMillis(d.getTime());
        return datum;
    }

}
