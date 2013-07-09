package com.fcloud.core.mybatis.proxy;

import com.fcloud.util.FieldUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 分页执行器代理工厂
 */
public class PaginationMapperProxyFactory<T> extends MapperProxyFactory<T> {

    private final Class<T> _mapperInterface;

    private final Map<Method, MapperMethod> _methodCache;

    private final Map<Method, PaginationMapperMethod> paginationMethodCache;

    public PaginationMapperProxyFactory(Class<T> mapperInterface) {
        super(mapperInterface);
        this._mapperInterface = mapperInterface;
        this._methodCache = (Map<Method, MapperMethod>) FieldUtils.getFieldValue(this, "methodCache");
        this.paginationMethodCache = new ConcurrentHashMap<Method, PaginationMapperMethod>();
    }

    public T newInstance(SqlSession sqlSession) {
        final PaginationMapperProxy<T> mapperProxy = new PaginationMapperProxy<T>(sqlSession, _mapperInterface,
                _methodCache, paginationMethodCache);
        return newInstance(mapperProxy);
    }
}
