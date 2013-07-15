package com.fcloud.util;

import java.util.UUID;

/**
 * ID生成
 */
public abstract class IDGenerator {

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String newid() {
        long time = System.currentTimeMillis();
        String id = Long.toHexString(time) + uuid();
        return id.replaceAll("-", "").substring(0, 32);
    }
}
