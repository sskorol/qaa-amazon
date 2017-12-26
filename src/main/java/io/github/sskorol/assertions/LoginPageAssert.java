package io.github.sskorol.assertions;

import io.github.sskorol.model.OperationStatus;
import io.github.sskorol.pages.LoginPage;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * A simple model class for Login Page assert processing.
 */
public class LoginPageAssert extends AbstractAssert<LoginPageAssert, LoginPage> {

    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of: \n<%s>\nto be: <%s>\nbut was: <%s>\n";

    public LoginPageAssert(final LoginPage loginPage) {
        super(loginPage, LoginPageAssert.class);
    }

    @Step("Verify that the login status is equal to \"{status}\".")

    public LoginPageAssert hasLoginStatus(final OperationStatus status) {
        isNotNull();

        final String loginStatus = actual.getLoginStatus();
        final String expectedLoginStatus = status.getName();

        if (!Objects.areEqual(loginStatus, expectedLoginStatus)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Status name", actual, expectedLoginStatus, loginStatus);
        }
        return this;
    }
}
