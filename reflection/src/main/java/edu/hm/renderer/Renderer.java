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
     * Returns a String with the name, type and value of the given Object with "RenderMe" annotations.
     * @return String with name, type and value
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     * @throws InstantiationException 
     */
    public String render() throws IllegalArgumentException, IllegalAccessException, InstantiationException  {
        Class< ? extends Object> cut = object.getClass();
        
        // get all fields, even the private ones.
        Field[] fields = cut.getDeclaredFields();
        
        String output = new String("Instance of " + cut.getName() + ":\n");
        
        for (Field field : fields)  {
            Object anno = field.getAnnotation(edu.hm.renderer.RenderMe.class);
            
            // Annotation found
            if (anno != null)  {
                // make private variables accessible
                field.setAccessible(true);
                
                String name = field.getName();
                
                String type = field.getType().toString();
                String rem  = "class";
                if (type.contains(rem))  {
                    type = type.substring(rem.length() + 1);
                }
                
                String val  = field.get(object).toString();
                
                // check on with()
                if (field.getType().isArray()) {
                    ArrayRenderer ar = new ArrayRenderer(object, field);
                    String[] data = ar.render();
                    
                    name = data[0];
                    type = data[1];
                    val  = data[2];
                }  
                
                output += String.format("%s (Type %s): %s\n", name, type, val);
                
                // set accessibility back to private
                field.setAccessible(false);
            }
        }
        output = output.substring(0, output.length() - 1); // remove \n
        System.out.println(output);
        return output;
    }
}