package opdracht_03;

/**
 * De ober klasse is verantwoordelijk voor het uitserveren van de maaltijden die de koks op de balie z
 */
class Ober extends Thread {

    private static final int LOOPTIJD = 500;
    private static final int WACHTIJD = 1000;
    private final String naam;
    private final Uitgiftebalie uitgiftebalie;
    private boolean stoppen = false;

    public Ober(String naam, Uitgiftebalie uitgiftebalie) {
        this.naam = naam;
        this.uitgiftebalie = uitgiftebalie;
    }

    public void run() {
        while (!stoppen) {
            serveer();
        }
    }

    /**
     * Serveer probeert een maaltijd te pakken. Lukt dit dan wordt deze gedurende de totalee looptijd weggebracht. Zo niet wacht de ober en probeert opnieuw te pakken.
     */
    private void serveer(){
        Maaltijd m = uitgiftebalie.pakMaaltijd();
        if (m == null){
            try {
                System.out.println("Nog efkens wachten");
                Thread.sleep(WACHTIJD);
            } catch (InterruptedException e){
                System.out.println(e.toString());
            }
        } else {
            try {
                System.out.println( naam + " pakt de maaltijd en loopt te lopen naar tafel " + m.getTafelNr());
                Thread.sleep(2 * (LOOPTIJD * m.getTafelNr()));
            } catch (InterruptedException e){
                System.out.println(e.toString());
            }
        }
    }

    /**
     * Stopt de ober met serveren en hiermee is run klaar en stopt ook de thread
     */
    public void stopMetServeren() {
        System.out.println("Stoppen: " + naam);
        stoppen = true;
    }
}
