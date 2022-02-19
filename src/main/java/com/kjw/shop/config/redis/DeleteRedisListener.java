package com.kjw.shop.config.redis;

/**
 * @author jinwook.kim
 * @since 2022/02/02
 */

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author jinwook.kim
 * @since 2022/01/11
 */
@RequiredArgsConstructor
@Component
public class DeleteRedisListener implements MessageListener {

    private final RedisTemplate<String, Object> template;

    @Override
    public void onMessage(Message message, byte[] bytes) {
        // redis에서 expire 이벤트 수신 시 대상 키값 조회
        final RedisSerializer<?> keySerializer = template.getKeySerializer();
        final String key = (String) keySerializer.deserialize(message.getBody());
        System.out.println("onMessage key = " + key);


        if (key.contains(RedisKeyTypes.LOGIN.getValue())) {
            System.out.println("key = " + key);
        }
    }
}

