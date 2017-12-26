package io.github.sskorol.assertions;

import io.github.sskorol.pages.LoginPage;
import io.github.sskorol.pages.ProductPage;

/**
 * A simple base class for Custom Assertions.
 */
public final class CustomAssertions {

    private CustomAssertions() {
        throw new UnsupportedOperationException("Illegal access to private constructor.");
    }

    public static LoginPageAssert customAssertThat(final LoginPage loginPage) {
        return new ModelSoftAssert().assertThat(LoginPageAssert.class, LoginPage.class, loginPage);
    }

    public static ProductPageAssert customAssertThat(final ProductPage productPage) {
        return new ModelSoftAssert().assertThat(ProductPageAssert.class, ProductPage.class, productPage);
    }
}
