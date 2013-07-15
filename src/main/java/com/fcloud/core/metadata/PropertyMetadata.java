package com.fcloud.core.metadata;

/**
 * 属性元数据信息
 */
public interface PropertyMetadata {

    String name();

    Class<?> type();

    Class<?> keyType();

    Class<?> elementType();

    boolean isNullable();

    boolean isCollection();

    boolean isMap();

    String column();

    String relTable();

    String keyColumn();

    boolean isId();
}
