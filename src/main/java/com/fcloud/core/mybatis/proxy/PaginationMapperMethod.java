package com.fcloud.core.mybatis.proxy;

import com.fcloud.core.page.PageContext;
import com.fcloud.core.page.Pagination;
import com.fcloud.core.page.PaginationFactory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分页方法执行器
 */
public class PaginationMapperMethod {

    private Configuration config;

    private SqlCommandType type;
    private String commandName;

    private Class<?> declaringInterface;
    private Method method;

    private Integer rowBoundsIndex;
    private Integer paginationIndex;
    private List<String> paramNames;
    private List<Integer> paramPositions;

    private boolean hasNamedParameters;

    public PaginationMapperMethod(Class<?> declaringInterface, Method method,
                                  SqlSession sqlSession) {
        paramNames = new ArrayList<String>();
        paramPositions = new ArrayList<Integer>();
        this.method = method;
        this.config = sqlSession.getConfiguration();
        this.hasNamedParameters = false;
        this.declaringInterface = declaringInterface;
        setupFields();
        setupMethodSignature();
        setupCommandType();
        validateStatement();
    }

    public Object execute(SqlSession sqlSession, Object[] args) {
        final Object param = getParam(args);
        Pagination<Object> page;
        RowBounds rowBounds;
        if (paginationIndex != null) {
            page = (Pagination<Object>) args[paginationIndex];
            rowBounds = new RowBounds(page.getOffset(), page.getLimit());
        } else if (rowBoundsIndex != null) {
            rowBounds = (RowBounds) args[rowBoundsIndex];
            page = PaginationFactory.<Object>newOffsetLimitPage(rowBounds.getOffset(), rowBounds.getLimit());
        } else {
            throw new BindingException("Invalid bound statement (not found rowBounds or pagination in paramenters)");
        }
        try {
            PageContext.set(page);
            page.setDatas(executeForList(sqlSession, param, rowBounds));
        } finally {
            PageContext.clear();
        }
        return page;
    }

    private List<Object> executeForList(SqlSession sqlSession, Object param, RowBounds rowBounds) {
        return sqlSession.selectList(commandName, param, rowBounds);
    }

    private Object getParam(Object[] args) {
        final int paramCount = paramPositions.size();
        if (args == null || paramCount == 0) {
            return null;
        } else if (!hasNamedParameters && paramCount == 1) {
            return args[paramPositions.get(0)];
        } else {
            Map<String, Object> param = new HashMap<String, Object>();
            for (int i = 0; i < paramCount; i++) {
                param.put(paramNames.get(i), args[paramPositions.get(i)]);
            }
            return param;
        }
    }

    private void setupMethodSignature() {
        final Class<?>[] argTypes = method.getParameterTypes();
        for (int i = 0; i < argTypes.length; i++) {
            if (Pagination.class.isAssignableFrom(argTypes[i])) {
                paginationIndex = i;
            } else if (RowBounds.class.isAssignableFrom(argTypes[i])) {
                rowBoundsIndex = i;
            } else {
                String paramName = String.valueOf(paramPositions.size());
                paramName = getParamNameFromAnnotation(i, paramName);
                paramNames.add(paramName);
                paramPositions.add(i);
            }
        }
    }

    private String getParamNameFromAnnotation(int i, String paramName) {
        Object[] paramAnnos = method.getParameterAnnotations()[i];
        for (Object paramAnno : paramAnnos) {
            if (paramAnno instanceof Param) {
                hasNamedParameters = true;
                paramName = ((Param) paramAnno).value();
            }
        }
        return paramName;
    }

    private void setupFields() {
        commandName = declaringInterface.getName() + "." + method.getName();
    }

    private void setupCommandType() {
        MappedStatement ms = config.getMappedStatement(commandName);
        type = ms.getSqlCommandType();
        if (type != SqlCommandType.SELECT) {
            throw new BindingException("Unsupport execution method for: " + commandName);
        }
    }

    private void validateStatement() {
        if (!config.hasStatement(commandName)) {
            throw new BindingException("Invalid bound statement (not found): " + commandName);
        }
    }
}
