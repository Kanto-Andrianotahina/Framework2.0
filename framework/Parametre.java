package etu1922.framework;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Parametre {
    public String param() default "";    
}
