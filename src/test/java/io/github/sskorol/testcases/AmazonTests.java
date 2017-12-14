package io.github.sskorol.testcases;

import io.github.sskorol.data.Data;
import io.github.sskorol.data.DataSuppliers;
import io.github.sskorol.model.Account;
import io.github.sskorol.model.Lego;
import io.github.sskorol.model.Parfume;
import io.github.sskorol.model.Shoes;
import io.github.sskorol.pages.LoginPage;
import io.github.sskorol.pages.ProductPage;
import io.github.sskorol.pages.SearchPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.github.sskorol.assertions.CustomAssertions.customAssertThat;
import static io.github.sskorol.core.PageFactory.at;
import static io.github.sskorol.core.PageFactory.open;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for Amazon.com page.
 */

public class AmazonTests {

    @Data(source = "parfume.json", entity = Parfume.class)
    @Data(source = "accountAmazon.json", entity = Account.class)
    @Test(dataProvider = "getDataCollection", dataProviderClass = DataSuppliers.class)
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("35")
    @TmsLink("35")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForParfume(final Parfume parfume, final Account account) {

        open(LoginPage.class)
                .login(account.getUsername(), account.getPassword());

        assertThat(at(LoginPage.class).getLoginStatus()).isEqualTo("Authorized successfully");

        at(SearchPage.class)
                .searchFor(parfume.getName());

        at(ProductPage.class)
                .selectCategoryBy(parfume.getSubCategory())
                .selectCheckboxBy(parfume.getSize())
                .selectProduct()
                .selectScent(parfume.getScent())
                .buy();

        assertThat(at(ProductPage.class).getPurchaseStatus()).isEqualTo("Operation was successfully completed");
    }

    @Data(source = "lego.json", entity = Lego.class)
    @Data(source = "accountAmazon.json", entity = Account.class)
    @Test(dataProvider = "getDataCollection",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Lego")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("13")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForLego(final Lego lego, final Account account) {

        open(LoginPage.class)
                .login(account.getUsername(), account.getPassword());

        customAssertThat(account)
                .hasLoginStatus(at(LoginPage.class).getLoginStatus());

        at(SearchPage.class)
                .searchFor(lego.getName());

        at(ProductPage.class)
                .selectCheckboxBy(lego.getAgeRange())
                .selectProduct()
                .buy();

        customAssertThat(lego)
                .hasPurchaseStatus(at(ProductPage.class).getPurchaseStatus());
    }

    @Data(source = "shoes.json", entity = Shoes.class)
    @Data(source = "accountAmazon.json", entity = Account.class)
    @Test(dataProvider = "getDataCollection", dataProviderClass = DataSuppliers.class)
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("10")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForShoes(final Shoes shoes, final Account account) {

        open(LoginPage.class)
                .login(account.getUsername(), account.getPassword());

        customAssertThat(account)
                .hasLoginStatus(at(LoginPage.class).getLoginStatus());

        at(SearchPage.class)
                .searchFor(shoes.getName());

        at(ProductPage.class)
                .selectCategoryBy(shoes.getSubCategory())
                .selectByColor(shoes.getColor())
                .selectCheckboxBy(shoes.getSize())
                .selectCheckboxBy(shoes.getBrand())
                .selectProduct()
                .buy();

        customAssertThat(shoes)
                .hasPurchaseStatus(at(ProductPage.class).getPurchaseStatus());
    }
}
