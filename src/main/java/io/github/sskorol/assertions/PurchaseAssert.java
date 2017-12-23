package io.github.sskorol.assertions;

import io.github.sskorol.pages.ProductPage;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * A simple model class for Purchase Status assert processing.
 */

public class PurchaseAssert extends AbstractAssert<PurchaseAssert, ProductPage> {

    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of: \n<%s>\nto be: <%s>\nbut was: <%s>\n";

    public PurchaseAssert(final ProductPage actual) {
        super(actual, PurchaseAssert.class);
    }

    @Step("Verify that the login status is equal to \"{status}\".")
    public PurchaseAssert hasPurchaseStatus(final String status) {
        isNotNull();

        final String purchaseStatus = actual.getPurchaseStatus();

        if (!Objects.areEqual(purchaseStatus, status)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Status name", actual, purchaseStatus);
        }
        return this;
    }
}
