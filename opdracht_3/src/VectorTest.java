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
        v3 = new Vector(-2,-3.5);
        v4 = new Vector(4,7);
    }

    @org.junit.Test
    public void getLength() {
        assertEquals(2.82, v1.getLength(), DELTA);
        assertEquals(6, v2.getLength(), DELTA);
        assertEquals(4.03, v3.getLength(), DELTA);
        assertEquals(8.06, v4.getLength(), DELTA);
    }

    @org.junit.Test
    public void getAfstand() {
        assertEquals(4.47, v1.getAfstand(v2), DELTA);
        assertEquals(8.73, v2.getAfstand(v3), DELTA);
        assertEquals(12.09, v3.getAfstand(v4), DELTA);
        assertEquals(9.21, v4.getAfstand(v1), DELTA);
    }

    @org.junit.Test
    public void plus() {
        Vector nieuweVector = v1.plus(v2);
        assertEquals(8, nieuweVector.x, DELTA);
        assertEquals(-2, nieuweVector.y, DELTA);

        nieuweVector = v3.plus(v4);
        assertEquals(2, nieuweVector.x, DELTA);
        assertEquals(3.5, nieuweVector.y, DELTA);
    }

    @org.junit.Test
    public void copy() {
        Vector nieuweVector = v1.copy();
        assertEquals(2, nieuweVector.x, DELTA);
        assertEquals(-2, nieuweVector.y, DELTA);

        nieuweVector = v2.copy();
        assertEquals(6, nieuweVector.x, DELTA);
        assertEquals(0, nieuweVector.y, DELTA);

        nieuweVector = v3.copy();
        assertEquals(-2, nieuweVector.x, DELTA);
        assertEquals(-3.5, nieuweVector.y, DELTA);

        nieuweVector = v4.copy();
        assertEquals(4, nieuweVector.x, DELTA);
        assertEquals(7, nieuweVector.y, DELTA);
    }

    @org.junit.Test
    public void equals() {
        Vector nieuweVector = v1.copy();
        assertTrue(v1.equals(nieuweVector));
        assertFalse(v2.equals(nieuweVector));

        nieuweVector = v3.copy();
        assertTrue(v3.equals(nieuweVector));
        assertFalse(v4.equals(nieuweVector));
    }

    @org.junit.Test
    public void maal() {
        Vector nieuweVector = v1.maal(Math.PI);
        assertEquals(6.28, nieuweVector.x, DELTA);
        assertEquals(-6.28, nieuweVector.y, DELTA);

        nieuweVector = v2.maal(Math.PI);
        assertEquals(18.84, nieuweVector.x, DELTA);
        assertEquals(0, nieuweVector.y, DELTA);

        nieuweVector = v3.maal(Math.PI);
        assertEquals(-6.28, nieuweVector.x, DELTA);
        assertEquals(-10.99, nieuweVector.y, DELTA);

        nieuweVector = v4.maal(Math.PI);
        assertEquals(12.56, nieuweVector.x, DELTA);
        assertEquals(21.99, nieuweVector.y, DELTA);
    }

    @org.junit.Test
    public void heeftZelfdeRichting() {
        assertFalse(v1.heeftZelfdeRichting(v2));
        assertFalse(v2.heeftZelfdeRichting(v1));
        assertTrue(v3.heeftZelfdeRichting(v4));
        assertTrue(v4.heeftZelfdeRichting(v3));
    }

    @org.junit.Test
    public void getInproduct() {
        assertEquals(12, v1.getInproduct(v2), DELTA);
        assertEquals(-32.5, v3.getInproduct(v4), DELTA);
    }

    @org.junit.Test
    public void getHoek() {
        assertEquals(-0.78, v1.getHoek(), DELTA);
        assertEquals(0, v2.getHoek(), DELTA);
        assertEquals(1.05, v3.getHoek(), DELTA);
        assertEquals(1.05, v4.getHoek(), DELTA);
    }
}