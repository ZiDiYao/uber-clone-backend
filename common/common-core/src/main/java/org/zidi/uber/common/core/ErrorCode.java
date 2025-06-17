package org.zidi.uber.common.core;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    SUCCESS(200, "Success"),
    UNAUTHORIZED(401, "Unauthorized"),
    LOGIN_FAILED(1001, "Login failed"),
    TOKEN_INVALID(1002, "Invalid token"),
    USER_NOT_FOUND(1003, "User not found"),
    SERVER_ERROR(500, "Internal server error");

    private final int code;
    private final String message;
}
