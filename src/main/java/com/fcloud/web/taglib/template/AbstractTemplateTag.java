package com.fcloud.web.taglib.template;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import java.io.IOException;

/**
 * 加载模版基类
 * @author Ruben Fu
 */
public abstract class AbstractTemplateTag extends TemplateBaseTag {

    public static final String DEFAULT_ENCODING = "UTF-8";

    protected abstract String getFile();

    protected String charEncoding;

    public void setCharEncoding(String charEncoding) {
        this.charEncoding = charEncoding;
    }

    @Override
    public void release() {
        super.release();
        charEncoding = DEFAULT_ENCODING;
    }

    protected String postTargetUrl(String targetUrl) {
        return targetUrl;
    }

    protected String acquireString() throws IOException, JspException {
        String targetUrl = getFile();
        if (!targetUrl.startsWith("/")) {
            String sp = ((HttpServletRequest) pageContext.getRequest())
                    .getServletPath();
            targetUrl = sp.substring(0, sp.lastIndexOf('/')) + '/' + targetUrl;
        }
        targetUrl = postTargetUrl(targetUrl);

        TargetUrlContentAcquirer acquirer = new TargetUrlContentAcquirer(
                targetUrl, pageContext, charEncoding);

        return acquirer.acquireString();
    }
}