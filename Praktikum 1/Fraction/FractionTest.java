import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class FractionTest {
    Fraction f1 = new Fraction(3, 6);

    @Test
    public void defaultConstructor() {
        assertEquals(3,f1.getNom(), 0);
        assertEquals(6,f1.getDenom(), 0);

        try {
            Fraction fail1 = new Fraction(3, 0);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected
        }
    }

    @Test
    public void testCopy(){
        Fraction copy = new Fraction(f1);
        assertEquals(3, copy.getNom(), 0);
        assertEquals(6, copy.getDenom(), 0);
    }

    @Test
    public void testSetter(){
        f1.setNom(6);
        f1.setDenom(3);
        assertEquals(6, f1.getNom(), 0);
        assertEquals(3, f1.getDenom(), 0);
    }

    @Test
    public void testGetter(){
        assertEquals(3, f1.getNom(), 0);
        assertEquals(6, f1.getDenom(), 0);
    }

    @Test
    public void testNormalizeSign(){
        Fraction np = new Fraction(-3, 6);
        assertEquals(-3, np.normalizeSign().getNom(), 0);
        assertEquals(6, np.normalizeSign().getDenom(), 0);

        Fraction pn = new Fraction(3, -6);
        assertEquals(-3, pn.normalizeSign().getNom(), 0);
        assertEquals(6, pn.normalizeSign().getDenom(), 0);

        Fraction nn = new Fraction(-3, -6);
        assertEquals(3, nn.normalizeSign().getNom(), 0);
        assertEquals(6, nn.normalizeSign().getDenom(), 0);

        Fraction pp = new Fraction(3, 6);
        assertEquals(3, pp.normalizeSign().getNom(), 0);
        assertEquals(6, pp.normalizeSign().getDenom(), 0);

        Fraction zero = new Fraction(0, 2);
        assertEquals(0, zero.normalizeSign().getNom(), 0);
        assertEquals(1, zero.normalizeSign().getDenom(), 0);
    }

    @Test
    public void testAsReduced(){
        assertEquals(1, f1.asReduced().getNom(), 0);
        assertEquals(2, f1.asReduced().getDenom(), 0);

        Fraction nn = new Fraction(-3, -6);
        assertEquals(-1, nn.asReduced().getNom(), 0);
        assertEquals(-2, nn.asReduced().getDenom(), 0);
    }

    @Test
    public void testValue(){
        assertEquals(0.5, f1.value(), 0.001);
    }

    @Test
    public void testEquals(){
        Fraction f2 = new Fraction(3, 6);
        if(f1.equals(f2) == false){
            fail("Expected true");
        }

        Fraction fail1 = new Fraction(1, 2);
        if (f1.equals(fail1) == true){
            fail("Expected false");
        }
    }

    @Test       
    public void testValueEquals(){
        Fraction f2 = new Fraction(1, 2);
        if (f1.valueEquals(f2) == false){
            fail("Expected false");
        }
    }
}
