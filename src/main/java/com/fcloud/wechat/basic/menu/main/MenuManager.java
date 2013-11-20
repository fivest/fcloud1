package com.fcloud.wechat.basic.menu.main;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fcloud.wechat.basic.menu.bean.AccessToken;
import com.fcloud.wechat.basic.menu.bean.Button;
import com.fcloud.wechat.basic.menu.bean.CommonButton;
import com.fcloud.wechat.basic.menu.bean.ComplexButton;
import com.fcloud.wechat.basic.menu.bean.Menu;
import com.fcloud.wechat.basic.menu.bean.ViewButton;
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
		ViewButton btn11 = new ViewButton();
		btn11.setName("故障上报");
		btn11.setType("view");
		btn11.setUrl("http://fcloud.duapp.com/wechat/app/sccn/errReport");


		ViewButton btn21 = new ViewButton();
		btn21.setName("故障处理");
		btn21.setType("view");
		btn21.setUrl("http://fcloud.duapp.com/wechat/app/sccn/errProcess");


		ViewButton btn31 = new ViewButton();
		btn31.setName("关于我们");
		btn31.setType("view");
		btn31.setUrl("http://fcloud.duapp.com/wechat/app/sccn/about");

		ViewButton btn32 = new ViewButton();
		btn32.setName("账号绑定");
		btn32.setType("view");
		btn32.setUrl("http://fcloud.duapp.com/wechat/app/sccn/bind");

		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("关于");
		mainBtn3
				.setSub_button(new ViewButton[] { btn31, btn32});

		/**
		 * 在某个一级菜单下没有二级菜单的情况，menu这样定义 menu.setButton(new Button[] { mainBtn1,
		 * mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { btn11, btn21, mainBtn3 });

		return menu;
	}
}