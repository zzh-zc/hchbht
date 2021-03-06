package com.hchbht.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Redis工具类
 * 
 * @author Administrator
 * 
 */
@Service
public class RedisUtils {

	@Autowired
	public RedisTemplate<String, String> redisTemplate;

	public String rightPop(String key) {
		return redisTemplate.boundListOps(key).rightPop();
	}

	public String rightPop(String key, long timeout, TimeUnit timeUnit) {
		return redisTemplate.boundListOps(key).rightPop(timeout, timeUnit);
	}
}
