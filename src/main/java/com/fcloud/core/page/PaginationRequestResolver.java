package com.fcloud.core.page;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 从请求参数中获取分页信息辅组类
 */
public class PaginationRequestResolver {

    private HttpServletRequest request;

    public PaginationRequestResolver(HttpServletRequest request) {
        this.request = request;
    }

    protected String getParameter(String[] names) {
        for (String name : names) {
            String value = request.getParameter(name);
            if (!StringUtils.isEmpty(value)) {
                return value;
            }
        }
        return null;
    }

    public int getPageParameter() {
        String[] paramName = new String[]{"page", "_p", "p"};
        String value = getParameter(paramName);
        if (value == null)
            return 1;
        return Integer.parseInt(value);
    }

    public int getLimitParameter() {
        String[] paramName = new String[] {"limit", "_limit"};
        String value = getParameter(paramName);
        if (value == null)
            return 15;
        return Integer.parseInt(value);
    }
}
