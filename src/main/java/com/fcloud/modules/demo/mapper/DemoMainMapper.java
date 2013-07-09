package com.fcloud.modules.demo.mapper;

import com.fcloud.core.mapper.CrudMapper;
import com.fcloud.core.page.Pagination;
import com.fcloud.core.query.Criteria;
import com.fcloud.modules.demo.model.DemoMain;

/**
 * Demo Mapper
 */
public interface DemoMainMapper extends CrudMapper<DemoMain> {

    public Pagination<DemoMain> findByCriteria(Criteria criteria);
}
