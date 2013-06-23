package com.fcloud.core.mybatis.interceptor;

import com.fcloud.core.page.PageContext;
import com.fcloud.core.page.Pagination;
import com.fcloud.util.FieldUtils;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.SimpleStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-11
 * Time: 下午4:16
 * To change this template use File | Settings | File Templates.
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class})
})
public class PreparePaginationInterceptor extends BaseInterceptor {

    private void initPageCount(
            final String sql,
            final Connection connection,
            final MappedStatement mappedStatement,
            final Object parameterObject,
            final BoundSql boundSql) throws SQLException {
        Pagination<?> pagination = PageContext.<Object>get();
        final int count = CountCalculater.count(sql, connection,
                mappedStatement, parameterObject, boundSql);
        pagination.setTotal(count);
    }

    private Object prepare(Invocation invocation) throws Throwable {
        StatementHandler statement = getStatementHandler(invocation);

        if (statement instanceof SimpleStatementHandler
                || statement instanceof PreparedStatementHandler) {

            RowBounds rowBounds = getRowBounds(statement);

            if (hasBounds(rowBounds)) {
                final BoundSql boundSql = statement.getBoundSql();
                final String sql = boundSql.getSql();

                if (PageContext.hasContext()) {
                    initPageCount(sql, (Connection) invocation.getArgs()[0],
                            getMappedStatement(statement), boundSql.getParameterObject(), boundSql);
                }

                final String paginationSql = dialect.getLimitString(sql, rowBounds.getOffset(),
                        rowBounds.getLimit());
                FieldUtils.setFieldValue(boundSql, "sql", paginationSql);
                FieldUtils.setFieldValue(rowBounds, "offset", RowBounds.NO_ROW_OFFSET);
                FieldUtils.setFieldValue(rowBounds, "limit", RowBounds.NO_ROW_LIMIT);
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (!dialect.supportsLimit()) {
            return invocation.proceed();
        }
        return prepare(invocation);
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
}
