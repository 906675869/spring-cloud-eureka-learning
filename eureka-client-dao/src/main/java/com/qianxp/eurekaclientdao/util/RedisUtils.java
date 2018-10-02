package com.qianxp.eurekaclientdao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String,String> redisTemplate ;

    public RedisTemplate<String,String> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String,String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * Set {@code value} for {@code key}.
     *
     * @param key   must not be {@literal null}.
     * @param value
     * @see <a href="http://redis.io/commands/set">Redis Documentation: SET</a>
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * Set the {@code value} and expiration {@code timeout} for {@code key}.
     *
     * @param key     must not be {@literal null}.
     * @param value
     * @param timeout
     * @param unit    must not be {@literal null}.
     * @see <a href="http://redis.io/commands/setex">Redis Documentation: SETEX</a>
     */
    public void set(String key, String value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * Set {@code key} to hold the string {@code value} if {@code key} is absent.
     *
     * @param key   must not be {@literal null}.
     * @param value
     * @return {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/setnx">Redis Documentation: SETNX</a>
     */
    @Nullable
    public Boolean setIfAbsent(String key, String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * Set multiple keys to multiple values using key-value pairs provided in {@code tuple}.
     *
     * @param map must not be {@literal null}.
     * @see <a href="http://redis.io/commands/mset">Redis Documentation: MSET</a>
     */
    public void multiSet(Map map) {
        redisTemplate.opsForValue().multiSet(map);
    }

    /**
     * Set multiple keys to multiple values using key-value pairs provided in {@code tuple} only if the provided key does
     * not exist.
     *
     * @param map       must not be {@literal null}.
     * @param {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/mset">Redis Documentation: MSET</a>
     */
    @Nullable
    public Boolean multiSetIfAbsent(Map map) {
        return redisTemplate.opsForValue().multiSetIfAbsent(map);
    }

    /**
     * Get the value of {@code key}.
     *
     * @param key must not be {@literal null}.
     * @return {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/get">Redis Documentation: GET</a>
     */
    @Nullable
    public String get(Object key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * Set {@code value} of {@code key} and return its old value.
     *
     * @param key must not be {@literal null}.
     * @return {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/getset">Redis Documentation: GETSET</a>
     */
    @Nullable
    public String getAndSet(String key, String value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    /**
     * Get multiple {@code keys}. Values are returned in the order of the requested keys.
     *
     * @param keys must not be {@literal null}.
     * @return {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/mget">Redis Documentation: MGET</a>
     */
    @Nullable
    public List<String> multiGet(Collection<String> keys) {
        return redisTemplate.opsForValue().multiGet(keys);
    }

    /**
     * Increment an integer value stored as string value under {@code key} by {@code delta}.
     *
     * @param key   must not be {@literal null}.
     * @param delta
     * @return {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/incr">Redis Documentation: INCR</a>
     */
    @Nullable
    public Long increment(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * Increment a floating point number value stored as string value under {@code key} by {@code delta}.
     *
     * @param key   must not be {@literal null}.
     * @param delta
     * @return {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/incrbyfloat">Redis Documentation: INCRBYFLOAT</a>
     */
    @Nullable
    public Double increment(String key, double delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * Append a {@code value} to {@code key}.
     *
     * @param key   must not be {@literal null}.
     * @param value
     * @return {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/append">Redis Documentation: APPEND</a>
     */
    @Nullable
    public Integer append(String key, String value) {
        return redisTemplate.opsForValue().append(key, value);
    }

    /**
     * Get a substring of value of {@code key} between {@code begin} and {@code end}.
     *
     * @param key   must not be {@literal null}.
     * @param start
     * @param end
     * @return {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/getrange">Redis Documentation: GETRANGE</a>
     */
    @Nullable
    public String get(String key, long start, long end) {
        return redisTemplate.opsForValue().get(key, start, end);
    }

    /**
     * Overwrite parts of {@code key} starting at the specified {@code offset} with given {@code value}.
     *
     * @param key    must not be {@literal null}.
     * @param value
     * @param offset
     * @see <a href="http://redis.io/commands/setrange">Redis Documentation: SETRANGE</a>
     */
    public void set(String key, String value, long offset) {
        redisTemplate.opsForValue().set(key, value, offset);
    }

    /**
     * Get the length of the value stored at {@code key}.
     *
     * @param key must not be {@literal null}.
     * @return {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/strlen">Redis Documentation: STRLEN</a>
     */
    @Nullable
    public Long size(String key) {
        return redisTemplate.opsForValue().size(key);
    }

    /**
     * Sets the bit at {@code offset} in value stored at {@code key}.
     *
     * @param key    must not be {@literal null}.
     * @param offset
     * @param value
     * @return {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/setbit">Redis Documentation: SETBIT</a>
     * @since 1.5
     */
    @Nullable
    public Boolean setBit(String key, long offset, boolean value) {
        return redisTemplate.opsForValue().setBit(key, offset, value);
    }

    /**
     * Get the bit value at {@code offset} of value at {@code key}.
     *
     * @param key    must not be {@literal null}.
     * @param offset
     * @return {@literal null} when used in pipeline / transaction.
     * @see <a href="http://redis.io/commands/setbit">Redis Documentation: GETBIT</a>
     * @since 1.5
     */
    @Nullable
    public Boolean getBit(String key, long offset) {
        return redisTemplate.opsForValue().getBit(key, offset);
    }

    public RedisOperations<String,String> getOperations() {
        return redisTemplate.opsForValue().getOperations();
    }
}
