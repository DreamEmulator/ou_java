import static org.junit.Assert.*;

public class VectorTest {

    Vector v1;
    Vector v2;

    private static final double DELTA = 0.01;

    @org.junit.Before
    public void setUp() throws Exception {
        v1 = new Vector(2,2);
        v2 = new Vector(6,5);
    }

    @org.junit.Test
    public void getLength() {
        assertEquals(2.82,v1.getLength(), DELTA);
    }

//    @SuppressWarnings("deprecation")
    @org.junit.Test
    public void getAfstand() {
        assertEquals(5,v1.getAfstand(v2), DELTA);
    }

    @org.junit.Test
    public void plus() {
    }

    @org.junit.Test
    public void equals() {
    }

    @org.junit.Test
    public void maal() {
    }

    @org.junit.Test
    public void heeftZelfdeRichting() {
    }

    @org.junit.Test
    public void getInproduct() {
    }

    @org.junit.Test
    public void getHoek() {
    }
}