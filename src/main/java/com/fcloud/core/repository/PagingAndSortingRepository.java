package com.fcloud.core.repository;

import com.fcloud.core.model.Page;
import com.fcloud.core.model.Pageable;
import com.fcloud.core.model.Sort;

/**
 * @author Ruben Fu
 */
public interface PagingAndSortingRepository<T> extends CrudRepository<T> {

    Iterable<T> findAll(Sort sort);

    Page<T> findAll(Pageable pageable);
}
