package io.github.sskorol.listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import javax.annotation.CheckReturnValue;

import static io.github.sskorol.utils.AttachmentUtils.attachUri;

/**
 * Video recording listener, which allows .mp4 attachments for each test case.
 */
public class VideoRecordingListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        // not implemented
    }

    @Override
    @CheckReturnValue
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod()) {
            final String fileName = String.format("http://localhost:4444/video/%s.mp4",
                    testResult.getAttribute("sessionId"));
            attachUri("Video", fileName);
        }
    }
}
