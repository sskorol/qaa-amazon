package io.github.sskorol.utils;

import static org.joor.Reflect.on;

/**
 * Object creating processing class.
 * Use it when you will create object via reflection.
 */
public final class ReflectUtils {

    private ReflectUtils() {
        throw new UnsupportedOperationException("Illegal access to private constructor.");
    }

    public static <T> T getObject(final Class<T> entityClass, final Object... args) {
        return on(entityClass).create(args).get();
    }
}
