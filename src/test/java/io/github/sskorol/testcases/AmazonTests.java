package io.github.sskorol.testcases;

import io.github.sskorol.data.Data;
import io.github.sskorol.data.DataSuppliers;
import io.github.sskorol.dataset.*;
import io.github.sskorol.model.Account;
import io.github.sskorol.pages.LoginPage;
import io.github.sskorol.pages.ProductPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.github.sskorol.assertions.CustomAssertions.customAssertThat;
import static io.github.sskorol.core.PageFactory.at;
import static io.github.sskorol.core.PageFactory.open;
import static io.github.sskorol.model.Category.*;
import static io.github.sskorol.model.OperationStatus.LOGIN_SUCCESSFUL;
import static io.github.sskorol.model.OperationStatus.PURCHASE_SUCCESSFUL;
import static io.github.sskorol.model.SortValues.*;

/**
 * Tests for Amazon.com page.
 */
public class AmazonTests {

    @Data(source = "accountAmazon.json", entity = Account.class)
    @Test(dataProvider = "getObject",
            dataProviderClass = DataSuppliers.class,
            description = "Should Login")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("41")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldLogIn(final Account account) {

        open(LoginPage.class)
                .login(account.getUsername(), account.getPassword());

        customAssertThat(at(LoginPage.class))
                .hasLoginStatus(LOGIN_SUCCESSFUL);
    }

    @Data(entity = ShouldSearchForParfume.class)
    @Test(dataProvider = "getDataSet",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Parfume")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("14")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForParfume(final ShouldSearchForParfume data) {

        open(LoginPage.class)
                .login(data.getAccount().getUsername(), data.getAccount().getPassword())
                .searchFor(data.getParfume().getName())
                .selectCategory(data.getParfume().getSubCategory())
                .chooseTo(WOMEN_FRAGRANCE_SIZE, data.getParfume().getAmount())
                .sortBy(PRICE_HIGH_TO_LOW)
                .selectProduct()
                .selectScent(data.getParfume().getScent())
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }

    @Data(entity = ShouldSearchForLego.class)
    @Test(dataProvider = "getDataSet",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Lego")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("13")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForLego(final ShouldSearchForLego data) {

        open(LoginPage.class)
                .login(data.getAccount().getUsername(), data.getAccount().getPassword())
                .searchFor(data.getLego().getName())
                .chooseTo(TOYS_AGE_RANGE, data.getLego().getAgeRange())
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }

    @Data(entity = ShouldSearchForShoes.class)
    @Test(dataProvider = "getDataSet",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Shoes")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("10")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForShoes(final ShouldSearchForShoes data) {

        open(LoginPage.class)
                .login(data.getAccount().getUsername(), data.getAccount().getPassword())
                .searchFor(data.getShoes().getName())
                .selectCategory(data.getShoes().getSubCategory())
                .selectColor(COLOR, data.getShoes().getColor())
                .selectDimension(SHOE_SIZE, data.getShoes().getSize())
                .chooseTo(BRAND, data.getShoes().getBrand())
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }

    @Data(entity = ShouldSearchForTvShow.class)
    @Test(dataProvider = "getDataSet",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Tv Show")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("17")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForTvShow(final ShouldSearchForTvShow data) {

        open(LoginPage.class)
                .login(data.getAccount().getUsername(), data.getAccount().getPassword())
                .searchFor(data.getTvShow().getName())
                .selectCategory(data.getTvShow().getSubCategory())
                .chooseTo(MOVIE_TV, data.getTvShow().getYear())
                .sortBy(AVG_CUSTOMER_REVIEW)
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }

    @Data(entity = ShouldSearchForPlaystation.class)
    @Test(dataProvider = "getDataSet",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Playstation")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("11")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForPlaystation(final ShouldSearchForPlaystation data) {

        open(LoginPage.class)
                .login(data.getAccount().getUsername(), data.getAccount().getPassword())
                .searchFor(data.getPlaystation().getName())
                .selectCategory(data.getPlaystation().getSubCategory())
                .sortBy(PRICE_LOW_TO_HIGH)
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }
}
