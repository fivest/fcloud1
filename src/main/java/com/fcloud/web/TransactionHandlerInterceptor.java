package com.fcloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ruben Fu
 */
public class TransactionHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    @Qualifier("transactionManager")
    private PlatformTransactionManager transactionManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        DefaultTransactionDefinition td = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
        if ("GET".equalsIgnoreCase(method)) {
            td.setReadOnly(true);
        }
        TransactionStatus status = transactionManager.getTransaction(td);
        request.setAttribute("TransactionHandlerInterceptor.Status", status);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        TransactionStatus status = (TransactionStatus) request.getAttribute("TransactionHandlerInterceptor.Status");
        if (ex == null) {
            transactionManager.commit(status);
        } else {
            transactionManager.rollback(status);
        }
    }

}
