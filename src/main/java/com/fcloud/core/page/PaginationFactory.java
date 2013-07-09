package com.fcloud.core.page;

import javax.servlet.http.HttpServletRequest;

/**
 * 分页对象构造工厂
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

    public static <T> Pagination newRequestPage(HttpServletRequest request) {
        PaginationRequestResolver resolver = new PaginationRequestResolver(request);
        return newLimitPage(resolver.getPageParameter(), resolver.getLimitParameter());
    }
}
