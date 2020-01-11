package com.jbt.springbootrediscache.Configuration;

import com.jbt.springbootrediscache.model.Person;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;

import java.lang.reflect.Method;

public class CustomKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {

        if(params.length == 0){
            return "all";
        }
        Object param = params[0];
        if (param != null && param instanceof Person) {
            return ((Person) param).getId();
        }

        return SimpleKey.EMPTY;
    }
}
