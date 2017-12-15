package io.github.sskorol.core;

import io.github.sskorol.data.DataReader;
import one.util.streamex.StreamEx;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.ArrayList;
import java.util.List;

import static io.github.sskorol.utils.ServiceLoaderUtils.load;
import static java.lang.ClassLoader.getSystemClassLoader;
import static org.apache.commons.io.FilenameUtils.getExtension;

/**
 * Listener for the implementation data reading from files.
 */
public class ReaderListener implements ISuiteListener {

    private static final List<DataReader> READERS = new ArrayList<>();

    public static DataReader readerOf(final String dataSource) {
        return StreamEx.of(load(DataReader.class, getSystemClassLoader()))
                .findFirst(dataReader -> dataReader.dataType().equals(getExtension(dataSource)))
                .orElseThrow(() -> new IllegalArgumentException("Unable to read " + dataSource));
    }

    @Override
    public void onStart(final ISuite suite) {
        READERS.addAll(load(DataReader.class, getSystemClassLoader()));
    }

    @Override
    public void onFinish(final ISuite suite) {
        READERS.clear();
    }
}
