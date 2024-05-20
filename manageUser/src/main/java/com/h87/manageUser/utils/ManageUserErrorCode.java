package com.h87.manageUser.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ManageUserErrorCode {
    USER_NOT_FOUND("User Not Found"),
    INTERNAL_SERVER_ERROR("An unexpected error occurred. Please try again later or contact support if the problem persists.");
    private final String value;
}
