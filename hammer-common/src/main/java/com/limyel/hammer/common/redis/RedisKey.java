package com.limyel.hammer.common.redis;

import java.util.Arrays;

public class RedisKey {

    /**
     * 验证码Key
     * @param uuid
     * @return
     */
    public static String getCaptchaKey(String uuid) {
        return "sys:captcha:" + uuid;
    }

    /**
     * 登录用户Key
     * @param key
     * @return
     */
    public static String getSecurityUserKey(String... key) {
        String join = String.join(":", key);
        return "sys:security:user:" + join;
    }

}
