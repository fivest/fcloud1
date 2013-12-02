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
		String appId = "wx1d9a33135bcb4560";
		// 第三方用户唯一凭证密钥
		String appSecret = "c606b9c3701a7f29e1efae3b9ec101d8";

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
		btn11.setName("会议简介");
		btn11.setType("view");
		btn11.setUrl("http://219.134.186.37/wechat/app/cihezh/hyjj");

		ViewButton btn12 = new ViewButton();
		btn12.setName("会议议程");
		btn12.setType("view");
		btn12.setUrl("http://219.134.186.37/wechat/app/cihezh/hyyc");
		
		ViewButton btn13 = new ViewButton();
		btn13.setName("展会平面图");
		btn13.setType("view");
		btn13.setUrl("http://219.134.186.37/public/app/cihezh/zhpmt.jsp");
		
		ViewButton btn14 = new ViewButton();
		btn14.setName("参展商报名");
		btn14.setType("view");
		btn14.setUrl("http://219.134.186.37/wechat/app/cihezh/canzhanshang/create");
		
		ViewButton btn21 = new ViewButton();
		btn21.setName("首席赞助");
		btn21.setType("view");
		btn21.setUrl("http://219.134.186.37/wechat/app/cihezh/sxzz");

		ViewButton btn22 = new ViewButton();
		btn22.setName("开幕式赞助");
		btn22.setType("view");
		btn22.setUrl("http://219.134.186.37/wechat/app/cihezh/kmszz");
		
		ViewButton btn23 = new ViewButton();
		btn23.setName("联合赞助");
		btn23.setType("view");
		btn23.setUrl("http://219.134.186.37/wechat/app/cihezh/lhzz");

		ViewButton btn31 = new ViewButton();
		btn31.setName("交通指引");
		btn31.setType("view");
		btn31.setUrl("http://219.134.186.37/public/app/cihezh/jtzy.jsp");
		
		ViewButton btn32 = new ViewButton();
		btn32.setName("联系方式");
		btn32.setType("view");
		btn32.setUrl("http://219.134.186.37/wechat/app/cihezh/lxfs");

		ViewButton btn33 = new ViewButton();
		btn33.setName("展会反馈");
		btn33.setType("view");
		btn33.setUrl("http://219.134.186.37/wechat/app/cihezh/zhanhfk/create");
		
		CommonButton btn34 = new CommonButton();
		btn34.setName("展会墙");
		btn34.setType("click");
		btn34.setKey("zhq");
		
		ComplexButton mainBtn1 = new ComplexButton();
		mainBtn1.setName("展会介绍");
		mainBtn1
				.setSub_button(new Button[] { btn11, btn12, btn13, btn14});		
		
		ComplexButton mainBtn2 = new ComplexButton();
		mainBtn2.setName("展会赞助");
		mainBtn2
				.setSub_button(new Button[] { btn21, btn22, btn23});
		
		ComplexButton mainBtn3 = new ComplexButton();
		mainBtn3.setName("展会信息");
		mainBtn3
				.setSub_button(new Button[] { btn31, btn32, btn33, btn34});

		/**
		 * 在某个一级菜单下没有二级菜单的情况，menu这样定义 menu.setButton(new Button[] { mainBtn1,
		 * mainBtn2, btn33 });
		 */
		Menu menu = new Menu();
		menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

		return menu;
	}
}