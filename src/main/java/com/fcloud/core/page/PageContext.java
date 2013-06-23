package com.fcloud.core.page;

/**
 * Created with IntelliJ IDEA.
 * User: ruben
 * Date: 13-6-11
 * Time: 下午7:04
 * To change this template use File | Settings | File Templates.
 */
public class PageContext {

    private static final ThreadLocal<Pagination<?>> pages = new ThreadLocal<Pagination<?>>();

    public static boolean hasContext() {
        return (get() != null);
    }

    public static <T> Pagination get() {
        return pages.get();
    }

    public static <T> void set(Pagination<T> page) {
        pages.set(page);
    }

    public static void clear() {
        pages.remove();
    }
}
