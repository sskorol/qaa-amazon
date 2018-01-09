package io.github.sskorol.pages;

import io.github.sskorol.core.BasePage;
import io.github.sskorol.model.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static io.github.sskorol.core.BaseConfig.BASE_CONFIG;
import static io.github.sskorol.core.PageFactory.at;

@SuppressWarnings("JavadocType")
public class LoginPage extends BasePage {

    private static final String LOGIN_STATUS = "Authorized successfully";
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By signInButton = By.id("sign_in");
    private final By loginStatusButton = By.name("login_status");

    @Step("Login with account: \"{account}\"")
    public SearchPage login(final Account account) {
        phantomType(usernameInput, account.getUsername());
        phantomType(passwordInput, account.getPassword());
        phantomClick(signInButton);
        return at(SearchPage.class);
    }

    public String getLoginStatus() {
        return getPhantomText(loginStatusButton, LOGIN_STATUS);
    }

    @Override
    public String url() {
        return BASE_CONFIG.url();
    }
}
