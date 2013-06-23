package com.fcloud.core.mybatis.dialect;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-12
 * Time: 上午9:50
 * To change this template use File | Settings | File Templates.
 */
public class MySQLDialect implements Dialect {
    @Override
    public boolean supportsLimit() {
        return true;
    }

    @Override
    public String getLimitString(String sql, int offset, int limit) {
        String offsetPlaceholder = String.valueOf(offset);
        String limitPlaceholder = String.valueOf(limit);
        StringBuilder stringBuilder = new StringBuilder(sql);
        stringBuilder.append(" limit ");
        if (offset > 0) {
            stringBuilder.append(offsetPlaceholder).append(",").append(limitPlaceholder);
        } else {
            stringBuilder.append(limitPlaceholder);
        }
        return stringBuilder.toString();
    }
}
