package com.tabletennis.service;

import com.tabletennis.entity.Admin;
import com.tabletennis.util.PasswordUtil;

public class LoginService {
    public boolean login(Admin admin, String inputPwd) {
        String realPwd = admin.getPassword();
        return PasswordUtil.checkPwd(inputPwd, realPwd);
    }
}