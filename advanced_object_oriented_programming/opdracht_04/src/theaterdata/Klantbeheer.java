package theaterdata;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import theater.Klant;

/**
 * Deze klasse die klanten beheert.
 * Deze klasse moet gewijzigd worden zodat ipv ArrayList database gebruikt wordt.
 */
public class Klantbeheer {

    private static PreparedStatement prep;
    private static ResultSet res;
    /**
     * Initialiseert de klanten. Hier hoeft nu nog niets te gebeuren.
     */
    public static void init() {

// TODO: REMOVE        DEBUG

        System.out.println("Hoogste klantnummer: " + getVolgendKlantNummer());
    }

    /**
     * Genereert het volgende beschikbare klantnummer.
     *
     * @return nieuw klantnummer
     */
    public static int getVolgendKlantNummer() {
        int hoogsteKlantnummer = 0;
        String sqlKlant = "SELECT MAX(klantnummer) FROM theater.klant";

        try {
            prep = Connectiebeheer.getCon().prepareStatement(sqlKlant);
            res = prep.executeQuery();
            res.next();
            hoogsteKlantnummer = res.getInt(1);
            hoogsteKlantnummer++;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoogsteKlantnummer;
    }

    /**
     * Geeft een klant met de gegeven naam en het gegeven telefoonnummer
     * Als de klant al in de lijst zat, wordt die teruggegeven; anders
     * wordt er een nieuwe klant gemaakt.
     *
     * @param naam     naam van de klant
     * @param telefoon telefoonnummer van de klant
     * @return een klant me de ingevoerde naam en telefoon.
     */
    public static Klant geefKlant(String naam, String telefoon) {
        Klant klant = zoekKlant(naam, telefoon);
        if (klant == null) {
            klant = nieuweKlant(naam, telefoon);
        }
        return klant;
    }

    /**
     * Zoekt klant met gegeven naam in de lijst met klanten.
     *
     * @param naam     naam van te zoeken klant
     * @param telefoon telefoonnummer van te zoeken klant
     * @return de klant of null wanneer klant niet is gevonden
     */
    private static Klant zoekKlant(String naam, String telefoon) {
        ArrayList<Klant> klanten = new ArrayList<Klant>();
        String sqlKlant = "SELECT klantnummer,naam,telefoon FROM klant";

        try {
            prep = Connectiebeheer.getCon().prepareStatement(sqlKlant);
            res = prep.executeQuery();

            while (res.next()) {
                klanten.add(new Klant(res.getInt("klantnummer"), res.getString("naam"), res.getString("telefoon")));
//                System.out.println( res.getString("naam") + " gevonden");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Klant k : klanten) {
            if (k.getNaam().equals(naam) && k.getTelefoon().equals(telefoon)) {
                return k;
            }
        }
        return null;
    }

    /**
     * Voegt een nieuwe klant toe aan theater.
     *
     * @param naam     naam van de nieuwe klant
     * @param telefoon telefoonnummer van de nieuwe klant
     */
    private static Klant nieuweKlant(String naam, String telefoon) {
        int knr = getVolgendKlantNummer();
        Klant k = new Klant(knr, naam, telefoon);

        String sqlNewKlant = "INSERT INTO klant (klantnummer, naam, telefoon) VALUES (?,?,?)";

        try {
            prep = Connectiebeheer.getCon().prepareStatement(sqlNewKlant);
            prep.setInt(1,knr);
            prep.setString(2,naam);
            prep.setString(3,telefoon);
            int row = prep.executeUpdate();
            System.out.println("Rows affected: " + row);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return k;
    }

}
