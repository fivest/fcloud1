package com.fcloud.core.mybatis.dialect;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-11
 * Time: 下午3:50
 * To change this template use File | Settings | File Templates.
 */
public interface Dialect {

    public boolean supportsLimit();

    public String getLimitString(String sql, int offset, int limit);
}
