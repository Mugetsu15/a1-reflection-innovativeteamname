package renderer;
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
     */
    public String render() throws IllegalArgumentException, IllegalAccessException  {
        String output = new String();
        
        Field[] fields = object.getClass().getFields();
        System.out.println("Fields-Length: " + fields.length);
        
        for (int c = 0; c < fields.length; c++)  {
            System.out.println("Field : " + fields[0]);
            Object anno = fields[c].getAnnotation(RenderMe.class);
            
            // Annotation found
            if (anno != null)  {
                String name = fields[c].getName();
                String type = fields[c].getType().toString();
                String val  = fields[c].get(object).toString();
                
                output += String.format("%s (Type %s) %s\n", name, type, val);
            }
        }
        return output;
    }
}