package exec;

import static org.junit.Assert.*;
import org.junit.*;
import renderer.*;

/**
 * Test for normal Renderer.
 * @author Daniel Gabl
 *
 */
public class RendererTest {
    private SomeClass toRender;
    private Renderer renderer;
    
    
    /** Test on setup. */
    @Before
    public void setUp() {
        toRender = new SomeClass(1);
        renderer = new Renderer(toRender);
    }
    
    /** Test on rendering.
     * 
     * @throws Exception Exception
     */
    @Test
    public void testRendering() throws Exception {
        setUp();
        assertEquals("Instance of edu.hm.SomeClass:\n"
                + "foo (Type int): 5\narray (Type int[]) [1, 2, 3, ]\ndate (Type java"
                + ".util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
    }
}
