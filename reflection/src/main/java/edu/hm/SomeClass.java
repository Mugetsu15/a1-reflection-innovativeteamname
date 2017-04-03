package edu.hm;
import java.util.Date;

import edu.hm.renderer.RenderMe;

/**
 * TestClass.
 * @author Daniel Gabl
 */

public class SomeClass {
    @RenderMe private int foo;
    private final int magicconstant = 5;
    @RenderMe(with = "renderer.ArrayRenderer") private int[] arr1 = {1, 2, magicconstant};
    @RenderMe(with = "renderer.ArrayRenderer") private String[] arr2 = {"a", "b", "e"};
    private final long time = 123456789L; // correct value would be 127056, Date make some problems
    @RenderMe private Date date =  new Date(time); // Fri Jan 02 11:17:36 CET 1970
    @RenderMe private long guetta = getDate().getTime();
    
    /**
     * Constructor.
     * @param foo Int Value
     */
    public SomeClass(int foo) {
            this.foo = foo;
    }
    
    /** Getter for foo.
     * @return foo
     */
    int getInt()  {
        return foo;
    }
    
    /** Getter for date.
     * @return date
     */
    Date getDate()  {
        return date;
    }
}