package io.github.sskorol.assertions;

import io.github.sskorol.model.Account;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * A simple model class for Login Page assert processing.
 */

public class LoginPageAssert extends AbstractAssert<LoginPageAssert, Account> {

    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of: \n<%s>\nto be: <%s>\nbut was: <%s>\n";

    public LoginPageAssert(final Account account) {
        super(account, LoginPageAssert.class);
    }

    @Step("Verify that the login status is equal to \"{loginStatus}\".")
    public LoginPageAssert hasLoginStatus(final String loginStatus) {
        isNotNull();

        final String status = actual.getLoginStatus();

        if (!Objects.areEqual(status, loginStatus)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Status name", actual, loginStatus, status);
        }
        return this;
    }
}
