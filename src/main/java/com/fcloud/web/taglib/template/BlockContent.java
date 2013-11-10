package com.fcloud.web.taglib.template;

import org.springframework.util.StringUtils;

/**
 * 区块内容
 * @author Ruben Fu
 */
public class BlockContent {

    public static final String BLOCK_KEY = "<!--BlockContent.BLOCK_KEY@"
            + Long.toHexString(System.currentTimeMillis()) + "-->";

    private String name;

    private String content;

    public BlockContent() {
    }

    public BlockContent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isIncludeSuper() {
        return content != null && content.contains(BLOCK_KEY);
    }

    public boolean isNew() {
        return content == null;
    }

    public void setContent(String content) {
        if (content == null)
            content = "";
        this.content = content;
    }

    public void setSuperContent(String superContent) {
        if (superContent == null) {
            superContent = "";
        }
        this.content = StringUtils.replace(this.content, BLOCK_KEY, superContent);
    }

    public String getContent() {
        return content;
    }
}