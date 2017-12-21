package io.github.sskorol.assertions;

import io.github.sskorol.model.LoginStatus;
import io.github.sskorol.model.PurchaseStatus;

/**
 * A simple base class for Custom Assertions.
 */

public final class CustomAssertions {

    private CustomAssertions() {
        throw new UnsupportedOperationException("Illegal access to private constructor.");
    }

    public static LoginStatusAssert customAssertThat(final LoginStatus loginStatus) {
        return new ModelSoftAssert().assertThat(LoginStatusAssert.class, LoginStatus.class, loginStatus);
    }

    public static PurchaseStatusAssert customAssertThat(final PurchaseStatus purchaseStatus) {
        return new ModelSoftAssert().assertThat(PurchaseStatusAssert.class, PurchaseStatus.class, purchaseStatus);
    }
}
