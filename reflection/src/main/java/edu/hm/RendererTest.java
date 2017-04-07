package edu.hm;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import edu.hm.renderer.Renderer;

/**
 * Test for normal Renderer.
 * @author Daniel Gabl
 */
@RunWith(Parameterized.class)
public class RendererTest {
    /**
     * Returns Collection.
     * @return test collection.
     */
    
    private static String def = "Instance of edu.hm.SomeParameterizedClass:\n";
    private static String def2 = "\narr1 (Type int[]): [1, 2, 5]";
    private Renderer renderer;
    private Renderer renderer2;
    private String expected;
    private static boolean normal = false;
    static final int MAXVAL = 10;
    
    /**
     * Collection with given and expected Values.
     * @return Test Collection
     */
    @Parameters
    public static Collection<Object[]> data() {
        // Versuch, MAXVAL Objekte für den Test zu erzeugen. Leider ohne Erfolg.
        Object[][] ob = new Object[1][MAXVAL];
        for (int c = 0; c < MAXVAL - 1; c++)  {
            ob[0][c] = c + ", " + def + "foo (Type int): " + c + def2;
        }
        //return Arrays.asList(ob);
        return Arrays.asList(new Object[][] { 
            {0, def + "foo (Type int): 0" + def2},
            {1, def + "foo (Type int): 1" + def2},
            {2, def + "foo (Type int): 2" + def2}
      });
    }
    
    /**
     * Parameterized Renderer Test.
     * @param input s 
     * @param expected s
     */
    public RendererTest(int input, String expected) {
        final int num = 5;
        SomeClass sc = new SomeClass(num);
        SomeParameterizedClass spc = new SomeParameterizedClass(input);
        renderer = new Renderer(spc);
        if (!normal)  {
            renderer2 = new Renderer(sc);
        }
        this.expected = expected;
    }
    
    /**
     * Normal Testing.
     * @throws Exception in case of failure.
     */
    @Test
    public void normalTest() throws Exception {
        // Erneuter Versuch, wiederholten Test hierauf zu verhindern. jUnit doesn't give a damn.
        if (!normal)  {
            assertEquals(renderer2.render(), "Instance of edu.hm.SomeClass:\n"
                    + "foo (Type int): 5\n"
                    + "arr1 (Type int[]): [1, 2, 5]\n"
                    + "arr2 (Type String[]): [a, b, e]\n"
                    + "date (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n"
                    + "guetta (Type long): 123456789");
            normal = true;
        }
    }

    /**
     * Parameterized Testing.
     * @throws Exception in case of failure.
     */
    @Test
    public void parameterizedTest() throws Exception {
        assertEquals(renderer.render(), expected);
    }
}