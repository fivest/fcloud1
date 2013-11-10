package com.fcloud.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Ruben Fu
 */
public class PageImpl<T> implements Page<T>, Serializable {

    private static final long serialVersionUID = -8646782686576687305L;

    private final List<T> content = new ArrayList<T>();
    private final Pageable pageable;
    private final long total;

    public PageImpl(List<T> content, Pageable pageable, long total) {

        if (null == content) {
            throw new IllegalArgumentException("Content must not be null!");
        }

        this.content.addAll(content);
        this.total = total;
        this.pageable = pageable;
    }

    public PageImpl(List<T> content) {
        this(content, null, null == content ? 0 : content.size());
    }

    public int getPage() {
        return getNumber() + 1;
    }

    public int getNumber() {
        return pageable == null ? 0 : pageable.getPageNumber();
    }

    public int getSize() {
        return pageable == null ? 0 : pageable.getPageSize();
    }

    public int getTotalPages() {
        return getSize() == 0 ? 0 : (int) Math.ceil((double) total / (double) getSize());
    }

    public int getNumberOfElements() {
        return content.size();
    }

    public long getTotalElements() {
        return total;
    }

    public long getTotal() {
        return total;
    }

    public boolean hasPreviousPage() {
        return getNumber() > 0;
    }

    public boolean isFirstPage() {
        return !hasPreviousPage();
    }

    public boolean hasNextPage() {
        return (getNumber() + 1) * getSize() < total;
    }

    public boolean isLastPage() {
        return !hasNextPage();
    }

    public Iterator<T> iterator() {
        return content.iterator();
    }

    public List<T> getContent() {
        return Collections.unmodifiableList(content);
    }

    public boolean hasContent() {
        return !content.isEmpty();
    }

    public Sort getSort() {
        return pageable == null ? null : pageable.getSort();
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        String contentType = "UNKNOWN";

        if (content.size() > 0) {
            contentType = content.get(0).getClass().getName();
        }

        return String.format("Page %s of %d containing %s instances", getNumber(), getTotalPages(), contentType);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PageImpl<?>)) {
            return false;
        }

        PageImpl<?> that = (PageImpl<?>) obj;

        boolean totalEqual = this.total == that.total;
        boolean contentEqual = this.content.equals(that.content);
        boolean pageableEqual = this.pageable == null ? that.pageable == null : this.pageable.equals(that.pageable);

        return totalEqual && contentEqual && pageableEqual;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {

        int result = 17;

        result = 31 * result + (int) (total ^ total >>> 32);
        result = 31 * result + (pageable == null ? 0 : pageable.hashCode());
        result = 31 * result + content.hashCode();

        return result;
    }
}
