package io.github.sskorol.assertions;

import io.github.sskorol.model.PurchaseStatus;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * A simple model class for Purchase Status assert processing.
 */
public class PurchaseStatusAssert extends AbstractAssert<PurchaseStatusAssert, PurchaseStatus> {
    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of: \n<%s>\nto be: <%s>\nbut was: <%s>\n";

    public PurchaseStatusAssert(final PurchaseStatus purchaseStatus) {
        super(purchaseStatus, PurchaseStatusAssert.class);
    }

    @Step("Verify that the purchase status is equal to \"{purchaseStatus}\".")

    public PurchaseStatusAssert hasPurchaseStatus(final String purchaseStatus) {
        isNotNull();

        final String status = actual.getStatus();

        if (!Objects.areEqual(status, purchaseStatus)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Status name", actual, purchaseStatus, status);
        }
        return this;
    }
}
