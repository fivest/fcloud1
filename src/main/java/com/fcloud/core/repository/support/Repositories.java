package com.fcloud.core.repository.support;

import com.fcloud.core.repository.Repository;
import com.fcloud.core.repository.SingleModelRepository;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruben Fu
 */
@Component
public class Repositories {

    private final Map<Class<?>, Repository<?>> repositories = new HashMap<Class<?>, Repository<?>>();

    private ListableBeanFactory factory;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public Repositories(ListableBeanFactory factory) {
        this.factory = factory;
    }

    @SuppressWarnings("unchecked")
    public <R extends Repository<?>> R lookup(Class<?> clz) {
        return (R) repositories.get(clz);
    }

    @PostConstruct
    public void refresh() {
        Map<String, Object> rps = factory.getBeansWithAnnotation(org.springframework.stereotype.Repository.class);
        for (Map.Entry<String, Object> entry : rps.entrySet()) {
            Repository<?> rp = (Repository<?>) entry.getValue();
            Class<?> clz = null;
            if (rp instanceof SingleModelRepository) {
                clz = ((SingleModelRepository) rp).getModelClass();
            }
            else {
                clz = GenericTypeResolver.resolveTypeArgument(rp.getClass(), Repository.class);
            }
            repositories.put(clz, rp);
        }
    }
}
