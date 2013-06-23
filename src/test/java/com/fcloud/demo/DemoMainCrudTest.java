package com.fcloud.demo;

import com.fcloud.core.page.Pagination;
import com.fcloud.core.page.PaginationFactory;
import com.fcloud.modules.demo.mapper.DemoMainMapper;
import com.fcloud.modules.demo.model.DemoMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-16
 * Time: 下午9:41
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:conf/context.xml")
@TransactionConfiguration
@Transactional
public class DemoMainCrudTest {

    @Autowired(required = false)
    private DemoMainMapper demoMainMapper = null;

    @Test
    public void testCrud() throws Exception {
        DemoMain main = new DemoMain();
        main.setName("test name 1");
        String id = main.getId();
        demoMainMapper.insert(main);

        DemoMain main2 = demoMainMapper.find(id);

        assertEquals(main.getId(), main2.getId());

        main.setName("test name 22222");
        demoMainMapper.update(main);

        main2 = demoMainMapper.find(id);
        assertEquals("test name 22222", main2.getName());
    }

    @Test
    public void testFind() throws Exception {

        for (int i = 0; i < 10; i ++) {
            DemoMain main = new DemoMain();
            main.setName("test name " + i);
            demoMainMapper.insert(main);
        }

        Pagination<DemoMain> list = demoMainMapper.findAllByPage(PaginationFactory.newLimitPage(1, 5));

        for (DemoMain main : list.getDatas()) {
            System.out.println("id=" + main.getId() + ", name=" + main.getName());
        }
        assertEquals(5, list.getDatas().size());

        List<DemoMain> all = demoMainMapper.findAll();
        assertEquals(10, all.size());
    }
}
