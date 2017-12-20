package io.github.sskorol.listener;

import org.assertj.core.api.SoftAssertions;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

import static org.testng.ITestResult.SUCCESS;

@SuppressWarnings("JavadocType")
public class SoftAssertListener implements IInvokedMethodListener {

    private static final ThreadLocal<SoftAssertions> THREAD_LOCAL_CONTAINER_FOR_SOFT_ASSERTIONS = new ThreadLocal<>();

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod()) {
            THREAD_LOCAL_CONTAINER_FOR_SOFT_ASSERTIONS.set(new SoftAssertions());
        }
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod() && testResult.getStatus() == SUCCESS) {
            try {
                getSoftAssert().assertAll();
            } catch (AssertionError e) {
                testResult.getTestContext().getPassedTests().removeResult(testResult.getMethod());
                testResult.setStatus(TestResult.FAILURE);
                testResult.setThrowable(e);
            }
            THREAD_LOCAL_CONTAINER_FOR_SOFT_ASSERTIONS.remove();
        }
    }

    public static SoftAssertions getSoftAssert() {
        return THREAD_LOCAL_CONTAINER_FOR_SOFT_ASSERTIONS.get();
    }
}
