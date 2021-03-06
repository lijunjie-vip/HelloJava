package com.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @SuppressWarnings("all")
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> strValOps;

    public long incr(String key) {
        Long ret = strValOps.increment(key, 1L);
        return ret == null ? 0 : ret;
    }

    public boolean expire(String key, long seconds) {
        Boolean ret = stringRedisTemplate.expire(key, seconds, TimeUnit.SECONDS);
        return ret == null ? false : ret;
    }
}
