package org.prod.tgbotsvetlyachok.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, String> redisTemplate;

    public void saveData(String key, String value) {
        redisTemplate.opsForValue().set(String.valueOf(key), value);
    }

    public String getData(String key) {
        return redisTemplate.opsForValue().get(String.valueOf(key));
    }

    public void deleteData(Long key) {
        redisTemplate.delete(String.valueOf(key));
    }
}
