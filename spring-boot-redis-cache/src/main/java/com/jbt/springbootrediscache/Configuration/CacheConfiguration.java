package com.jbt.springbootrediscache.Configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CacheConfiguration {


    @Bean
    public KeyGenerator customKey(){
        return new CustomKeyGenerator();
    }

    @Bean
    RedisCacheConfiguration defaultRedisCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(30));
    }

    @Bean
    CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        Map<String, RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>();
        cacheConfigurationMap.put("person",
                RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(30)));
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory);
        return new RedisCacheManager(redisCacheWriter, defaultRedisCacheConfiguration(), cacheConfigurationMap);
    }
}