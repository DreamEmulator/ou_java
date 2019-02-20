import static org.junit.Assert.*;

public class VectorTest {

    Vector v1;
    Vector v2;
    Vector v3;
    Vector v4;

    private static final double DELTA = 0.01;

    @org.junit.Before
    public void setUp() throws Exception {
        v1 = new Vector(2,-2);
        v2 = new Vector(6,0);
        v3 = new Vector(-2,-3);
        v4 = new Vector(4,6);
    }

    @org.junit.Test
    public void getLength() {
        assertEquals(2.82, v1.getLength(), DELTA);
    }

    @org.junit.Test
    public void getAfstand() {
        assertEquals(4.47, v1.getAfstand(v2), DELTA);
    }

    @org.junit.Test
    public void plus() {
        Vector nieuweVector = v1.plus(v2);
        assertEquals(8, nieuweVector.x, DELTA);
        assertEquals(-2, nieuweVector.y, DELTA);
    }

    @org.junit.Test
    public void copy() {
        Vector nieuweVector = v1.copy();
        assertEquals(2, nieuweVector.x, DELTA);
        assertEquals(-2, nieuweVector.y, DELTA);
    }

    @org.junit.Test
    public void equals() {
        Vector nieuweVector = v1.copy();
        assertTrue(v1.equals(nieuweVector));
        assertFalse(v2.equals(nieuweVector));
    }

    @org.junit.Test
    public void maal() {
        Vector nieuweVector = v1.maal(2);
        assertEquals(4, nieuweVector.x, DELTA);
        assertEquals(-4, nieuweVector.y, DELTA);
    }

    @org.junit.Test
    public void heeftZelfdeRichting() {
        assertTrue(v3.heeftZelfdeRichting(v4));
    }

    @org.junit.Test
    public void getInproduct() {
        assertEquals(-26, v3.getInproduct(v4), DELTA);
    }

    @org.junit.Test
    public void getHoek() {
        assertEquals(-0.78, v1.getHoek(), DELTA);
        assertEquals(0, v2.getHoek(), DELTA);
        assertEquals(0.98, v3.getHoek(), DELTA);
        assertEquals(0.98, v4.getHoek(), DELTA);
    }
}