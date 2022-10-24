package com.limyel.hammer.common.redis;

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
     * @param id
     * @return
     */
    public static String getSecurityUserKey(Long id) {
        return "sys:security:user:" + id;
    }

}
