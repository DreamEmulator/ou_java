import static java.lang.Math.*;

public class Vector {

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
     * @return de lengte
     */
    public double getLength (){
        return sqrt(pow(x,2)+pow(y,2));
    }

    /**
     * Geeft de afstand tussen deze vector en v te bepalen.
     * @param v de vector waarmee vergelekeen dient te worden
     * @return de afstand tussen de twee
     */
    public double getAfstand(Vector v) {
        return sqrt(pow((this.x-v.x),2)+pow((this.y-v.y),2));
    }

    /**
     * Geeft een nieuwe vector die die dezelfde x- en y-waarde heeft als deze vector.
     * @return de clone van de vector
     */
    public Vector copy (){
        return new Vector(x,y);
    }
    /**
     * Geeft een nieuwe vector die de som is van deze vector en v.
     * @param v de vector die opgetelt moet worden bij de huidige
     * @return de som vector
     */
    public Vector plus(Vector v){
        return new Vector(this.x + v.x, this.y + v.y);
    }

    /**
     * Geeft aan of deze vector gelijk is aan v.
     * @param v de vector die vergeleken dient te worden
     * @return <code>true</code> als ze gelijk zijn, <code>false</code> als niet
     */
    public boolean equals(Vector v){
        if (abs(this.x - v.x) < EPSILON && abs(this.y - v.y) < EPSILON){
            return true;
        }
        return false;
    }

    /**
     * Geeft een nieuwe vector door de x-waarde en de y-waarde van deze vector te vermenigvuldigen met d.
     * @param d de waarde die vermenigvuldigd moet worden bij de huidige
     * @return de nieuwe vector
     */
    public Vector maal(double d){
        return new Vector(x * d, y * d);
    }

    /**
     * Geeft aan of deze vector en v dezelfde richting hebben.
     * @param v de vector die vergeleken dient te worden
     * @return <code>true</code> als ze gelijk zijn, <code>false</code> als niet
     */
    public boolean heeftZelfdeRichting(Vector v){
        if (abs(this.x * v.y - v.x * this.y) < EPSILON){
            return true;
        }
        return false;
    }

    /**
     * Geeft het inwendig product van deze vector en v.
     * @param v de vector die gebruikt dient te worden voor de inproduct
     * @return de inproduct
     */
    public double getInproduct(Vector v){
        return this.x * v.x + this.y * v.y;
    }

    /**
     * Geeft de hoek van deze vector met de x-as.
     * @return de hoek met de x-as
     */
    public double getHoek(){
        return atan(y/x);
    }
}
