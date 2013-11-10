package com.fcloud.core.model;


/**
 * @author Ruben Fu
 */
public interface Pageable {

    int getPageNumber();

    int getPageSize();

    int getOffset();

    Sort getSort();
}
