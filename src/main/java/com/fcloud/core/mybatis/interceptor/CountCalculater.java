package com.fcloud.core.mybatis.interceptor;

import com.fcloud.util.DBUtils;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 总数技术类
 */
public class CountCalculater {

    public static void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql, Object parameterObject) throws SQLException {
        new DefaultParameterHandler(mappedStatement, parameterObject, boundSql).setParameters(ps);
    }


    public static int count(final String sql, final Connection connection,
                               final MappedStatement mappedStatement, final Object parameterObject,
                               final BoundSql boundSql) throws SQLException {
        final String countSql = "select count(1) from (" + sql + ") as tmp_count";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement(countSql);
            BoundSql countBS = new CountBoundSql(mappedStatement.getConfiguration(), countSql, boundSql);
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

    static class CountBoundSql extends BoundSql {

        private final BoundSql boundSql;

        public CountBoundSql(Configuration configuration, String sql, BoundSql boundSql) {
            super(configuration, sql, null, null);
            this.boundSql = boundSql;
        }

        public List<ParameterMapping> getParameterMappings() {
            return boundSql.getParameterMappings();
        }

        public Object getParameterObject() {
            return boundSql.getParameterObject();
        }

        public boolean hasAdditionalParameter(String name) {
            return boundSql.hasAdditionalParameter(name);
        }

        public void setAdditionalParameter(String name, Object value) {
            boundSql.setAdditionalParameter(name, value);
        }

        public Object getAdditionalParameter(String name) {
            return boundSql.getAdditionalParameter(name);
        }
    }
}
