package io.github.sskorol.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation for the test object.
 * Note: If you want to use DataSet in Test -
 * should mark a test entity with this annotation;
 * should specify a path to the source.
 * For example:
 * source="lego.json";
 * public class Lego {}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Source {

    String source() default "";
}
