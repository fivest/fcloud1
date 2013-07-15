package com.fcloud.core.metadata.annotation;

/**
 * 属性注解
 */
public @interface PropertyMeta {

    String name() default "";

    String column() default "";

    Class<?> keyType() default String.class;

    boolean isId() default false;

    Class<?> elementType() default Object.class;
}
