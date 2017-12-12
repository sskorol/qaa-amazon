package io.github.sskorol.pages;

import io.github.sskorol.core.BasePage;
import org.openqa.selenium.By;

import static io.github.sskorol.core.BaseConfig.BASE_CONFIG;

@SuppressWarnings("JavadocType")
public class ProductPage extends BasePage {

    private static final String REGEXP_FOR_COLOR = ".colorsprite.*(\\n*\\t*.*).a-size-small a-color-base.>(.*?)<";
    private final By checkboxes = By.xpath("//li/span/span/div/label");
    private final By resultProducts = By.xpath("//ul[@id='s-results-list-atf']/li");
    private final By colors = By.cssSelector(".colorsprite");

    public ProductPage selectByColor(final String color) {
        selectColor(colors, REGEXP_FOR_COLOR, color);
        return this;
    }

    public ProductPage selectCheckboxBy(final String condition) {
        selectByParameters(checkboxes, condition);
        return this;
    }

    public ProductPage selectProduct(final String condition) {
        selectProductBy(resultProducts, condition);
        return this;
    }

    @Override
    public String url() {
        return BASE_CONFIG.url();
    }
}
