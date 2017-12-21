package io.github.sskorol.assertions;

import io.github.sskorol.model.LoginStatus;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * A simple model class for Login Status assert processing.
 */
public class LoginStatusAssert extends AbstractAssert<LoginStatusAssert, LoginStatus> {
    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of: \n<%s>\nto be: <%s>\nbut was: <%s>\n";

    public LoginStatusAssert(final LoginStatus loginStatus) {
        super(loginStatus, LoginStatusAssert.class);
    }

    @Step("Verify that the login status is equal to \"{loginStatus}\".")

    public LoginStatusAssert hasLoginStatus(final String loginStatus) {
        isNotNull();

        final String status = actual.getStatus();

        if (!Objects.areEqual(status, loginStatus)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Status name", actual, loginStatus, status);
        }
        return this;
    }
}
