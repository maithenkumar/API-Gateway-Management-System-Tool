package com.matheen.ratelimiting;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RateLimitingService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public boolean isRequestAllowed(String key, int limit, int periodInSeconds) {
        Long requests = redisTemplate.opsForValue().increment(key, 1);
        if (requests == 1) {
            redisTemplate.expire(key, periodInSeconds, TimeUnit.SECONDS);
        }
        return requests <= limit;
    }
}
