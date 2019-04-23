package com.jasonli.authcore.utils;

/***
 * Consts
 *
 * @Description
 * @Author JasonLi
 * @Date 2019-04-24 1:32
 */
public final class Consts {
    public static final String LOGIN_SALT = "sunny-web-bp";
    /**
     * request请求头属性
     */
    public static final String REQUEST_AUTH_HEADER = "Authorization";

    /**
     * JWT-account
     */
    public static final String ACCOUNT = "account";

    /**
     * Shiro redis 前缀
     */
    public static final String PREFIX_SHIRO_CACHE = "sunny-web-bp:cache:";

    /**
     * redis-key-前缀-shiro:refresh_token
     */
    public final static String PREFIX_SHIRO_REFRESH_TOKEN = "sunny-web-bp:refresh_token:";

    /**
     * JWT-currentTimeMillis
     */
    public final static String CURRENT_TIME_MILLIS = "currentTimeMillis";
}
