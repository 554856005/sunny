package com.jasonli.authcore.shiro;

import com.jasonli.authcore.utils.CacheClient;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ShiroCacheManager
 *
 * @Description
 * @Author JasonLi
 * @Date 2019-04-24 1:02
 */
@Service
public class ShiroCacheManager implements CacheManager {
    @Autowired
    CacheClient cacheClient;
    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return null;
    }
}
