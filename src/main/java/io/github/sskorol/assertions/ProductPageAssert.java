package io.github.sskorol.assertions;

import io.github.sskorol.pages.ProductPage;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * A simple model class for Product Page assert processing.
 */

public class ProductPageAssert extends AbstractAssert<ProductPageAssert, ProductPage> {

    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of: \n<%s>\nto be: <%s>\nbut was: <%s>\n";

    public ProductPageAssert(final ProductPage actual) {
        super(actual, ProductPageAssert.class);
    }

    @Step("Verify that the login status is equal to \"{status}\".")
    public ProductPageAssert hasPurchaseStatus(final String status) {
        isNotNull();

        final String purchaseStatus = actual.getPurchaseStatus();

        if (!Objects.areEqual(purchaseStatus, status)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Status name", actual, purchaseStatus);
        }
        return this;
    }
}
