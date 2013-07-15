package com.fcloud.core.query.support;

import com.fcloud.core.query.Criteria;
import com.fcloud.core.query.Criterion;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Iterator;

/**
 * 查询条件参数拦截器
 * <p>
 *     数据格式 query?prop=value&prop:op=op
 *     样例
 *     query?name=user&name:op=like&age=20&age=30&age:op=between
 * </p>
 */
public class CriteriaArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Criteria.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(
            MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // 按规则搜集参数
        Criteria criteria = new Criteria();
        Iterator<String> names = webRequest.getParameterNames();
        for (;names.hasNext();) {
            String name = names.next();
            if (!name.contains(":")) {
                String[] values = webRequest.getParameterValues(name);
                String op = webRequest.getParameter(name + ":op");
                if (StringUtils.isEmpty(op)) {
                    op = "=";
                }
                // todo name 和 values 的转换
                Criterion criterion = new Criterion(name, values, op);
                criteria.add(criterion);
            }
        }
        return criteria;
    }
}
