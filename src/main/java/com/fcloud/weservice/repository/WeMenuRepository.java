package com.fcloud.weservice.repository;


import com.fcloud.core.model.Entity;
import com.fcloud.core.repository.PagingAndSortingRepository;
import com.fcloud.core.repository.support.SimpleRepository;
import com.fcloud.weservice.model.WeMenu;
import com.fcloud.weservice.model.WePublic;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 自定义菜单
 *
 * @author
 * @version 1.0 2013-11-12
 */
@Repository
public class WeMenuRepository extends SimpleRepository<WeMenu>{
}
