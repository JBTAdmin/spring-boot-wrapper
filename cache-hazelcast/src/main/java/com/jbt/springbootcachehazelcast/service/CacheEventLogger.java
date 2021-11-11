package com.jbt.springbootcachehazelcast.service;

import com.hazelcast.cache.impl.CacheEventListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheEventLogger implements CacheEventListener {

  @Override
  public void handleEvent(Object eventObject) {
    System.out.println("Inside handle EVENT");
  }
}
