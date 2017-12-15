package io.github.sskorol.core;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;
import java.util.function.Function;

import static io.github.sskorol.core.WaitCondition.allVisible;
import static io.github.sskorol.core.WaitCondition.visible;
import static io.github.sskorol.listeners.BaseListener.getDriverMetaData;
import static io.github.sskorol.utils.ElementTypeUtils.*;
import static io.github.sskorol.utils.RegexpUtils.getMappedElement;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Parent class for all PageObjects. Defines common actions, like clicks, selections, etc.
 */
public abstract class BasePage implements Page {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final WebDriver mockDriver;
    private final WebElement mockElement;

    public BasePage() {
        this.driver = getDriverMetaData()._1;
        this.wait = getDriverMetaData()._2;
        this.mockDriver = mock(WebDriver.class);
        this.mockElement = mock(WebElement.class);
    }

    @Step("Navigate to \"{url}\"")
    public Page navigateTo(final String url) {
        driver.get(url);
        return this;
    }

    protected void click(final By locator) {
        click(locator, visible);
    }

    protected void click(final By locator, final WaitCondition condition) {
        elementOf(waitFor(locator, "", condition)).click();
    }

    protected void phantomClick(final By locator) {
        when(mockDriver.findElement(locator)).thenReturn(mockElement);
        mockDriver.findElement(locator).click();
    }

    protected void type(final By locator, final CharSequence text, final WaitCondition condition) {
        elementOf(waitFor(locator, "", condition)).sendKeys(text);
    }

    protected void phantomType(final By locator, final CharSequence text) {
        when(mockDriver.findElement(locator)).thenReturn(mockElement);
        mockDriver.findElement(locator).sendKeys(text);
    }

    protected String getPhantomText(final By locator, final String value) {
        when(mockElement.getText()).thenReturn(value);
        when(mockDriver.findElement(locator)).thenReturn(mockElement);
        return mockDriver.findElement(locator).getText();
    }

    protected void selectCategory(final String category) {
        Optional.of(By.linkText(category))
                .ifPresent(this::click);
    }

    protected void selectByParameters(final By locator, final String value) {
        streamOf(waitFor(locator, "", allVisible))
                .filter(webElement -> webElement.getText().equals(value))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    protected void selectByAttribute(final By locator, final String value, final String attribute) {
        streamOf(waitFor(locator, "", allVisible))
                .filter(webElement -> webElement.getAttribute(attribute).equals(value))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    protected void selectColor(final By locator, final String regexp, final String value) {
        getMappedElement(listOf(waitFor(locator, "", allVisible)),
                regexp, getHTMLofAccessCodePage(), value).click();
    }

    private String getHTMLofAccessCodePage() {
        return driver.getPageSource();
    }

    @SuppressWarnings("unchecked")
    private <T, V, R> R waitFor(final T arg1, final V arg2, final WaitCondition condition) {
        return (R) wait.until((Function<WebDriver, ?>) condition.getType().apply(arg1, arg2));
    }
}
