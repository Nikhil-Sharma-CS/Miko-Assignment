package org.example.Miko.Assignment.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // Store a string value in Redis
    public void setValue(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    // Retrieve a string value from Redis
    public String getValue(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    // Update a string value in Redis
    public String updateValue(String key, String newValue) {
        if (Boolean.TRUE.equals(stringRedisTemplate.hasKey(key))) {
            int valueToAdd = 0;
            if (!Character.isDigit(newValue.charAt(0))) {
                newValue = getValue(newValue);
            }
            valueToAdd = Integer.parseInt(newValue);
            valueToAdd = Integer.parseInt(getValue(key)) + valueToAdd;

            stringRedisTemplate.opsForValue().set(key, Integer.toString(valueToAdd));
        } else {
            return "Value not available";
        }
        return "Value Updated";
    }

    // Delete a key from Redis
    public String deleteKey(String key) {
        stringRedisTemplate.delete(key);
        return "Value Deleted";
    }
}

