package io.github.sskorol.assertions;

import io.github.sskorol.model.Account;
import io.github.sskorol.model.Product;

/**
 * A simple base class for Custom Assertions.
 */

public final class CustomAssertions {

    private CustomAssertions() {
        throw new UnsupportedOperationException("Illegal access to private constructor.");
    }

    public static LoginPageAssert customAssertThat(final Account account) {
        return new ModelSoftAssert().assertThat(LoginPageAssert.class, Account.class, account);
    }

    public static ProductPageAssert customAssertThat(final Product product) {
        return new ModelSoftAssert().assertThat(ProductPageAssert.class, Product.class, product);
    }
}
