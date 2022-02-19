package com.kjw.shop.config.redis;

/**
 * @author jinwook.kim
 * @since 2022/02/02
 */

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * @author jinwook.kim
 * @since 2022/01/11
 */
@Component
public class ExpireRedisListener extends KeyExpirationEventMessageListener {


    public ExpireRedisListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        // redis에서 expire 이벤트 수신 시 대상 키값 조회

        String key = message.toString().toUpperCase();

        if (key.contains(RedisKeyTypes.LOGIN.getValue())) {
            System.out.println("key = " + message.toString());
        }
    }
}

