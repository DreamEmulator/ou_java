package theater;

import java.util.Date;

public class Voorstelling {

    private String naam;
    private Date datum;

    public Voorstelling(String naam, Date datum) {
        this.naam = naam;
        this.datum = datum;
    }

    public String getNaam() {
        return naam;
    }

    public Date getDatum() {
        return datum;
    }
}
