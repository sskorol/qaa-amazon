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
    @Test(dataProvider = "getData",
            dataProviderClass = DataSuppliers.class,
            description = "Should Login")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("41")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldLogIn(final Account account) {

        open(LoginPage.class)
                .login(account);

        customAssertThat(at(LoginPage.class))
                .hasLoginStatus(LOGIN_SUCCESSFUL);
    }

    @Data(entity = ShouldSearchForParfumeDataSet.class)
    @Test(dataProvider = "getDataSet",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Parfume")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("14")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForParfume(final ShouldSearchForParfumeDataSet data) {

        open(LoginPage.class)
                .login(data.getAccount())
                .searchFor(data.getParfume().getName())
                .selectCategory(data.getParfume().getCategory())
                .sortBy(PRICE_HIGH_TO_LOW)
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }

    @Data(entity = ShouldSearchForLegoDataSet.class)
    @Test(dataProvider = "getDataSet",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Lego")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("13")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForLego(final ShouldSearchForLegoDataSet data) {

        open(LoginPage.class)
                .login(data.getAccount())
                .searchFor(data.getLego().getName())
                .filterBy(TOYS_AGE_RANGE, data.getLego().getAgeRange())
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }

    @Data(entity = ShouldSearchForShoesDataSet.class)
    @Test(dataProvider = "getDataSet",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Shoes")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("10")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForShoes(final ShouldSearchForShoesDataSet data) {

        open(LoginPage.class)
                .login(data.getAccount())
                .searchFor(data.getShoes().getName())
                .selectCategory(data.getShoes().getCategory())
                .filterBy(COLOR, data.getShoes().getColor())
                .filterBy(SHOE_SIZE, data.getShoes().getSize())
                .filterBy(BRAND, data.getShoes().getBrand())
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }

    @Data(entity = ShouldSearchForTvShowDataSet.class)
    @Test(dataProvider = "getDataSet",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Tv Show")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("17")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForTvShow(final ShouldSearchForTvShowDataSet data) {

        open(LoginPage.class)
                .login(data.getAccount())
                .searchFor(data.getTvShow().getName())
                .selectCategory(data.getTvShow().getCategory())
                .filterBy(MOVIE_TV, data.getTvShow().getYear())
                .sortBy(AVG_CUSTOMER_REVIEW)
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }

    @Data(entity = ShouldSearchForPlaystationDataSet.class)
    @Test(dataProvider = "getDataSet",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Playstation")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("11")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForPlaystation(final ShouldSearchForPlaystationDataSet data) {

        open(LoginPage.class)
                .login(data.getAccount())
                .searchFor(data.getPlaystation().getName())
                .selectCategory(data.getPlaystation().getCategory())
                .sortBy(PRICE_LOW_TO_HIGH)
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }
}
