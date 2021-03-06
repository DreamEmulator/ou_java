package opdracht_03;

/**
 * De Restaurant klasse creëert lokaal objecten die een simulatie uitvoeren van een restaurant. Dit gaat over meerdere threads. Een per Kok of Ober object.
 */
class Restaurant {

    static final int AANTALTAFELS = 10;
    private static final int SIMULATIETIJD = 120000;

    static final String[] GERECHTEN = {
            "Pasta",
            "Stoofpot",
            "Noodles",
            "Pannekoek",
            "Pizza",
            "Boterham"
    };

    /**
     * Lege constructor om aan opdracht te voldoen en overeen te komen met diagram, maar met de kennis dat zonder explicitiete constructor java een default constructor zou aanroepen op Restaurant
     */
    public Restaurant() {
    }

    /**
     * Start en runt de simulatie tot dat de tijd verstreken is en de thread om te stoppen van Sleep gehaald wordt
     */
    public static void main(String[] args) {

        Uitgiftebalie uitgiftebalie = new Uitgiftebalie();

        Kok kok01 = new Kok("Bart", uitgiftebalie);
        Kok kok02 = new Kok("Jan", uitgiftebalie);
        Kok kok03 = new Kok("Truus", uitgiftebalie);

        Thread threadKok01 = new Thread(kok01);
        Thread threadKok02 = new Thread(kok02);
        Thread threadKok03 = new Thread(kok03);

        threadKok01.start();
        threadKok02.start();
        threadKok03.start();

        Ober ober01 = new Ober("Machteld", uitgiftebalie);
        Ober ober02 = new Ober("Arjen", uitgiftebalie);

        Thread threadOber01 = new Thread(ober01);
        Thread threadOber02 = new Thread(ober02);

        threadOber01.start();
        threadOber02.start();

        try {
            Thread.sleep(SIMULATIETIJD);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        kok01.stopMetKoken();
        kok02.stopMetKoken();
        kok03.stopMetKoken();

        ober01.stopMetServeren();
        ober02.stopMetServeren();

        System.out.println("De simulatietijd is verstreken");
        System.exit(0);

    }

}
