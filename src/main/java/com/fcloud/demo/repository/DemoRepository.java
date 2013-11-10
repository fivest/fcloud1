package com.fcloud.demo.repository;

import com.fcloud.core.repository.support.SimpleRepository;
import com.fcloud.demo.model.MyDemo;
import org.springframework.stereotype.Repository;

/**
 * @author Ruben Fu
 */
@Repository
public class DemoRepository extends SimpleRepository<MyDemo> {

}
