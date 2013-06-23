package com.fcloud.core.mybatis.interceptor;

import com.fcloud.util.DBUtils;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-11
 * Time: 下午5:03
 * To change this template use File | Settings | File Templates.
 */
public class CountCalculater {

    public static void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql, Object parameterObject) throws SQLException {
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
        parameterHandler.setParameters(ps);
    }


    public static int count(final String sql, final Connection connection,
                               final MappedStatement mappedStatement, final Object parameterObject,
                               final BoundSql boundSql) throws SQLException {
        final String countSql = "select count(1) from (" + sql + ") as tmp_count";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(countSql);
            BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
                    boundSql.getParameterMappings(), parameterObject);
            setParameters(ps, mappedStatement, countBS, parameterObject);
            rs = ps.executeQuery();
            int count = 0;
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } finally {
            DBUtils.closeQuiet(rs);
            DBUtils.closeQuiet(ps);
        }
    }
}
