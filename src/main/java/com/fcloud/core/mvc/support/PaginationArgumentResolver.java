package com.fcloud.core.mvc.support;

import com.fcloud.core.page.Pagination;
import com.fcloud.core.page.PaginationFactory;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 分页参数解析器
 */
public class PaginationArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Pagination.class.isAssignableFrom(parameter.getParameterType());
    }

    protected String getParameter(NativeWebRequest webRequest, String[] names) {
        for (String name : names) {
            String value = webRequest.getParameter(name);
            if (!StringUtils.isEmpty(value)) {
                return value;
            }
        }
        return null;
    }

    protected int getPageParameter(NativeWebRequest webRequest) {
        String[] paramName = new String[]{"page", "_p", "p"};
        String value = getParameter(webRequest, paramName);
        if (value == null)
            return 1;
        return Integer.parseInt(value);
    }

    protected int getLimitParameter(NativeWebRequest webRequest) {
        String[] paramName = new String[] {"limit", "_limit"};
        String value = getParameter(webRequest, paramName);
        if (value == null)
            return 15;
        return Integer.parseInt(value);
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        int page = getPageParameter(webRequest);
        int limit = getLimitParameter(webRequest);
        return PaginationFactory.newLimitPage(page, limit);
    }
}
