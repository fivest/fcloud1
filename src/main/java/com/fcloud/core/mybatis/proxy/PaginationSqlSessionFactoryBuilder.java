package com.fcloud.core.mybatis.proxy;

import com.fcloud.util.FieldUtils;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-17
 * Time: 下午9:50
 * To change this template use File | Settings | File Templates.
 */
public class PaginationSqlSessionFactoryBuilder extends SqlSessionFactoryBuilder {

    @Override
    public SqlSessionFactory build(Configuration config) {
        FieldUtils.setFieldValue(config, "mapperRegistry", new PaginationMapperRegistry(config));
        return super.build(config);
    }
}
