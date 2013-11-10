package com.fcloud.core.controller;

import com.fcloud.core.repository.PagingAndSortingRepository;
import org.springframework.core.GenericTypeResolver;

/**
 * @author Ruben Fu
 */
public class SingleModelController<T, R extends PagingAndSortingRepository<T>>
        extends BaseController<T, R> {

    protected R repository;

    protected R getRepository() {
        if (repository == null) {
            repository = repositories.lookup(modelClass);
        }
        return repository;
    }

    protected final Class<T> modelClass;

    @SuppressWarnings("unchecked")
    public SingleModelController() {
        this.modelClass = (Class<T>) GenericTypeResolver.resolveTypeArguments(getClass(), SingleModelController.class)[0];
    }

    protected T createModel() {
        try {
            return modelClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Unable to instance model by class '" + modelClass + "'", e);
        }
    }
}
