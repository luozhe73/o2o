package com.cvicse.o2o.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {

    public static boolean checkVerifyCode(HttpServletRequest request) {
        String vertifyCodeExpected = (String) request.getSession().getAttribute(
                Constants.KAPTCHA_SESSION_KEY
        );
        String vertifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
        if (vertifyCodeActual == null || !vertifyCodeActual.equalsIgnoreCase(vertifyCodeExpected))
            return false;
        return true;
    }
}
