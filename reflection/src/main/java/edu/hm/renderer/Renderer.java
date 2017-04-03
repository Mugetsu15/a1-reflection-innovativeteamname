package edu.hm.renderer;
import java.lang.reflect.Field;

/**
 * Renderer Class.
 * @author Daniel Gabl
 *
 */
public class Renderer {
    
    /** Object to store */
    private Object object;
    
    /** Constructor for the Class.
     * 
     * @param obj Object given to the Class.
     */
    public Renderer(Object obj)  {
        object = obj;
    }
    
    /** 
     * Returns a String with the name, type and value of the given Object.
     * @return String with name, type and value
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     * @throws InstantiationException 
     */
    public String render() throws IllegalArgumentException, IllegalAccessException, InstantiationException  {
        Class< ? extends Object> cut = object.getClass();
        
        // get all fields, even the private ones.
        Field[] fields = cut.getDeclaredFields();
        int length = fields.length;
        
        String output = new String("Instance of " + cut.getName() + ":\n");
        
        for (int c = 0; c < length; c++)  {
            Object anno = fields[c].getAnnotation(edu.hm.renderer.RenderMe.class);
            
            // Annotation found
            if (anno != null)  {
                // make private variables accessible
                fields[c].setAccessible(true);
                
                String name = fields[c].getName();
                
                String type = fields[c].getType().toString();
                String rem = "class";
                if (type.contains(rem))  {
                    type = type.substring(rem.length() + 1);
                }
                
                String val  = fields[c].get(object).toString();
                
                // set accessibility back to private
                fields[c].setAccessible(false);
                
                output += String.format("%s (Type %s): %s\n", name, type, val);
            }
        }
        System.out.println(output);
        return output;
    }
}