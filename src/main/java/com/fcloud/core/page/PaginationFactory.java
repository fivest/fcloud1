package com.fcloud.core.page;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-11
 * Time: 下午1:53
 * To change this template use File | Settings | File Templates.
 */
public class PaginationFactory {

    public static <T> Pagination newDefPage(int page) {
        return newLimitPage(page, 15);
    }

    public static <T> Pagination newLimitPage(int page, int limit) {
        Pagination<T> pagination = new Pagination<T>();
        pagination.setLimit(limit);
        pagination.setPage(page);
        return pagination;
    }

    public static <T> Pagination newOffsetLimitPage(int offset, int limit) {
        Pagination<T> pagination = new Pagination<T>();
        pagination.setLimit(limit);
        pagination.setOffset(offset);
        return pagination;
    }
}
