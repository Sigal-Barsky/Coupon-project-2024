package com.sys.coupon.controllers;

import com.sys.coupon.beans.Credentials;

abstract class ClientController {
    public boolean login(Credentials client) throws Exception{
        return false;
    }
}
