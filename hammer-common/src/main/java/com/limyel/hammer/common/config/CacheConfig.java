package com.limyel.hammer.common.config;

import com.limyel.hammer.common.redis.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import javax.crypto.KeyGenerator;
import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfig {

    private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer;
    @Autowired
    public void setJackson2JsonRedisSerializer(Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer) {
        this.jackson2JsonRedisSerializer = jackson2JsonRedisSerializer;
    }

    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(180))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                // 不缓存空值
                .disableCachingNullValues();
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(cacheConfiguration)
                .transactionAware()
                .build();
    }

//    @Bean
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//
//        }
//    }
}
