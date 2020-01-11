package com.jbt.springbootrediscache.controller;

import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clear/cache")
public class CacheController {

    public CacheController(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    CacheManager cacheManager;

    @GetMapping
    public void clearAllCache(){
        cacheManager.getCacheNames().stream().forEach(name -> cacheManager.getCache(name).invalidate());
    }

    @GetMapping("/{cacheName}")
    public void clearCache(@PathVariable String cacheName){
        cacheManager.getCache(cacheName).invalidate();
    }
}