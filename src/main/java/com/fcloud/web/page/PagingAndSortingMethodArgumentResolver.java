package com.fcloud.web.page;

import com.fcloud.core.model.PageRequest;
import com.fcloud.core.model.Pageable;
import com.fcloud.core.model.Sort;
import org.springframework.core.MethodParameter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruben Fu
 */
public class PagingAndSortingMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final int noFindParamNumber = -1;
    private static final int DEFAULT_PAGE = 1;
    private static final int defaultPageSize = 20;
    private static final Pageable DEFAULT_PAGE_REQUEST = new PageRequest(DEFAULT_PAGE - 1, defaultPageSize);

    private static final String pageParamName = "page";
    private static final String limitParamName = "limit";
    private static final String sortParamName = "sort";

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return ClassUtils.isAssignable(parameter.getParameterType(), PageRequest.class);
    }

    private Pageable getDefaultPageRequest(MethodParameter parameter) {
        for(Annotation annotation : parameter.getParameterAnnotations()) {
            if(annotation instanceof PageableDefaults) {
                PageableDefaults defaults = (PageableDefaults) annotation;
                if (defaults.sort() == null || defaults.sort().length == 0) {
                    return new PageRequest(defaults.pageNumber(), defaults.value());
                }
                return new PageRequest(defaults.pageNumber(), defaults.value(), defaults.sortDir(), defaults.sort());
            }
        }
        return DEFAULT_PAGE_REQUEST;
    }

    private int getConvertedParameterNumber(NativeWebRequest request, String name) {
        int number = noFindParamNumber;
        String sNumber = request.getParameter(name);
        if (StringUtils.hasText(sNumber)) {
            try {
                number = Integer.parseInt(sNumber);
            } catch (NumberFormatException ignored) {
            }
        }
        return number;
    }

    private Sort getParameterSort(NativeWebRequest request) {
        Sort sort = null;
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        String[] orderValues = request.getParameterValues(sortParamName);
        if(null != orderValues) {
            for(String orderParam : orderValues) {
                String sortDir = request.getParameter(orderParam + ".dir");
                Sort.Direction dir = (null != sortDir ? Sort.Direction.valueOf(sortDir.toUpperCase()) : Sort.Direction.ASC);
                orders.add(new Sort.Order(dir, orderParam));
            }
            if(!orders.isEmpty()) {
                sort = new Sort(orders);
            }
        }
        return sort;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Pageable pageable = getDefaultPageRequest(parameter);

        int page = getConvertedParameterNumber(webRequest, pageParamName);
        int limit = getConvertedParameterNumber(webRequest, limitParamName);
        Sort sort = getParameterSort(webRequest);

        if (page > noFindParamNumber || limit > noFindParamNumber || sort != null) {
            page = (page > noFindParamNumber) ? page : pageable.getPageNumber() + 1;
            limit = (limit > noFindParamNumber) ? limit : pageable.getPageSize();
            sort = (sort != null) ? sort : pageable.getSort();

            pageable = new PageRequest(page - 1, limit, sort);
        }

        return pageable;
    }
}
