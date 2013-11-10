package com.fcloud.core.model;

import java.util.Iterator;
import java.util.List;

/**
 * @author Ruben Fu
 */
public interface Page<T> extends Iterable<T> {

    /**
     * 当前页， 从 0 开始，与一般不同
     * @return
     */
    int getNumber();

    /**
     * 当前页，从 1 开始
     * @return
     */
    int getPage();

    /**
     *
     * @return
     */
    int getSize();

    /**
     *
     * @return
     */
    int getTotalPages();

    /**
     *
     * @return
     */
    int getNumberOfElements();

    /**
     * 数据总数，同getTotalElements
     * @return
     */
    long getTotal();

    /**
     * 数据总数，同getTotal
     * @return
     */
    long getTotalElements();

    /**
     * 是否有前页
     * @return
     */
    boolean hasPreviousPage();

    /**
     * 是否是第一页
     * @return
     */
    boolean isFirstPage();

    /**
     * 是否有后续页
     * @return
     */
    boolean hasNextPage();

    /**
     * 是否是最后一页
     * @return
     */
    boolean isLastPage();

    /**
     * 数据内容迭代
     * @return
     */
    Iterator<T> iterator();

    /**
     * 数据内容
     * @return
     */
    List<T> getContent();

    /**
     * 是否有数据
     * @return
     */
    boolean hasContent();

    /**
     * 排序条件
     * @return
     */
    Sort getSort();
}
