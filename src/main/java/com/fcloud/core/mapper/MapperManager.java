package com.fcloud.core.mapper;

import com.fcloud.core.model.Model;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.GenericTypeResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * Mapper管理器，实际主要是能方便通过model查找mapper
 */
public class MapperManager implements ApplicationListener<ContextRefreshedEvent> {

    protected Map<Class<?>, String> mappersMap = null;

    protected ApplicationContext applicationContext = null;

    @Override
    public synchronized void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        Map<Class<?>, String> mappers = new HashMap<Class<?>, String>();

        String[] names = context.getBeanNamesForType(Mapper.class);
        for (String name : names) {
            Class<?> mapperClass = context.getType(name);
            Class<?> modelClass = GenericTypeResolver.resolveTypeArgument(mapperClass, Mapper.class);
            mappers.put(modelClass, name);
        }

        applicationContext = context;
        mappersMap = mappers;
    }

    protected String getMapperBeanName(Class<? extends Model> modelClass) {
        return mappersMap.get(modelClass);
    }

    public<M extends Mapper> M getMapper(Class<? extends Model> modelClass) {
        return (M) applicationContext.getBean(getMapperBeanName(modelClass));
    }
}
