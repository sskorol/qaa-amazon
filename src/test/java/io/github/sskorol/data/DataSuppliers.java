package io.github.sskorol.data;

import io.github.sskorol.core.DataSupplier;
import lombok.extern.slf4j.Slf4j;
import one.util.streamex.StreamEx;

import java.lang.reflect.Method;

import static io.github.sskorol.core.ReaderListener.readerOf;
import static java.util.Optional.ofNullable;

/**
 * Data suppliers' methods for tests.
 */

@Slf4j
public class DataSuppliers {

    @SuppressWarnings("unchecked")
    @DataSupplier(flatMap = true)
    public <T> StreamEx<T> getObject(final Method method) {
        return ofNullable(method.getDeclaredAnnotation(Data.class))
                .map(data -> StreamEx.of(readerOf(data.source())
                        .readFrom(data.source(), (Class<T>) data.entity())))
                .orElseGet(StreamEx::empty);
    }
}
