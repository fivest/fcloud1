package com.fcloud.util;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-16
 * Time: 下午8:01
 * To change this template use File | Settings | File Templates.
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
