package com.fcloud.web.taglib.template;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import java.util.HashMap;
import java.util.Map;

/**
 * 模版执行上下文
 */
public class TemplateContext {

    private static final String CONTEXT_KEY = TemplateContext.class.getName() + "_$$_";

    enum Status {
        INCLUDE, // 做页面include时状态
        EVAL, // 使用模版时的状态
        PRINT // 最终定义页面时状态
    };

    public static TemplateContext get(PageContext pageContext, boolean required) throws JspTagException {
        TemplateContext context = get(pageContext);
        if (context == null && required) {
            throw new JspTagException("TemplateContext不可以为空!");
        }
        return context;
    }

    public static TemplateContext get(PageContext pageContext) {
        final String key = CONTEXT_KEY;
        final int scope = PageContext.REQUEST_SCOPE;
        return (TemplateContext) pageContext.getAttribute(key, scope);
    }

    public static void set(PageContext pageContext, TemplateContext context) {
        final String key = CONTEXT_KEY;
        final int scope = PageContext.REQUEST_SCOPE;
        pageContext.setAttribute(key, context, scope);
    }

    public static boolean has(PageContext pageContext) {
        return get(pageContext) != null;
    }

    public void release(final PageContext context) {
        final TemplateContext ptc = this.preContext;
        if (ptc != null) {
            set(context, ptc);
        }
    }

    public void bind(final PageContext context) {
        final TemplateContext ptc = get(context);
        if (ptc != null) {
            this.preContext = ptc;
        }
        set(context, this);
    }

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private TemplateContext preContext = null;

    private Map<String, BlockContent> blocks = new HashMap<String, BlockContent>();

    public BlockContent getBlock(String name) {
        BlockContent block = blocks.get(name);
        if (block == null) {
            block = new BlockContent(name);
            blocks.put(name, block);
        }
        return block;
    }
}
