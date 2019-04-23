package com.jasonli.authcore.shiro;

import com.jasonli.authcore.utils.CacheClient;
import com.jasonli.authcore.utils.Consts;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

import java.util.Collection;
import java.util.Set;

/**
 * ShiroCache
 *
 * @Description
 * @Author JasonLi
 * @Date 2019-04-24 1:28
 */
public class ShiroCache<K, V> implements Cache<K, V> {
    CacheClient cacheClient;

    public ShiroCache(CacheClient cacheClient) {
        this.cacheClient = cacheClient;
    }

    private String getKey(Object key) {
        return String.format("%s%s%s", Consts.PREFIX_SHIRO_CACHE);

    }

    @Override
    public V get(K k) throws CacheException {
        String tempKey = this.getKey(k);
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        return null;
    }

    @Override
    public V remove(K k) throws CacheException {
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<K> keys() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }
}
