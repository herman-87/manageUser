package com.h87.manageUser.domain.users;

import com.h87.manageUser.utils.ManageUserErrorCode;

public class RoleNotFoundException extends Throwable {
    public RoleNotFoundException(ManageUserErrorCode errorCode) {
        super(errorCode.getValue());
    }
}
