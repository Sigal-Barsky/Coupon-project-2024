package com.sys.coupon.exceptions;

public class CouponSysExp extends Exception{
    public CouponSysExp(ErrMsg errMsg){super(errMsg.getMsg());}
}
