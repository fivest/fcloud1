package com.fcloud.core.repository.support;

import com.fcloud.core.repository.PagingAndSortingRepository;
import com.fcloud.core.repository.SingleModelRepository;
import com.j256.ormlite.dao.Dao;

/**
 * @author Ruben Fu
 */
public interface OrmliteRepository<T> extends PagingAndSortingRepository<T>, SingleModelRepository<T> {

    Dao<T, String> getDao();

    Dao<T, String> lookupDao(Class<T> modelType);
}
