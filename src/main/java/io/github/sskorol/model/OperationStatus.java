package io.github.sskorol.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for purchase and login statuses.
 */

@Getter
@RequiredArgsConstructor
public enum OperationStatus {

    PURCHASE_SUCCESSFUL("Operation was successfully completed"),
    PURCHASE_FAILED("It is impossible to complete purchase operation"),
    LOGIN_SUCCESSFUL("Authorized successfully"),
    LOGIN_FAILED("Cannot find an account with such credentials");

    private final String name;
}
