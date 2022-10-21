package com.limyel.hammer.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

    /**
     * 获取异常堆栈信息
     * @param throwable
     * @return
     */
    public static String getStackTrace(Throwable throwable) {
        StringWriter sw = new StringWriter();
        try (PrintWriter pw = new PrintWriter(sw)) {
            throwable.printStackTrace(pw);
            return sw.toString();
        }
    }

}
