package io.github.sskorol.pages;

import io.github.sskorol.core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static io.github.sskorol.core.BaseConfig.BASE_CONFIG;
import static io.github.sskorol.core.WaitCondition.enabled;

@SuppressWarnings("JavadocType")
public class SearchPage extends BasePage {

    private final By inputSearch = By.id("twotabsearchtextbox");

    @Step("Search for \"{text}\".")
    public SearchPage searchFor(final String text) {
        type(inputSearch, text + Keys.ENTER, enabled);
        return this;
    }

    @Override
    public String url() {
        return BASE_CONFIG.url();
    }
}
