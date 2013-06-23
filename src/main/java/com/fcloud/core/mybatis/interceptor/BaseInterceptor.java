package com.fcloud.core.mybatis.interceptor;

import com.fcloud.core.mybatis.dialect.Dialect;
import com.fcloud.util.FieldUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.session.RowBounds;
import org.springframework.util.ClassUtils;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-11
 * Time: 下午3:40
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseInterceptor implements Interceptor {

    protected static final Log logger = LogFactory.getLog(BaseInterceptor.class);

    @Override
    public void setProperties(Properties properties) {
        String dc = properties.getProperty("dialectClass");
        try {
            setDialectClass((Class<Dialect>) ClassUtils.forName(dc, ClassUtils.getDefaultClassLoader()));
            initDialect();
        } catch (ClassNotFoundException e) {
            logger.error("Load dialect class failed!", e);
        } catch (InstantiationException e) {
            logger.error("New dialect class failed!", e);
        } catch (IllegalAccessException e) {
            logger.error("New dialect class failed!", e);
        }
    }

    protected Class<Dialect> dialectClass;

    public void setDialectClass(Class<Dialect> dialectClass) {
        this.dialectClass = dialectClass;
    }

    protected Dialect dialect;

    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    public void initDialect() throws IllegalAccessException, InstantiationException {
        setDialect(dialectClass.newInstance());
    }

    protected StatementHandler getStatementHandler(Invocation invocation) {
        StatementHandler statement = (StatementHandler) invocation.getTarget();
        if (statement instanceof RoutingStatementHandler) {
            statement = (StatementHandler) FieldUtils.getFieldValue(statement,
                    "delegate");
        }
        return statement;
    }

    protected RowBounds getRowBounds(StatementHandler statement) {
        return (RowBounds) FieldUtils.getFieldValue(statement, "rowBounds");
    }

    protected MappedStatement getMappedStatement(StatementHandler statement) {
        return (MappedStatement) FieldUtils.getFieldValue(statement, "mappedStatement");
    }

    protected boolean hasBounds(RowBounds rowBounds) {
        return (rowBounds != null
                && rowBounds.getLimit() > 0
                && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT);
    }
}
