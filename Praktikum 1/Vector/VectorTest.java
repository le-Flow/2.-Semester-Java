import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class VectorTest {
    Vector v1 = new Vector(3, 6);
    Vector v2 = new Vector();
    @Test
    public void testDefaultConstructor(){
        assertEquals(0, v2.getX(), 0);
        assertEquals(0, v2.getY(), 0);
    }

    @Test 
    public void testConstructor(){
        assertEquals(3, v1.getX(), 0);
        assertEquals(6, v1.getY(), 0);
    }

    @Test
    public void testSetter(){
        v1.setX(6);
        v1.setY(3);
        assertEquals(6, v1.getX(), 0);
        assertEquals(3, v1.getY(), 0);
    }

    @Test 
    public void testGetter(){
        assertEquals(3, v1.getX(), 0);
        assertEquals(6, v1.getY(), 0);
    }

    @Test 
    public void testMagnitude(){
        assertEquals(6.708, v1.getMagnitude(), 0.001);
    }

    @Test
    public void testAsNormalized(){
        assertEquals(0.447, v1.asNormalized().getX(), 0.001);
        assertEquals(0.8944, v1.asNormalized().getY(), 0.001);
        try {
            v2.asNormalized();
            fail("Expected IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            // Expected
        }
    }

    @Test
    public void testAdd(){
        v1.add(v1);
        assertEquals(6, v1.getX(), 0);
        assertEquals(12, v1.getY(), 0);
    }

    @Test
    public void testFromPolar(){
        Vector polar = Vector.fromPolar(0.34, 8);
        assertEquals(7.542, polar.getX(), 0.001);
        assertEquals(2.667, polar.getY(), 0.001);

        //Magnitude can be 0 but not negative
        Vector polar2 = Vector.fromPolar(0.34, 0);
        assertEquals(0, polar2.getX(), 0.001);
        assertEquals(0, polar2.getY(), 0.001);
        
        try {
            Vector polarFail1 = Vector.fromPolar(0.34, -8);
            fail("Expected IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            // Expected
        }

        try {
            Vector polarFail2 = Vector.fromPolar(2*Math.PI, 8);
            fail("Expected IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            // Expected
        }

        try {
            Vector polarFail3 = Vector.fromPolar(0, 8);
            fail("Expected IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            // Expected
        }

        try {
            Vector polarFail4 = Vector.fromPolar(-0.34, 8);
            fail("Expected IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            // Expected
        }

        try {
            Vector polarFail5 = Vector.fromPolar(120, 8);
            fail("Expected IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            // Expected
        }
    }
}
