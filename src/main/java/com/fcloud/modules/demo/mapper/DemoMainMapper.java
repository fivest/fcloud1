package com.fcloud.modules.demo.mapper;

import com.fcloud.core.mapper.CrudMapper;
import com.fcloud.core.mapper.Mapper;
import com.fcloud.core.page.Pagination;
import com.fcloud.modules.demo.model.DemoMain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-16
 * Time: 下午8:37
 * To change this template use File | Settings | File Templates.
 */
@Mapper
public interface DemoMainMapper extends CrudMapper<DemoMain> {

    public List<DemoMain> findAll();

    public Pagination<DemoMain> findAllByPage(Pagination page);
}
