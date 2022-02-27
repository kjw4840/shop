package com.kjw.shop;

import com.kjw.shop.member.dto.MemberDto;
import com.kjw.shop.member.mapper.MemberMapper;
import com.kjw.shop.member.model.Member;
import com.kjw.shop.member.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class ShopApplicationTests {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Autowired
    MemberRepository repository;

    @Test
    void redisConnectionTest() {
        final String key = "a";
        final String data = "1";

        final ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key, data);

        final String s = valueOperations.get(key);
        System.out.println("s = " + s);
        Assertions.assertThat(s).isEqualTo(data);
    }

    @Test
    public void mapperTest() throws Exception {

        Member member = repository.findById(1L).get();

        MemberDto memberDto = MemberMapper.INSTANCE.toDto(member);

        System.out.println(memberDto);
    }
}
