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
public class ParameterizedRendererTest {
    /**
     * Returns Collection.
     * @return test collection.
     */
    
    private static String def = "Instance of edu.hm.SomeParameterizedClass:\n";
    private Renderer renderer;
    private String expected;
    static final int MAXVAL = 10;
    
    /**
     * Collection with given and expected Values.
     * @return Test Collection
     */
    @Parameters
    public static Collection<Object[]> data() {
        /* Object[][] ob;
        Object[] ob2 = new Object[MAXVAL][];
        ob = new Object[MAXVAL][];
        for (int c = 0; c < MAXVAL; c++)  {
            ob2[c] = c;
        }
        System.out.println(Arrays.asList(ob2)); */
        return Arrays.asList(new Object[][] { 
                 {0, def + "foo (Type int): 0"},
                 {1, def + "foo (Type int): 1"},
                 {2, def + "foo (Type int): 2"}
           });
    }
    
    /**
     * Parameterized Renderer Test.
     * @param input s 
     * @param expected s
     */
    public ParameterizedRendererTest(int input, String expected) {
        SomeParameterizedClass spc = new SomeParameterizedClass(input);
        renderer = new Renderer(spc);
        this.expected = expected;
    }

    /**
     * Testing.
     * @throws Exception in case of failure.
     */
    @Test
    public void parameterizedTest() throws Exception {
        assertEquals(renderer.render(), expected);
    }
}