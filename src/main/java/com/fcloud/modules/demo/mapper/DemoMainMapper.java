package com.fcloud.modules.demo.mapper;

import com.fcloud.core.mapper.CrudMapper;
import com.fcloud.core.page.Pagination;
import com.fcloud.modules.demo.model.DemoMain;

import java.util.List;

/**
 * Demo Mapper
 */
public interface DemoMainMapper extends CrudMapper<DemoMain> {

    public List<DemoMain> findAll();

    public Pagination<DemoMain> findAllByPage(Pagination page);
}
