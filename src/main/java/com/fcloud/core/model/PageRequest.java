package com.fcloud.core.model;

import java.io.Serializable;

/**
 * @author Ruben Fu
 */
public class PageRequest implements Pageable, Serializable {

    private static final long serialVersionUID = -5390518339377444510L;

    private final int page;
    private final int size;
    private final Sort sort;

    public PageRequest(int page, int size) {

        this(page, size, null);
    }

    public PageRequest(int page, int size, Sort.Direction direction, String... properties) {

        this(page, size, new Sort(direction, properties));
    }

    public PageRequest(int page, int size, Sort sort) {

        if (0 > page) {
            throw new IllegalArgumentException("Page index must not be less than zero!");
        }

        if (0 >= size) {
            throw new IllegalArgumentException("Page size must not be less than or equal to zero!");
        }

        this.page = page;
        this.size = size;
        this.sort = sort;
    }

    public int getPageSize() {

        return size;
    }

    public int getPageNumber() {

        return page;
    }

    public int getOffset() {

        return page * size;
    }

    public Sort getSort() {

        return sort;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PageRequest)) {
            return false;
        }

        PageRequest that = (PageRequest) obj;

        boolean pageEqual = this.page == that.page;
        boolean sizeEqual = this.size == that.size;

        boolean sortEqual = this.sort == null ? that.sort == null : this.sort.equals(that.sort);

        return pageEqual && sizeEqual && sortEqual;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;

        result = 31 * result + page;
        result = 31 * result + size;
        result = 31 * result + (null == sort ? 0 : sort.hashCode());

        return result;
    }
}
