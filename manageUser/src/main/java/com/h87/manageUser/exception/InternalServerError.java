package com.h87.manageUser.exception;

import com.h87.manageUser.utils.ManageUserErrorCode;

public class InternalServerError extends Throwable {
    public InternalServerError(ManageUserErrorCode errorCode) {
        super(errorCode.getValue());
    }
}
