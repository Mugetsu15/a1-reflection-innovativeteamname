package edu.hm.renderer;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * ArrayRenderer Class.
 * @author Daniel Gabl
 *
 */
public class ArrayRenderer {
    private Object object;
    private Field field;
    
    /**
     * Renderer for IntArrays.
     * @param obj ArrayObject
     * @param field Field to get Data off
     */
    ArrayRenderer(Object obj, Field field)  {
        object = obj;
        this.field = field;
    }
    
    /**
     * render-method().
     * @return string
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    String[] render() throws IllegalArgumentException, IllegalAccessException  {
        String name = field.getName();
        String type = field.get(object).getClass().getSimpleName();
        String value = new String();
        
        Object array = field.get(object);
        int length = Array.getLength(array);
        
        value += "[";
        for (int i = 0; i < length; i++) {
            value += Array.get(array, i) + ", ";
        }
        value = value.substring(0, value.length() - 2); // remove ", " from the end
        value += "]";
        
        String[] output = {name, type, value};
        return output;
    }
}
