package com.h87.manageUser.exception;

import com.h87.manageUser.utils.ManageUserErrorCode;

public class ResourcesNotFoundException extends Throwable {
    public ResourcesNotFoundException(ManageUserErrorCode errorCode) {
        super(errorCode.getValue());
    }
}
