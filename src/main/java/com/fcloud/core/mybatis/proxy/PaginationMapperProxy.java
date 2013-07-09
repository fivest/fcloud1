package com.fcloud.core.mybatis.proxy;

import com.fcloud.core.page.Pagination;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 分页方法执行代理
 */
public class PaginationMapperProxy<T> extends MapperProxy<T> {

    private final SqlSession _sqlSession;
    private final Class<T> _mapperInterface;
    private final Map<Method, PaginationMapperMethod> paginationMethodCache;

    public PaginationMapperProxy(SqlSession sqlSession, Class<T> mapperInterface, Map<Method, MapperMethod> methodCache,
                                 Map<Method, PaginationMapperMethod> paginationMethodCache) {
        super(sqlSession, mapperInterface, methodCache);
        this._sqlSession = sqlSession;
        this._mapperInterface = mapperInterface;
        this.paginationMethodCache = paginationMethodCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> returnType = method.getReturnType();
        if (Pagination.class.isAssignableFrom(returnType)) {
            PaginationMapperMethod paginationMethod = _cachedMapperMethod(method);
            return paginationMethod.execute(_sqlSession, args);
        }
        return super.invoke(proxy, method, args);
    }

    private PaginationMapperMethod _cachedMapperMethod(Method method) {
        PaginationMapperMethod paginationMethod = paginationMethodCache.get(method);
        if (paginationMethod == null) {
            paginationMethod = new PaginationMapperMethod(_mapperInterface, method, _sqlSession);
            paginationMethodCache.put(method, paginationMethod);
        }
        return paginationMethod;
    }

}
