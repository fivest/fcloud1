package com.fcloud.core.repository.support;

import com.fcloud.core.model.Page;
import com.fcloud.core.model.PageImpl;
import com.fcloud.core.model.Pageable;
import com.fcloud.core.model.Sort;
import com.fcloud.core.repository.SingleModelRepository;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Ruben Fu
 */
public class SimpleRepository<T> implements OrmliteRepository<T>, SingleModelRepository<T> {

    protected final Class<T> modelClass;

    @Override
    public Class<T> getModelClass() {
        return modelClass;
    }

    public SimpleRepository() {
        //this.modelClass = modelClass;
        this.modelClass = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), SimpleRepository.class);
    }

    protected ConnectionSource connectionSource;

    @Autowired
    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    protected Dao<T, String> dao;

    public Dao<T, String> getDao() {
        if (dao == null) {
            dao = lookupDao(modelClass);
        }
        return dao;
    }

    protected RuntimeException wrapException(Exception ex) {
        if (ex instanceof RuntimeException) {
            return (RuntimeException) ex;
        }
        return new RuntimeException(ex);
    }

    protected Page<T> readPage(QueryBuilder<T, String> queryBuilder, Pageable pageable) {
        try {
            Long total = queryBuilder.countOf();
            queryBuilder.setCountOf(false);

            queryBuilder.offset((long) pageable.getOffset());
            queryBuilder.limit((long) pageable.getPageSize());
            Sort sort = pageable.getSort();
            if (sort != null) {
                for (Sort.Order order : sort) {
                    queryBuilder.orderBy(order.getProperty(), order.isAscending());
                }
            }
            List<T> list = queryBuilder.query();
            return new PageImpl<T>(list, pageable, total);
        } catch (SQLException e) {
            throw wrapException(e);
        }
    }

    @Override
    public Dao<T, String> lookupDao(Class<T> modelType) {
        try {
            return DaoManager.createDao(connectionSource, modelType);
        } catch (SQLException e) {
            throw new RuntimeException("unable look up dao by class '" + modelType + "'", e);
        }
    }

    @Override
    public Iterable<T> findAll(Sort sort) {
        try {
            QueryBuilder<T, String> queryBuilder = getDao().queryBuilder();
            for (Sort.Order order : sort) {
                queryBuilder.orderBy(order.getProperty(), order.isAscending());
            }
            return queryBuilder.query();
        } catch (SQLException e) {
            throw wrapException(e);
        }
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return readPage(getDao().queryBuilder(), pageable);
    }

    @Override
    public <S extends T> S save(S entity) {
        try {
            getDao().createOrUpdate(entity);
            return entity;
        } catch (SQLException e) {
            throw wrapException(e);
        }
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> entities) {
        try {
            for (S entity : entities) {
                getDao().createOrUpdate(entity);
            }
        } catch (SQLException e) {
            throw wrapException(e);
        }
        return entities;
    }

    @Override
    public T findOne(String id) {
        try {
            return getDao().queryForId(id);
        } catch (SQLException e) {
            throw wrapException(e);
        }
    }

    @Override
    public boolean exists(String id) {
        try {
            return getDao().idExists(id);
        } catch (SQLException e) {
            throw wrapException(e);
        }
    }

    @Override
    public Iterable<T> findAll() {
        try {
            return getDao().queryForAll();
        } catch (SQLException e) {
            throw wrapException(e);
        }
    }

    @Override
    public Iterable<T> findAll(Iterable<String> ids) {
        try {
            return getDao().queryBuilder().where().in("id", ids).query();
        } catch (SQLException e) {
            throw wrapException(e);
        }
    }

    @Override
    public long count() {
        try {
            return getDao().countOf();
        } catch (SQLException e) {
            throw wrapException(e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            getDao().deleteById(id);
        } catch (SQLException e) {
            throw wrapException(e);
        }
    }

    @Override
    public void delete(T entity) {
        try {
            getDao().delete(entity);
        } catch (SQLException e) {
            throw wrapException(e);
        }
    }

    @Override
    public void delete(Iterable<? extends T> entities) {
        for (T entity : entities) {
            delete(entity);
        }
    }

    @Override
    public void deleteAll() {
        try {
            getDao().deleteBuilder().delete();
        } catch (SQLException e) {
            throw wrapException(e);
        }
    }
}
