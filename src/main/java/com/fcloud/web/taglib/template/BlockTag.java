package com.fcloud.web.taglib.template;

import javax.servlet.jsp.JspException;

/**
 * 区块定义标签
 */
public class BlockTag extends TemplateBaseTag {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int doStartTag() throws JspException {

        TemplateContext context = getTemplateContext();
        BlockContent block = context.getBlock(name);

        // 第一次或者需要解析super时
        if (block.isNew() || block.isIncludeSuper()) {
            return EVAL_BODY_BUFFERED;
        }

        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {

        TemplateContext context = getTemplateContext();
        BlockContent block = context.getBlock(name);
        String body = getBodyContent() != null ? getBodyContent().getString() : "";

        if (block.isNew()) {
            block.setContent(body);
        }
        else if (block.isIncludeSuper()) {
            block.setSuperContent(body);
        }

        // 输出状态时输出block内容
        if (TemplateContext.Status.PRINT.equals(context.getStatus())) {
            output(block.getContent());
        }

        return EVAL_PAGE;
    }

    @Override
    public void release() {
        super.release();
        name = null;
    }
}
