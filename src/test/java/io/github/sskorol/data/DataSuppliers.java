package io.github.sskorol.data;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.customannotation.Source;
import io.vavr.Tuple;
import one.util.streamex.StreamEx;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static io.github.sskorol.listener.ReaderListener.readerOf;
import static io.github.sskorol.utils.ReflectUtils.getObject;
import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;

/**
 * Data suppliers' methods for tests.
 */
public class DataSuppliers {

    @SuppressWarnings("unchecked")
    @DataSupplier(flatMap = true)
    public <T> StreamEx<T> getAmazonTestData(final Method method) {
        return ofNullable(method.getDeclaredAnnotation(Data.class))
                .map(data -> StreamEx.of(readerOf(data.source())
                        .readFrom(data.source(), (Class<T>) data.entity())))
                .orElseGet(StreamEx::empty);
    }

    @SuppressWarnings("unchecked")
    @DataSupplier(transpose = true)
    public <T> T[] getAmazonTestDataCollection(final Method method) {
        return (T[]) ofNullable(method.getAnnotationsByType(Data.class))
                .map(data -> StreamEx.of(data)
                        .flatMap(dataIn -> stream(readerOf(dataIn.source())
                                .readFrom(dataIn.source(), (Class<T>) dataIn.entity()))).toArray())
                .orElseThrow(() -> new IllegalStateException("Data class not found"));
    }

    @SuppressWarnings("unchecked")
    @DataSupplier(flatMap = true)
    public <T> T getAmazonTestDataSet(final Method method) {
        return ofNullable(method.getDeclaredAnnotation(Data.class))
                .map(Data::entity)
                .map(entity -> (T) getObject((Class<T>) entity, getSourceArgs(entity)))
                .orElseThrow(() -> new IllegalStateException("No Data class found"));
    }

    private <T> Object[] getSourceArgs(final Class<T> entity) {
        return StreamEx.of(entity.getDeclaredFields())
                .map(Field::getType)
                .filter(type -> type.isAnnotationPresent(Source.class))
                .map(type -> Tuple.of(type, type.getAnnotation(Source.class).source()))
                .flatMap(t -> stream(readerOf(t._2).readFrom(t._2, t._1)))
                .toArray();
    }
}
