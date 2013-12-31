/**
 * 
 */
package com.fcloud.util;

import org.springframework.web.context.support.XmlWebApplicationContext;

import com.fcloud.util.crypto.LicenseUtils;

/**
 * @author ruben
 *
 */
public class WebContext extends XmlWebApplicationContext {
	
	@Override
	protected void initPropertySources() {
		super.initPropertySources();
		read();
	}
	
	public static void read() {
		new LicenseUtils().doRead();
	}
}
