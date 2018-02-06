package io.github.sskorol.pages;

import io.github.sskorol.core.BasePage;
import io.github.sskorol.model.Category;
import io.github.sskorol.model.SortValues;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static io.github.sskorol.core.BaseConfig.BASE_CONFIG;
import static java.lang.String.format;

@SuppressWarnings("JavadocType")
public class ProductPage extends BasePage {

    private static final String PURCHASE_STATUS = "Operation was successfully completed";
    private final By resultProducts = By.xpath("//ul[@id='s-results-list-atf']/li");
    private final By buyButton = By.id("buy");

    @Step("Select the category: \"{category}\" and value: \"{value}\".")
    public ProductPage filterBy(final Category category, final String value) {
        click(By.xpath(format("//h4[text()=\"%s\"]/following::ul[position() <= 2]//span[text()=\"%s\"]/..",
                category.getName(),
                value)));
        return this;
    }

    @Step("Select the product")
    public ProductPage selectProduct() {
        click(resultProducts);
        return this;
    }

    @Step("Select the \"{value}\" category.")
    public ProductPage selectCategory(final String value) {
        click(By.linkText(value));
        return this;
    }

    @Step("Buy the product")
    public ProductPage buy() {
        phantomClick(buyButton);
        return this;
    }

    @Step("Sort by: \"{value}\".")
    public ProductPage sortBy(final SortValues value) {
        click(By.xpath(format(".//*[@id='sort']//option[text()=\"%s\"]", value.getName())));
        return this;
    }

    public String getPurchaseStatus() {
        return getPhantomText(buyButton, PURCHASE_STATUS);
    }

    @Override
    public String url() {
        return BASE_CONFIG.url();
    }
}
