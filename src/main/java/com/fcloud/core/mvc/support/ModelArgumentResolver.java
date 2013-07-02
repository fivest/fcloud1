package com.fcloud.core.mvc.support;

import com.fcloud.core.mapper.CrudMapper;
import com.fcloud.core.mapper.Mapper;
import com.fcloud.core.mapper.MapperManager;
import com.fcloud.core.model.Model;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.bind.support.WebRequestDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.ServletRequest;

/**
 * Model参数自动装填器
 * @author ruben
 */
public class ModelArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    protected MapperManager mapperManager;

    protected Model newOrFindModel(MethodParameter parameter, NativeWebRequest webRequest) {
        String id = webRequest.getParameter("id");
        if (StringUtils.isEmpty(id)) {
            return (Model) BeanUtils.instantiate(parameter.getParameterType());
        }
        Mapper<?> mapper = mapperManager.getMapper((Class<? extends Model>) parameter.getParameterType());
        if (mapper instanceof CrudMapper) {
            Model model = ((CrudMapper) mapper).find(id);
            if (model != null) {
                return model;
            }
        }
        return (Model) BeanUtils.instantiate(parameter.getParameterType());
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Model.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Model model = newOrFindModel(parameter, webRequest);
        if (model != null) {
            WebDataBinder binder = binderFactory.createBinder(webRequest, model, "model");
            bindRequestParameters(binder, webRequest);
            // TODO validate ModelAttributeMethodProcessor
            return binder.getTarget();
        }
        return model;
    }

    protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
        if (binder instanceof ServletRequestDataBinder) {
            ((ServletRequestDataBinder) binder).bind(request.getNativeRequest(ServletRequest.class));
        } else {
            ((WebRequestDataBinder) binder).bind(request);
        }
    }
}
