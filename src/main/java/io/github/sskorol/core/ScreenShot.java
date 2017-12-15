package io.github.sskorol.core;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.testng.ITestResult;

import java.time.LocalDate;

import static io.github.sskorol.utils.AttachmentUtils.attachScreenshot;
import static java.util.Objects.nonNull;
import static org.testng.ITestResult.FAILURE;

/**
 * Class for the implementation screenshot processing.
 */
public class ScreenShot implements ScreenshotConsumer {

    @SuppressFBWarnings("RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT")
    @Override
    public void handle(final byte[] screenshot, final ITestResult testResult) {
        if (nonNull(screenshot) && testResult.getStatus() == FAILURE) {
            attachScreenshot(screenshot,
                    testResult.getMethod().getMethodName() + "_" + LocalDate.now());
        }
    }
}
