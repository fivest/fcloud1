package com.fcloud.core.mybatis.proxy;

import com.fcloud.util.FieldUtils;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-11
 * Time: 下午10:40
 * To change this template use File | Settings | File Templates.
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
