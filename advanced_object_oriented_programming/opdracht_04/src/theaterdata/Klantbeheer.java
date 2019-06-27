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

    private static PreparedStatement prepHoogsteKlantnummer;
    private static PreparedStatement prepZoekKlant;
    private static PreparedStatement prepNieuweKlant;

    public static void init() throws TheaterException {
        try {
            String sqlHoogsteKlant = "SELECT MAX(klantnummer) FROM theater.klant";
            String sqlKlant = "SELECT klantnummer,naam,telefoon FROM klant";
            prepHoogsteKlantnummer = Connectiebeheer.getCon().prepareStatement(sqlHoogsteKlant);
            prepZoekKlant = Connectiebeheer.getCon().prepareStatement(sqlKlant);

            String sqlNewKlant = "INSERT INTO klant (klantnummer, naam, telefoon) VALUES (?,?,?)";
            prepNieuweKlant = Connectiebeheer.getCon().prepareStatement(sqlNewKlant);
        } catch (SQLException e) {
            throw new TheaterException("Preparing klantbeheer statement mislukt");
        }
    }
    private static ResultSet res;

    /**
     * Genereert het volgende beschikbare klantnummer.
     *
     * @return nieuw klantnummer
     */
    public static int getVolgendKlantNummer() throws TheaterException {
        int hoogsteKlantnummer = 0;

        try {
            res = prepHoogsteKlantnummer.executeQuery();
            res.next();
            hoogsteKlantnummer = res.getInt(1);
            hoogsteKlantnummer++;
        } catch (SQLException e) {
            throw new TheaterException("Hoogste klantnummer ophalen mislukt");
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
    public static Klant geefKlant(String naam, String telefoon) throws TheaterException {
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
    private static Klant zoekKlant(String naam, String telefoon) throws TheaterException {
        ArrayList<Klant> klanten = new ArrayList<Klant>();

        try {
            res = prepZoekKlant.executeQuery();
            while (res.next()) {
                klanten.add(new Klant(res.getInt("klantnummer"), res.getString("naam"), res.getString("telefoon")));
            }
        } catch (SQLException e) {
            throw new TheaterException("Klant zoeken niet gelukt");
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
    private static Klant nieuweKlant(String naam, String telefoon) throws TheaterException {
        int knr = getVolgendKlantNummer();
        Klant k = new Klant(knr, naam, telefoon);
        try {
            prepNieuweKlant.setInt(1,knr);
            prepNieuweKlant.setString(2,naam);
            prepNieuweKlant.setString(3,telefoon);
            int row = prepNieuweKlant.executeUpdate();
            System.out.println("Rows affected: " + row);
        } catch (SQLException e) {
            throw new TheaterException("Nieuwe klant is niet aangemaakt");
        }
        return k;
    }

}
