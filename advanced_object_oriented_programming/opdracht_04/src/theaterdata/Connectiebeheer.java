package theaterdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Beheert de connectie met de database.
 * Bevat methoden voor openen en sluiten van connectie met database,
 * en voor opvragen van de connectie.
 *
 * @author Open Universiteit
 */
public class Connectiebeheer {

    static Connection con;

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

}
