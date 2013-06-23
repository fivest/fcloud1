package com.fcloud.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-11
 * Time: 下午5:30
 * To change this template use File | Settings | File Templates.
 */
public abstract class DBUtils {

    public static void closeQuiet(ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            // ignore
        }
    }

    public static void closeQuiet(PreparedStatement ps) {
        try {
            if (ps != null)
                ps.close();
        } catch (SQLException e) {
            // ignore
        }
    }

    public static void closeQuiet(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            // ignore
        }
    }
}
