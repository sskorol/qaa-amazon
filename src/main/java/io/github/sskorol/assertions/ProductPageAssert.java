package io.github.sskorol.assertions;

import io.github.sskorol.model.Product;
import io.qameta.allure.Step;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * A simple model class for Product Page assert processing.
 */

public class ProductPageAssert extends AbstractAssert<ProductPageAssert, Product> {

    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of: \n<%s>\nto be: <%s>\nbut was: <%s>\n";

    public ProductPageAssert(final Product product) {
        super(product, ProductPageAssert.class);
    }

    @Step("Verify the \"{purchaseStatus}\".")
    public ProductPageAssert hasPurchaseStatus(final String purchaseStatus) {
        isNotNull();

        final String status = actual.getPurchaseStatus();

        if (!Objects.areEqual(status, purchaseStatus)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Status name", actual, purchaseStatus, status);
        }
        return this;
    }
}
