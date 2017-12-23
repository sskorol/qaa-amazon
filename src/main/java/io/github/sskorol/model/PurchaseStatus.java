package io.github.sskorol.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for purchase status.
 */

@Getter
@RequiredArgsConstructor
public enum PurchaseStatus {

    SUCCESSFUL("Operation was successfully completed"),
    FAILED("It is impossible to complete purchase operation");

    private final String purchaseStatus;
}
