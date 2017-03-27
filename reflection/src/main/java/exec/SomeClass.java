package exec;
import renderer.RenderMe;

/**
 * TestClass.
 * @author Daniel Gabl
 *
 */

public class SomeClass {
    @RenderMe private int foo;
    //@RenderMe(with = "renderer.ArrayRenderer") private int[] array = {1, 2};
    @RenderMe private int date = 2;
    
    /**
     * Constructor.
     * @param foo Int Value
     */
    public SomeClass(int foo) {
            this.foo = foo;
    }
}