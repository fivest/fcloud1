package com.fcloud.core.metadata.support;

import com.fcloud.core.metadata.ModelMetadata;
import com.fcloud.core.model.Model;

/**
 * 元数据创建工厂
 */
public class MetadataFactory {

    public <M extends ModelMetadata> M getMetadata(Class<?> clz) {
        return null;
    }

    public <M extends ModelMetadata> M getMetadata(Model model) {
        return null;
    }
}
