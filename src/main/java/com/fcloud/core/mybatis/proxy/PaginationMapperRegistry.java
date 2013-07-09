package com.fcloud.core.mybatis.proxy;

import com.fcloud.util.FieldUtils;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.builder.annotation.MapperAnnotationBuilder;
import org.apache.ibatis.session.Configuration;

import java.util.Map;

/**
 * 分页mapper注册器
 */
public class PaginationMapperRegistry extends MapperRegistry {


    private final Configuration paginationConfig;

    private final Map<Class<?>, MapperProxyFactory<?>> paginationMappers;

    public PaginationMapperRegistry(Configuration config) {
        super(config);
        this.paginationConfig = config;
        this.paginationMappers = (Map<Class<?>, MapperProxyFactory<?>>) FieldUtils.getFieldValue(this, "knownMappers");
    }

    public <T> void addMapper(Class<T> type) {
        if (type.isInterface()) {
            if (hasMapper(type)) {
                throw new BindingException("Type " + type + " is already known to the MapperRegistry.");
            }
            boolean loadCompleted = false;
            try {
                paginationMappers.put(type, new PaginationMapperProxyFactory<T>(type));
                MapperAnnotationBuilder parser = new MapperAnnotationBuilder(paginationConfig, type);
                parser.parse();
                loadCompleted = true;
            } finally {
                if (!loadCompleted) {
                    paginationMappers.remove(type);
                }
            }
        }
    }
}
