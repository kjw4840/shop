package com.kjw.shop.config.redis.service;

import com.kjw.shop.member.model.Member;

/**
 * @author jinwook.kim
 * @since 2022/02/02
 */
public interface RedisService {
    Object get(Member member);

    void put(String data, Member member);
}
