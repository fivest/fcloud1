package com.fcloud.web.taglib.template;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;

/**
 * 调用父定义内容
 * @author Ruben Fu
 */
public class SuperTag extends TemplateBaseTag {

    @Override
    public int doStartTag() throws JspException {
        BlockTag blockTag = (BlockTag) findAncestorWithClass(this, BlockTag.class);

        if (blockTag == null) {
            throw new JspTagException("不可以在BlockTag以外使用super标签");
        }

        output(BlockContent.BLOCK_KEY);
        return SKIP_BODY;
    }
}