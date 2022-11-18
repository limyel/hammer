package com.limyel.hammer.common.redis;

/**
 * @author limyel
 */
public class RedisKey {

    /**
     * 验证码Key
     * @param uuid key
     * @return value
     */
    public static String getCaptchaKey(String uuid) {
        return "sys:captcha:" + uuid;
    }

    /**
     * 登录用户Key
     * @param key key
     * @return value
     */
    public static String getSecurityUserKey(String... key) {
        String join = String.join(":", key);
        return "sys:security:user:" + join;
    }

}
