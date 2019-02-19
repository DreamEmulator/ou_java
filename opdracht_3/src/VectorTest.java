import static org.junit.Assert.*;

public class VectorTest {

    Vector v1;
    Vector v2;

    @org.junit.Before
    public void setUp() throws Exception {
        v1 = new Vector(3,4);
        v2 = new Vector(5,2);
    }

    @org.junit.Test
    public void getLength() {
        assertEquals(5,5);
    }

    @org.junit.Test
    public void getAfstand() {
        assertEquals(5,5);
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