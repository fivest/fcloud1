package com.fcloud.core.page;

import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-11
 * Time: 下午1:29
 * To change this template use File | Settings | File Templates.
 */
public class Pagination<T> {

    private List<T> datas = Collections.emptyList();

    private int total = -1;

    private int pageSize = -1;

    private int offset = -1;

    private int limit = 15;

    private int page = -1;

    public Pagination() {}

    public List<T> getDatas() {
        return datas;
    }

    public int getTotal() {
        return total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getOffset() {
        return offset;
    }

    public int getLimit() {
        return limit;
    }

    public int getPage() {
        return page;
    }

    public void setTotal(int total) {
        this.total = total;
        pageSize = (int) (total / limit);
        if (total % limit > 0) {
            pageSize ++;
        }
    }

    public void setOffset(int offset) {
        this.offset = offset;
        this.page = offset / limit + 1;
    }

    public void setPage(int page) {
        this.page = page;
        this.offset = (page - 1) * limit;
    }

    public void setLimit(int limit) {
        if (limit < 1)
            limit = 15;
        this.limit = limit;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
        if (datas == null || datas.isEmpty()) {
            total = 0;
            page = 1;
            offset = 0;
            pageSize = 0;
        }
    }

}
