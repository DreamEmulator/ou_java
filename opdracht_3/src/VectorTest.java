import static org.junit.Assert.*;

public class VectorTest {

    Vector v1;
    Vector v2;
    Vector v3;
    Vector v4;
    Vector v5;
    Vector v6;

    private static final double DELTA = 1e-16;

    @org.junit.Before
    public void setUp() throws Exception {
        v1 = new Vector(2,-2);
        v2 = new Vector(6,0);
        v3 = new Vector(-2,-3.5);
        v4 = new Vector(4,7);
        v5 = new Vector(0,6);
        v6 = new Vector(0,0);
    }

    @org.junit.Test
    public void getLength() {
        assertEquals(2.8284271247461903, v1.getLength(), DELTA);
        assertEquals(6, v2.getLength(), DELTA);
        assertEquals(4.031128874149275, v3.getLength(), DELTA);
        assertEquals(8.06225774829855, v4.getLength(), DELTA);
        assertEquals(6, v5.getLength(), DELTA);
    }

    @org.junit.Test
    public void getAfstand() {
        assertEquals(4.47213595499958, v1.getAfstand(v2), DELTA);
        assertEquals(8.73212459828649, v2.getAfstand(v3), DELTA);
        assertEquals(12.093386622447824, v3.getAfstand(v4), DELTA);
        assertEquals(9.219544457292887, v4.getAfstand(v1), DELTA);
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

        nieuweVector = v5.copy();
        assertEquals(0, nieuweVector.x, DELTA);
        assertEquals(6, nieuweVector.y, DELTA);

        nieuweVector = v6.copy();
        assertEquals(0, nieuweVector.x, DELTA);
        assertEquals(0, nieuweVector.y, DELTA);
    }

    @org.junit.Test
    public void equals() {
        Vector nieuweVector = v1.copy();
        assertTrue(v1.equals(nieuweVector));
        assertFalse(v2.equals(nieuweVector));

        nieuweVector = v3.copy();
        assertTrue(v3.equals(nieuweVector));
        assertFalse(v4.equals(nieuweVector));

        nieuweVector = v5.copy();
        assertTrue(v5.equals(nieuweVector));
        assertFalse(v6.equals(nieuweVector));
    }

    @org.junit.Test
    public void maal() {
        Vector nieuweVector = v1.maal(Math.PI);
        assertEquals(6.283185307179586, nieuweVector.x, DELTA);
        assertEquals(-6.283185307179586, nieuweVector.y, DELTA);

        nieuweVector = v2.maal(Math.PI);
        assertEquals(18.84955592153876, nieuweVector.x, DELTA);
        assertEquals(0, nieuweVector.y, DELTA);

        nieuweVector = v3.maal(Math.PI);
        assertEquals(-6.283185307179586, nieuweVector.x, DELTA);
        assertEquals(-10.995574287564276, nieuweVector.y, DELTA);

        nieuweVector = v4.maal(Math.PI);
        assertEquals(12.566370614359172, nieuweVector.x, DELTA);
        assertEquals(21.991148575128552, nieuweVector.y, DELTA);

        nieuweVector = v5.maal(Math.PI);
        assertEquals(0, nieuweVector.x, DELTA);
        assertEquals(18.84955592153876, nieuweVector.y, DELTA);

        nieuweVector = v6.maal(Math.PI);
        assertEquals(0, nieuweVector.x, DELTA);
        assertEquals(0, nieuweVector.y, DELTA);
    }

    @org.junit.Test
    public void heeftZelfdeRichting() {
        assertFalse(v1.heeftZelfdeRichting(v2));
        assertFalse(v2.heeftZelfdeRichting(v1));
        assertTrue(v3.heeftZelfdeRichting(v4));
        assertTrue(v4.heeftZelfdeRichting(v3));
        assertTrue(v5.heeftZelfdeRichting(v6));
    }

    @org.junit.Test
    public void getInproduct() {
        assertEquals(12, v1.getInproduct(v2), DELTA);
        assertEquals(-12, v2.getInproduct(v3), DELTA);
        assertEquals(-32.5, v3.getInproduct(v4), DELTA);
        assertEquals(42, v4.getInproduct(v5), DELTA);
        assertEquals(0, v5.getInproduct(v6), DELTA);
        assertEquals(0, v6.getInproduct(v1), DELTA);
    }

    @org.junit.Test
    public void getHoek() {
        assertEquals(-0.7853981633974483, v1.getHoek(), DELTA);
        assertEquals(0, v2.getHoek(), DELTA);
        assertEquals(1.0516502125483738, v3.getHoek(), DELTA);
        assertEquals(1.0516502125483738, v4.getHoek(), DELTA);
        assertEquals(1.5707963267948966, v5.getHoek(), DELTA);
        assertEquals(0, v6.getHoek(), DELTA);
    }
}