package theaterdata;

/**
 * Deze klasse bevat de constanten die gebruikt worden om verbinding
 * te maken met de database.
 */
class DBConst {
  static final String DRIVERNAAM = "com.mysql.cj.jdbc.Driver";
  static final String URL = "jdbc:mysql://localhost/theater?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
  static final String GEBRUIKERSNAAM = "cppjava";
  static final String WACHTWOORD = "theater";
}
