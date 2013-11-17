package com.fcloud.wechat.basic.menu.main;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fcloud.wechat.basic.menu.bean.AccessToken;
import com.fcloud.wechat.basic.menu.bean.Button;
import com.fcloud.wechat.basic.menu.bean.CommonButton;
import com.fcloud.wechat.basic.menu.bean.ComplexButton;
import com.fcloud.wechat.basic.menu.bean.Menu;
import com.fcloud.wechat.basic.menu.util.WeixinUtil;

/**
 * 菜单管理器类,执行main函数创建菜单
 * 
 * @author 573
 * @date 2013-08-08
 */
public class MenuManager {	
	protected final Log logger = LogFactory.getLog(getClass());
	
	public static void main(String[] args) {
		// 第三方用户唯一凭证
		String appId = "wx359186d81de37760";
		// 第三方用户唯一凭证密钥
		String appSecret = "add1f20d1a55f0358f2f40aa8198838a";

		// 调用接口获取access_token
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);

		if (null != at) {
			// 调用接口创建菜单
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());

			// 判断菜单创建结果
			if (0 == result)
				// log.info("菜单创建成功！");
				System.out.println("菜单创建成功！");
			else
				// log.info("菜单创建失败，错误码：" + result);
				System.out.println("菜单创建失败，错误码：" + result);
		}
	}

	/**
	 * 组装菜单数据
	 * 
	 * @return
	 */
	private static Menu getMenu() {
		CommonButton btn11 = new CommonButton();
		btn11.setName("账号设置");
		btn11.setType("click");
		btn11.setKey("11");

		CommonButton btn12 = new CommonButton();
		btn12.setName("我的订阅*");
		btn12.setType("click");
		btn12.setKey("12");

		CommonButton btn13 = new CommonButton();
		btn13.setName("我的待办");
		btn13.setType("click");
		btn13.setKey("13");

		CommonButton btn14 = new CommonButton();
		btn14.setName("我的日程*");
		btn14.setType("click");
		btn14.setKey("14");
		CommonButton btn15 = new CommonButton();
		btn15.setName("个人记事本*");
		btn15.setType("click");
		btn15.setKey("15");

		CommonButton btn21 = new CommonButton();
		btn21.setName("公司新闻");
		btn21.setType("click");
		btn21.setKey("21");

		CommonButton btn22 = new CommonButton();
		btn22.setName("公司公告");
		btn22.setType("click");
		btn22.setKey("22");

		CommonButton btn23 = new CommonButton();
		btn23.setName("部门新闻*");
		btn23.setType("click");
		btn23.setKey("23");

		CommonButton btn24 = new CommonButton();
		btn24.setName("部门公告*");
		btn24.setType("click");
		btn24.setKey("24");

		CommonButton btn31 = new CommonButton();
		btn31.setName("内部搜索");
		btn31.setType("click");
		btn31.setKey("31");

		CommonButton btn32 = new CommonButton();
		btn32.setName("通讯录");
		btn32.setType("click");
		btn32.setKey("32");

		CommonButton btn33 = new CommonButton();
		btn33.setName("邮件查看");
		btn33.setType("click");
		btn33.setKey("33");

		CommonButton btn34 = new CommonButton();
		btn34.setName("常用资料*");
		btn34.setType("click");
		btn34.setKey("34");

		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("故障上报");
		mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14,
				btn15 });

		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("故障处理");
		mainBtn2
				.setSub_button(new CommonButton[] { btn21, btn22, btn23, btn24 });

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("关于");
		mainBtn3
				.setSub_button(new CommonButton[] { btn31, btn32, btn33, btn34 });

		/**
		 * 在某个一级菜单下没有二级菜单的情况，menu这样定义 menu.setButton(new Button[] { mainBtn1,
		 * mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}
}