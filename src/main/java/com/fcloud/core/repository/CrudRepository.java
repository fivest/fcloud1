package com.fcloud.core.repository;

/**
 * @author Ruben Fu
 */
public interface CrudRepository<T> extends Repository<T> {

    <S extends T> S save(S entity);

    <S extends T> Iterable<S> save(Iterable<S> entities);

    T findOne(String id);

    boolean exists(String id);

    Iterable<T> findAll();

    Iterable<T> findAll(Iterable<String> ids);

    long count();

    void delete(String id);

    void delete(T entity);

    void delete(Iterable<? extends T> entities);

    void deleteAll();
}
