package com.fcloud.core.controller;

import com.fcloud.core.model.Persistable;
import com.fcloud.core.repository.PagingAndSortingRepository;

/**
 * @author Ruben Fu
 */
public class MultiResourcesController extends BaseController {

    protected <T extends Persistable, R extends PagingAndSortingRepository<T>> R getRepository(Class<T> clz) {
        return repositories.lookup(clz);
    }
}
