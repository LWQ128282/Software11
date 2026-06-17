package com.tabletennis.util;

public class PasswordUtil {
    public static boolean checkPwd(String inputPwd, String realPwd) {
        if (inputPwd == null || realPwd == null) {
            return false;
        }
        return inputPwd.equals(realPwd);
    }
}