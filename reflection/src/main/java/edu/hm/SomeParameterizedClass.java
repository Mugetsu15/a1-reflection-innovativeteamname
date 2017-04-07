package edu.hm;

import edu.hm.renderer.RenderMe;

/**
 * TestClass.
 * @author Daniel Gabl
 */

public class SomeParameterizedClass {
    @RenderMe private int foo;
    
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
