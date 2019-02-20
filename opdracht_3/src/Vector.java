import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Vector {
    /**
     * Hierbij de main-method van de Opdracht.
     * @param args wordt wellicht gebruikt om parameters mee te kunnen geven vanaf de commandline
     */
    public static void main(String[] args) {
        System.out.println("Opdracht 03 is aan!");
    }

    int x;
    int y;

    public Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Geeft de lengte van de vector.
     * @return
     */
    double getLength (){
        return sqrt(pow(x,2)+pow(y,2));
    }

    /**
     * Stub: om de afstand tussen deze vector en v te bepalen.
     * @return
     */
    double getAfstand(Vector v) {
        return sqrt(pow((this.x-v.x),2)+pow((this.y-v.y),2));
    }

    /**
     * Stub: om een nieuwe vector op te leveren die de som is van deze vector en v.
     * @return
     */
    Vector plus(Vector v){
        return new Vector(this.x + v.x, this.y + v.y);
    }

    /**
     * Stub: om te bepalen of deze vector gelijk is aan v.
     * @return
     */
    boolean equals(Vector v){
        return false;
    }

    /**
     * Stub: om een nieuwe vector op te leveren verkregen door de x-waarde en de y-waarde van deze vector te vermenigvuldigen met d.
     * @return
     */
    Vector maal(double d){
        return this;
    }

    /**
     * Stub: om aan te geven of deze vector en v dezelfde richting hebben.
     * @return
     */
    boolean heeftZelfdeRichting(Vector v){
        return false;
    }

    /**
     * Stub: om het inwendig product van deze vector en v te bepalen.
     * @return
     */
    double getInproduct(Vector v){
        return 0.00;
    }

    /**
     * Stub: om de hoek van deze vector met de x-as te bepalen.
     * @return
     */
    double getHoek(){
        return 0.00;
    }
}
