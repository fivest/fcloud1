package com.fcloud.core.metadata;

import java.util.List;

/**
 * Model元数据信息
 */
public interface ModelMetadata {

    Class<?> type();

    String table();

    PropertyMetadata idProperty();

    List<? extends PropertyMetadata> properties();
}
