package io.github.sskorol.testcases;

import io.github.sskorol.data.Data;
import io.github.sskorol.data.DataSuppliers;
import io.github.sskorol.model.*;
import io.github.sskorol.pages.LoginPage;
import io.github.sskorol.pages.ProductPage;
import io.github.sskorol.pages.SearchPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.github.sskorol.assertions.CustomAssertions.customAssertThat;
import static io.github.sskorol.core.PageFactory.at;
import static io.github.sskorol.core.PageFactory.open;
import static io.github.sskorol.model.OperationStatus.LOGIN_SUCCESSFUL;
import static io.github.sskorol.model.OperationStatus.PURCHASE_SUCCESSFUL;

/**
 * Tests for Amazon.com page.
 */
public class AmazonTests {
    @Data(source = "parfume.json", entity = Parfume.class)
    @Data(source = "accountAmazon.json", entity = Account.class)
    @Test(dataProvider = "getDataCollection",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Parfume")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("14")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForParfume(final Parfume parfume, final Account account) {

        open(LoginPage.class)
                .login(account.getUsername(), account.getPassword());

        customAssertThat(at(LoginPage.class))
                .hasLoginStatus(LOGIN_SUCCESSFUL);

        at(SearchPage.class)
                .searchFor(parfume.getName());

        at(ProductPage.class)
                .selectCategoryBy(parfume.getSubCategory())
                .selectCheckboxBy(parfume.getSize())
                .sortBy(parfume.getSortValue())
                .selectProduct()
                .selectScent(parfume.getScent())
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
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

        customAssertThat(at(LoginPage.class))
                .hasLoginStatus(LOGIN_SUCCESSFUL);

        at(SearchPage.class)
                .searchFor(lego.getName());

        at(ProductPage.class)
                .selectCheckboxBy(lego.getAgeRange())
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }

    @Data(source = "shoes.json", entity = Shoes.class)
    @Data(source = "accountAmazon.json", entity = Account.class)
    @Test(dataProvider = "getDataCollection",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Shoes")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("10")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForShoes(final Shoes shoes, final Account account) {

        open(LoginPage.class)
                .login(account.getUsername(), account.getPassword());

        customAssertThat(at(LoginPage.class))
                .hasLoginStatus(LOGIN_SUCCESSFUL);

        at(SearchPage.class)
                .searchFor(shoes.getName());

        at(ProductPage.class)
                .selectCategoryBy(shoes.getSubCategory())
                .selectByColor(shoes.getColor())
                .selectBlockBy(shoes.getSize())
                .selectCheckboxBy(shoes.getBrand())
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }

    @Data(source = "tvshow.json", entity = TvShow.class)
    @Data(source = "accountAmazon.json", entity = Account.class)
    @Test(dataProvider = "getDataCollection",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Tv Show")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("17")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForTvShow(final TvShow show, final Account account) {

        open(LoginPage.class)
                .login(account.getUsername(), account.getPassword());

        customAssertThat(at(LoginPage.class))
                .hasLoginStatus(LOGIN_SUCCESSFUL);

        at(SearchPage.class)
                .searchFor(show.getName());

        at(ProductPage.class)
                .selectCategoryBy(show.getSubCategory())
                .selectCheckboxBy(show.getYear())
                .sortBy(show.getAvgCustomerReview())
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }

    @Data(source = "playstation.json", entity = Playstation.class)
    @Data(source = "accountAmazon.json", entity = Account.class)
    @Test(dataProvider = "getDataCollection",
            dataProviderClass = DataSuppliers.class,
            description = "Should Search For Playstation")
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("9")
    @TmsLink("11")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForPlaystation(final Playstation playstation, final Account account) {

        open(LoginPage.class)
                .login(account.getUsername(), account.getPassword());

        customAssertThat(at(LoginPage.class))
                .hasLoginStatus(LOGIN_SUCCESSFUL);

        at(SearchPage.class)
                .searchFor(playstation.getName());

        at(ProductPage.class)
                .selectCategoryBy(playstation.getSubCategory())
                .sortBy(playstation.getPriceLowToHigh())
                .selectProduct()
                .buy();

        customAssertThat(at(ProductPage.class))
                .hasPurchaseStatus(PURCHASE_SUCCESSFUL);
    }
}
