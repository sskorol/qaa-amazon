package io.github.sskorol.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Enum for login status.
 */
@Getter
@RequiredArgsConstructor
public enum LoginStatus {

    SUCCESS("Authorized successfully"),
    FAIL("Cannot find an account with such credentials");

    private final String loginStatus;
}
