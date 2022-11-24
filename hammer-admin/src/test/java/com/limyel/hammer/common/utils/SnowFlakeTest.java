package com.limyel.hammer.common.utils;

import com.limyel.hammer.AdminApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AdminApplication.class)
public class SnowFlakeTest {

    @Autowired
    private SnowFlake snowFlake;

    @Test
    public void testNextId() {
        String id = snowFlake.nextId();
        Assertions.assertNotNull(id);
    }

}
