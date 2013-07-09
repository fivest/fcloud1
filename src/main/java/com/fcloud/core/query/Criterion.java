package com.fcloud.core.query;

/**
 * 动态查询具体条件
 */
public class Criterion {

    private final String name;

    private final Object value;

    private final String op;

    public Criterion(String name, Object value, String op) {
        this.name = name;
        this.value = value;
        this.op = op;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

    public String getOp() {
        return op;
    }
}
