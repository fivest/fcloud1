package com.fcloud.core.mapper;

import com.fcloud.core.model.Model;
import com.fcloud.core.page.Pagination;

import java.util.List;

/**
 * CRUD操作Mappger
 */
public interface CrudMapper<T extends Model> extends Mapper<T> {

    public void insert(T model);

    public void update(T model);

    public T find(String id);

    public void delete(String id);

    public List<T> findAll();

    public Pagination<T> findAllByPage(Pagination<T> page);
}
