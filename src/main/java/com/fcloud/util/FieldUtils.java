package com.fcloud.util;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-11
 * Time: 下午4:28
 * To change this template use File | Settings | File Templates.
 */
public abstract class FieldUtils {

    public static boolean hasField(Object target, String fieldName, Class<?> type) {
        return ReflectionUtils.findField(target.getClass(), fieldName, type) == null;
    }

    public static Object getFieldValue(Object target, String fieldName) {
        Field field = ReflectionUtils.findField(target.getClass(), fieldName);
        ReflectionUtils.makeAccessible(field);
        return ReflectionUtils.getField(field, target);
    }

    public static void setFieldValue(Object target, String fieldName, Object value) {
        Field field = ReflectionUtils.findField(target.getClass(), fieldName);
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, target, value);
    }
}
