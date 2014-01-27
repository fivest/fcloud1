package com.fcloud.util;

public class StringUtil {
	/**
	 * 字符串is null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * 字符串 is not null
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		return !isNull(str);
	}

	/**
	 * 链接字符串，如果左链接字符串为空，则返回右链接字符串，反之返回左链接字符串，如果都不为空，则返回左链接+链接符+右链接
	 * 
	 * @param leftStr
	 *            左链接
	 * @param linkStr
	 *            链接符
	 * @param rightStr
	 *            右链接
	 * @return
	 */
	public static String linkString(String leftStr, String linkStr,
			String rightStr) {
		if (isNull(leftStr)) {
			return rightStr;
		}
		if (isNull(rightStr)) {
			return leftStr;
		}
		return leftStr + linkStr + rightStr;
	}
}
