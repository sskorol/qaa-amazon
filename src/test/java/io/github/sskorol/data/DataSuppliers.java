package io.github.sskorol.data;

import io.github.sskorol.core.DataSupplier;
import one.util.streamex.StreamEx;

import java.lang.reflect.Method;
import java.util.Arrays;

import static io.github.sskorol.core.ReaderListener.readerOf;
import static java.util.Optional.ofNullable;

/**
 * Data suppliers' methods for tests.
 */
public class DataSuppliers {

    @SuppressWarnings("unchecked")
    @DataSupplier(flatMap = true)
    public <T> StreamEx<T> getObject(final Method method) {
        return ofNullable(method.getDeclaredAnnotation(Data.class))
                .map(data -> StreamEx.of(readerOf(data.source())
                        .readFrom(data.source(), (Class<T>) data.entity())))
                .orElseGet(StreamEx::empty);
    }

    @SuppressWarnings("unchecked")
    @DataSupplier(transpose = true)
    public <T> T[] getDataCollection(final Method method) {
        return (T[]) ofNullable(method.getAnnotationsByType(Data.class))
                .map(data -> StreamEx.of(data)
                        .flatMap(dataIn -> Arrays.stream(readerOf(dataIn.source())
                                .readFrom(dataIn.source(), (Class<T>) dataIn.entity()))).toArray())
                .orElseThrow(() -> new NoClassDefFoundError("No Data class found"));
    }
}
