package com.fcloud.core.repository;

/**
 * @author Ruben Fu
 */
public interface SingleModelRepository<T> extends Repository<T> {

    public Class<T> getModelClass();
}
