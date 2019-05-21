package opdracht_03;

/**
 * De kok in de simulatie probeert zoveel mogelijk op de Uitgiftebalie, maar moet steeds wachten tot de bereidingstijd van de maaltijd verstrkeen is.
 */
class Kok extends Thread {
    private static final int BEREIDINGSTIJD = 4000;
    private final String naam;
    private final Uitgiftebalie uitgiftebalie;
    private boolean stoppen = false;

    Kok(String naam, Uitgiftebalie uitgiftebalie) {
        System.out.println("Starten: " + naam);
        this.naam = naam;
        this.uitgiftebalie = uitgiftebalie;
    }

    public void run() {
        while (!stoppen) {
            kook();
        }
    }

    /**
     * De kok begint te koken, iedere maaltijd duurt een bepaalde tijd
     */
    private void kook() {

        System.out.println("Bereiden: " + naam);
        try {
            Thread.sleep(BEREIDINGSTIJD);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }

        System.out.println("Plaatsen: " + naam);
        uitgiftebalie.plaatsMaaltijd(new Maaltijd(kiesGerecht(), kiesTafel()));
    }

    /**
     * Stopt de kok met koken en hiermee is run klaar en stopt ook de thread
     */
    public void stopMetKoken() {
        System.out.println("Stoppen: " + naam);
        stoppen = true;
    }

    /**
     * Een willekeurige gerecht wordt uit een lijst van gerechten gekozen
     * @return Een gerecht in de vorm van een string
     */
    private String kiesGerecht() {
        return Restaurant.GERECHTEN[(int) (Math.random() * Restaurant.GERECHTEN.length)];
    }

    /**
     * Een random tafel in het restaurant wordt gekozen
     * @return een tafel als int
     */
    private int kiesTafel() {
        return (int) (Math.random() * Restaurant.AANTALTAFELS) + 1;
    }
}
