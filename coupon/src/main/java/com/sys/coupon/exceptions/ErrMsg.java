package com.sys.coupon.exceptions;

import lombok.Getter;

@Getter
public enum ErrMsg {
    ALREADY_EXISTS("Item already exists in system so it cant be added!"),
    ID_NOT_FOUND("id not found..."),
    EMAIL_EXISTS("Email already exists in system..."),
    WRONG_INFO("wrong information entered!");
    private String msg;
    ErrMsg(String msg){this.msg=msg;}
}
