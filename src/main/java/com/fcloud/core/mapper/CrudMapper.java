package com.fcloud.core.mapper;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-16
 * Time: 下午8:39
 * To change this template use File | Settings | File Templates.
 */
public interface CrudMapper<T> {

    public void insert(T model);

    public void update(T model);

    public T find(String id);

    public void delete(String id);
}
