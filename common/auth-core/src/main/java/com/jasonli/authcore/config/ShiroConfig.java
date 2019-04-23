package com.jasonli.authcore.config;

import com.jasonli.authcore.shiro.JWTRealm;
import com.jasonli.authcore.shiro.ShiroCacheManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * ShiroConfig
 *
 * @Description
 * @Author JasonLi
 * @Date 2019-04-24 0:12
 */
@Configuration
public class ShiroConfig {
    @Bean
    public JWTRealm jwtRealm() {
        return new JWTRealm();
    }

    @Bean
    public ShiroCacheManager cacheManager() {
        return new ShiroCacheManager();
    }

    /**
     * Shiro Bean生命周期处理器
     *
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public static DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        /**
         *  静态代理是通过在代码中显式定义一个业务实现类一个代理，
         *  在代理类中对同名的业务方法进行包装，用户通过代理类调用被包装过的业务方法；
         *
         *  JDK动态代理（实现InvocationHandler接口）是通过接口中的方法名，在动态生成的代理类中调用业务实现类的同名方法；
         *
         *  CGlib动态代理（ 实现MethodInterceptor接口）是通过继承业务类，生成的动态代理类是业务类的子类，通过重写业务方法进行代理；
         *
         * true以cglib动态代理方式生成代理类，设置为false，就是用JDK动态代理技术
         */
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }


    /**
     * 通知器
     * 使shiro认证注解
     * （@RequiresPermissions、@RequiresRoles、@RequiresUser、@RequiresGuest）生效。
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }


    @Bean
    public DefaultWebSecurityManager securityManager(JWTRealm jwtRealm, ShiroCacheManager cacheManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();

        securityManager.setRealm(jwtRealm);
        //关闭默认session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator sessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        sessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(sessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        //自定义缓存管理
        securityManager.setCacheManager(cacheManager);
        return securityManager;
    }
}
