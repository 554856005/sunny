package com.jasonli.authcore.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * JWTToken
 *
 * @Description
 * @Author JasonLi
 * @Date 2019-04-24 0:56
 */
public class JWTToken implements AuthenticationToken {
    /**
     * 密钥
     */
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return this.token;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }
}
