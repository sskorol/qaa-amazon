package io.github.sskorol.testcases;

import io.github.sskorol.pages.ProductPage;
import io.github.sskorol.pages.SearchPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.github.sskorol.core.PageFactory.at;
import static io.github.sskorol.core.PageFactory.open;

/**
 * Tests for Google search page.
 */

public class AmazonTests {

    @Test(description = "Should search for keyword")
    @Feature("Search")
    @Story("Implement search functionality")
    @Issue("35")
    @TmsLink("35")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForProduct() {
        open(SearchPage.class)
                .searchFor("Montale")
                .selectCategoryBy("Women's Eau de Parfum");

        at(ProductPage.class)
                .selectCheckboxBy("3 to 3.4 Ounces")
                .selectProduct("120");
    }
}
