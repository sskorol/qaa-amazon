package io.github.sskorol.testcases;

import io.github.sskorol.data.Data;
import io.github.sskorol.data.DataSuppliers;
import io.github.sskorol.model.Parfume;
import io.github.sskorol.pages.ProductPage;
import io.github.sskorol.pages.SearchPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static io.github.sskorol.core.PageFactory.at;
import static io.github.sskorol.core.PageFactory.open;

/**
 * Tests for Amazon.com page.
 */

public class AmazonTests {

    @Data(source = "parfume.json", entity = Parfume.class)
    @Test(dataProvider = "getObject", dataProviderClass = DataSuppliers.class)
    @Feature("Product search")
    @Story("Implement search functionality")
    @Issue("35")
    @TmsLink("35")
    @Severity(SeverityLevel.BLOCKER)
    public void shouldSearchForKeyword(final Parfume parfume) {

        open(SearchPage.class)
                .searchFor(parfume.getName());

        at(ProductPage.class)
                .selectCategoryBy(parfume.getSubCategory())
                .selectCheckboxBy(parfume.getSize())
                .selectProduct(parfume.getPrice())
                .selectScent(parfume.getScentId());
    }
}
