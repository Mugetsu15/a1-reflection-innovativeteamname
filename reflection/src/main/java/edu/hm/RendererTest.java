package edu.hm;

import static org.junit.Assert.*;
import org.junit.*;

import edu.hm.renderer.Renderer;

/**
 * Test for normal Renderer.
 * @author Daniel Gabl
 *
 */
public class RendererTest {
    private SomeClass toRender;
    private Renderer renderer;
    
    
    /** Initial setup. */
    @Before
    public void setUp() {
        final int num = 5;
        toRender = new SomeClass(num);
        renderer = new Renderer(toRender);
    }
    
    /** Test on rendering.
     * 
     * @throws Exception Exception
     */
    @Test
    public void testRendering() throws Exception {
        assertEquals("Instance of edu.hm.SomeClass:\n"
                + "foo (Type int): 5\n"
                + "array (Type int[]) [1, 2, 3]\n"
                + "date (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
    }
}