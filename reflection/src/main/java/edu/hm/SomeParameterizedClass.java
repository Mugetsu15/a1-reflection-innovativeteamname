package edu.hm;

import edu.hm.renderer.RenderMe;

/**
 * TestClass.
 * @author Daniel Gabl
 */

public class SomeParameterizedClass {
    @RenderMe private int foo;
    private final int magicconstant = 5;
    @RenderMe(with = "renderer.ArrayRenderer") private int[] arr1 = {1, 2, magicconstant};
    
    /**
     * Constructor.
     * @param foo Int Value
     */
    public SomeParameterizedClass(int foo) {
            this.foo = foo;
    }
    
    /** Getter for foo (not needed).
     * @return foo
     */
    //int getInt()  {
    //    return foo;
    //}
}
