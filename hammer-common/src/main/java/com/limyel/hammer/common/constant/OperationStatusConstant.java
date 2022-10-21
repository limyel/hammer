package com.limyel.hammer.common.constant;

public enum OperationStatusConstant {
    SUCCESS(0),
    FAIL(1);

    private int value;

    OperationStatusConstant(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
