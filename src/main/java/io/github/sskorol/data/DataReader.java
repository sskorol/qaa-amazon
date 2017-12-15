package io.github.sskorol.data;

/**
 * Interface for read data from different sources.
 */
public interface DataReader {

    <T> T[] readFrom(String dataSource, Class<T> entityClass);

    String dataType();
}
