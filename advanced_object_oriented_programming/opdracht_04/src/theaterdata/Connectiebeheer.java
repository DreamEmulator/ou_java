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

    private static Connection con;

    /**
     * Maakt een connectie met de database en initialiseert
     * Klantbeheer en VoostellingBeheer.
     *
     * @throws 'TheaterException' als de initialisatie mislukt.
     */
    public static void openDB() throws TheaterException {

        try {
            Class.forName(DBConst.DRIVERNAAM);
            con = DriverManager.getConnection(DBConst.URL, DBConst.GEBRUIKERSNAAM, DBConst.WACHTWOORD);
            System.out.println("Opening Connection");
        } catch (ClassNotFoundException e) {
            throw new TheaterException("Driver niet gevonden");
        } catch (SQLException e) {
            throw new TheaterException("Verbinding maken mislukt");
        }


    }

    /**
     * Sluit de connectie met de database
     */
    public static void closeDB() throws TheaterException {
        try {
            con.close();
            System.out.println("Closing Connection");
        } catch (SQLException e) {
            throw new TheaterException("Verbinding verbreken mislukt");
        }
    }

    /**
     * Ontsluit de connectie
     * @return de connectie
     */
    public static Connection getCon(){
        return con;
    }
}
