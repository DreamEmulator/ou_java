package theaterdata;

/**
 * Deze klasse bevat de constanten die gebruikt worden om verbinding
 * te maken met de database.
 */
public class DBConst {
  protected static final String DRIVERNAAM = "com.mysql.cj.jdbc.Driver";
  protected static final String URL = "jdbc:mysql://localhost:3306/theater?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  protected static final String GEBRUIKERSNAAM = "cppjava";
  protected static final String WACHTWOORD = "theater"; 
}
