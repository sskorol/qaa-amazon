package io.github.sskorol.pages;

import io.github.sskorol.core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static io.github.sskorol.core.BaseConfig.BASE_CONFIG;

@SuppressWarnings("JavadocType")
public class LoginPage extends BasePage {

    private static final String LOGIN_STATUS = "Authorized successfully";
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By signInButton = By.id("sign_in");
    private final By loginStatusButton = By.name("login_status");

    @Step("Login with username: \"{userName}\", password: \"{password}\"")
    public void login(final String userName, final String password) {
        phantomType(usernameInput, userName);
        phantomType(passwordInput, password);
        phantomClick(signInButton);
    }

    public String getLoginStatus() {
        return getPhantomText(loginStatusButton, LOGIN_STATUS);
    }

    @Override
    public String url() {
        return BASE_CONFIG.url();
    }
}
