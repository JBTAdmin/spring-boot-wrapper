// package com.jbt.springbootcachehazelcast.service;
//
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// import javax.cache.Cache;
// import javax.cache.CacheManager;
// import javax.cache.Caching;
// import javax.cache.configuration.MutableConfiguration;
// import javax.cache.expiry.AccessedExpiryPolicy;
// import javax.cache.spi.CachingProvider;
// import javax.cache.expiry.Duration;
//
// @Configuration
// public class JCacheImplement {
//
//    @Bean
//    CachingProvider getCachingProvider(){
//        CachingProvider cachingProvider = Caching.getCachingProvider();
//        CacheManager cacheManager = cachingProvider.getCacheManager();
//        MutableConfiguration<String, Object> mutableConfiguration =
//                new MutableConfiguration<String, Object>()
//                .setTypes(String.class,Object.class)
//                .setExpiryPolicyFactory(AccessedExpiryPolicy.factoryOf(Duration.ONE_MINUTE));
//        Cache cache = cacheManager.createCache("test", mutableConfiguration);
//        cache.put();
//        return
//    }
// }
