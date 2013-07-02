package com.fcloud.core.mvc.support;

import com.fcloud.core.mvc.ActionResult;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 返回值解析器
 * @author ruben
 */
public class ActionResultMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    private UrlPathHelper urlPathHelper = new UrlPathHelper();

    private List<String> publicViewNames = new ArrayList<String>(Arrays.asList("success", "error"));

    public void setPublicViewNames(List<String> publicViewNames) {
        this.publicViewNames.addAll(publicViewNames);
    }

    public void setPublicViewName(String name) {
        publicViewNames.add(name);
    }

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return ActionResult.class.isAssignableFrom(returnType.getParameterType());
    }

    protected String lookupRootPath(ActionResult result, String lookupPath) {
        for (String path : result.getRootPaths()) {
            if (lookupPath.contains(path)) {
                return path;
            }
        }
        return null;
    }

    protected String resolveView(ActionResult result , NativeWebRequest webRequest) {
        String viewName = result.getView();
        if (viewName == null) {
            return null;
        }
        if (viewName.startsWith("redirect:")) {
            return viewName;
        }
        if (publicViewNames.contains(viewName)) {
            return "public/" + viewName;
        }
        String lookupPath = this.urlPathHelper.getLookupPathForRequest(
                                        webRequest.getNativeRequest(HttpServletRequest.class));
        lookupPath = lookupRootPath(result, lookupPath);
        if (!lookupPath.endsWith("/")) {
            lookupPath += "/";
        }
        if (viewName.startsWith("/")) {
            viewName = viewName.substring(1);
        }
        viewName = lookupPath + viewName;
        if (viewName.startsWith("/")) {
            return viewName.substring(1);
        }
        return viewName;
    }

    @Override
    public void handleReturnValue(
            Object returnValue, MethodParameter returnType,
            ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        if (returnValue == null) {
            mavContainer.setRequestHandled(true);
            return;
        }

        ActionResult result = (ActionResult) returnValue;
        String viewName = resolveView(result, webRequest);
        mavContainer.setViewName(viewName);
        if (viewName != null && viewName.startsWith("redirect:")) {
            mavContainer.setRedirectModelScenario(true);
        }
        mavContainer.addAttribute(result.getModelName(), result.getModel());
    }
}
