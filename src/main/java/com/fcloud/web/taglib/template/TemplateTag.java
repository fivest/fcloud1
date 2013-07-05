package com.fcloud.web.taglib.template;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import java.io.IOException;

/**
 * 模版使用标签
 */
public class TemplateTag extends AbstractTemplateTag {

    protected String extend;

    public void setExtend(String extend) {
        this.extend = extend;
    }

    protected boolean newContext = false;

    @Override
    protected String getFile() {
        return extend;
    }

    @Override
    public int doStartTag() throws JspException {
        TemplateContext context = TemplateContext.get(pageContext);
        if (context == null ||
                !TemplateContext.Status.INCLUDE.equals(context.getStatus())) {
            context = new TemplateContext();
            context.bind(pageContext);
            newContext = true;
        }
        if (extend == null) {
            context.setStatus(TemplateContext.Status.PRINT);
            return EVAL_BODY_INCLUDE;
        }
        context.setStatus(TemplateContext.Status.EVAL);
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {

        TemplateContext context = TemplateContext.get(pageContext);

        if (extend != null) {
            context.setStatus(TemplateContext.Status.INCLUDE);
            try {
                output(acquireString());
            } catch (IOException e) {
                throw new JspTagException("获取父模版内容报错：", e);
            }
        }
        return EVAL_PAGE;
    }

    @Override
    public void release() {
        if (newContext) {
            TemplateContext context = TemplateContext.get(pageContext);
            context.release(pageContext);
        }
        extend = null;
        newContext = false;
        super.release();
    }
}
