import static java.lang.Math.*;

public class Vector {
    /**
     * Hierbij de main-method van de Opdracht.
     * @param args wordt wellicht gebruikt om parameters mee te kunnen geven vanaf de commandline
     */
    public static void main(String[] args) {
        System.out.println("Opdracht 03 is aan!");
    }

    static final double EPSILON = 1e-16;

    double x;
    double y;

    public Vector(double x, double y) {
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
     * Geeft de afstand tussen deze vector en v te bepalen.
     * @return
     */
    double getAfstand(Vector v) {
        return sqrt(pow((this.x-v.x),2)+pow((this.y-v.y),2));
    }

    /**
     * Geeft een nieuwe vector die die dezelfde x- en y-waarde heeft als deze vector.
     */
    Vector copy (){
        return new Vector(x,y);
    }
    /**
     * Geeft een nieuwe vector die de som is van deze vector en v.
     */
    Vector plus(Vector v){
        return new Vector(this.x + v.x, this.y + v.y);
    }

    /**
     * Geeft aan of deze vector gelijk is aan v.
     */
    boolean equals(Vector v){
        if (abs(this.x - v.x) < EPSILON && abs(this.y - v.y) < EPSILON){
            return true;
        }
        return false;
    }

    /**
     * Geeft een nieuwe vector door de x-waarde en de y-waarde van deze vector te vermenigvuldigen met d.
     */
    Vector maal(double d){
        return new Vector(x * d, y * d);
    }

    /**
     * Geeft aan of deze vector en v dezelfde richting hebben.
     * @return
     */
    boolean heeftZelfdeRichting(Vector v){
        if (abs(this.x * v.y - v.x * this.y) < EPSILON){
            return true;
        }
        return false;
    }

    /**
     * Geeft het inwendig product van deze vector en v.
     */
    double getInproduct(Vector v){
        return this.x * v.x + this.y * v.y;
    }

    /**
     * Geeft de hoek van deze vector met de x-as.
     * @return
     */
    double getHoek(){
        return atan(y/x);
    }
}
