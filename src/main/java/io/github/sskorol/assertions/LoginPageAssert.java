package io.github.sskorol.assertions;

import io.github.sskorol.pages.LoginPage;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * A simple model class for Login Page assert processing.
 */
public class LoginPageAssert extends AbstractAssert<LoginPageAssert, LoginPage> {

    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of: \n<%s>\nto be: <%s>\nbut was: <%s>\n";

    public LoginPageAssert(final LoginPage actual) {
        super(actual, LoginPageAssert.class);
    }

    @Step("Verify that the login status is equal to \"{value}\".")

    public LoginPageAssert hasLoginStatus(final String value) {
        isNotNull();

        final String loginStatus = actual.getLoginStatus();

        if (!Objects.areEqual(loginStatus, value)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Status name", actual, loginStatus);
        }
        return this;
    }
}
