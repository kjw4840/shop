package com.kjw.shop.config.redis.service;

import com.kjw.shop.config.redis.RedisKeyTypes;
import com.kjw.shop.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author jinwook.kim
 * @since 2022/02/02
 */
@Service
@RequiredArgsConstructor
public class RedisServiceImpl implements RedisService{

    private final RedisTemplate<String, Object> template;


    @Override
    public Object get(Member member) {
        String key = RedisKeyTypes.LOGIN.getValue() + member.getId();
        return template.opsForValue().get(key);
    }

    @Override
    public void put(String data, Member member) {
        String key = RedisKeyTypes.LOGIN.getValue() + member.getId();
        template.opsForValue().set(key, data, 3, TimeUnit.MINUTES);
    }
}
