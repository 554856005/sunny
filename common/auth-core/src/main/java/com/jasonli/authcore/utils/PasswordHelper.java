package com.jasonli.authcore.utils;

import lombok.Setter;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

/**
 * PasswordHelper
 *
 * @Description
 * @Author JasonLi
 * @Date 2019-04-17 0:06
 */

public class PasswordHelper {
    @Setter
    private int hashIterations = 2;
    @Setter
    private String algorithmName = "md5";
    @Setter
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

//    public void encryptPassword(User user) {
//        user.setSalt()
//    }
}
