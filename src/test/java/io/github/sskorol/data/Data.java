package io.github.sskorol.data;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Custom annotation for test data.
 */
@Repeatable(value = DataCollection.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Data {

    String source() default "";

    Class entity() default Object.class;

}
