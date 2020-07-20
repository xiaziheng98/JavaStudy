package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String[] value() default "unknown";
}
