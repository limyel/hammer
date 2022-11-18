package com.limyel.hammer.common.constant;

/**
 * todo 改成类
 *
 * @author limyel
 */

public enum OperationStatusConstant {
    // 成功
    SUCCESS(0),
    // 失败
    FAIL(1);

    private final int value;

    OperationStatusConstant(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
