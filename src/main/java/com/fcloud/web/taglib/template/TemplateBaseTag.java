package com.fcloud.web.taglib.template;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;
import java.io.IOException;

/**
 * 基础标签类
 */
public abstract class TemplateBaseTag extends BodyTagSupport implements TryCatchFinally {

    protected final Log logger = LogFactory.getLog(getClass());

    private TemplateContext templateContext;

    public TemplateContext getTemplateContext() throws JspTagException {
        if (templateContext == null) {
            templateContext = TemplateContext.get(pageContext, true);
        }
        return templateContext;
    }

    @Override
    public void doCatch(Throwable throwable) throws Throwable {
        logger.error("标签执行发生错误！", throwable);
        throw throwable;
    }

    @Override
    public void doFinally() {
        release();
    }

    @Override
    public void release() {
        templateContext = null;
        super.release();
    }

    protected void output(String str) throws JspException {
        try {
            pageContext.getOut().print(str);
        } catch (IOException e) {
            throw new JspTagException("输出JSP内容出错", e);
        }
    }
}
