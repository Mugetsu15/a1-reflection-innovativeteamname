package edu.hm.renderer;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Annotation-Class.
 * @author Daniel Gabl
 *
 */
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER })
public @interface RenderMe {
    
    /** Statement.
     * 
     * @return statement.
     */
    String with() default "";

}