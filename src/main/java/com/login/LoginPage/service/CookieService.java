package com.login.LoginPage.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {
    public static void setCookie(HttpServletResponse response, String key, String valor, int seconds) throws IOException {
        Cookie cookie = new Cookie(key, URLEncoder.encode(valor, "UTF-8"));
        cookie.setHttpOnly(true);
        cookie.setMaxAge(seconds);
        response.addCookie(cookie);
    }
    public static String getCookie(HttpServletRequest request, String key) throws UnsupportedEncodingException {
        String valor = Optional.ofNullable(request.getCookies())
            .flatMap(cookies -> Arrays.stream(cookies)
                .filter(cookie -> key.equals(cookie.getName()))
                .findAny())
            .map(e -> e.getValue())
            .orElse(null);

            valor = URLDecoder.decode(valor, "utf-8");
            return valor;
    }
}
