package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

//手机应用登陆验证接口(v5.6、5.9更新)
public class UserLoginRequest extends DemoCommon{
	/**
	 * 登录
	 * @param url
	 * @param mobile   //手机号
	 * @param verifyCode  //验证码
	 * @param mobileSn    //手机设备唯一标识(或GUID)
	 * @param fromPage    //登录来源页面（1-我的；2-房源详情(租房)；3-房源详情（二手房）；4-约看清单；5-看房日程；6-业主委托（2.5版本补上）； 7-委托列表）
	 * @return
	 */
	public String getUserLoginResponse(String mobile,String verifyCode,String mobileSn,String fromPage){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("mobile", mobile);
			pars.put("verifyCode", verifyCode);
			pars.put("mobileSn", mobileSn);
			pars.put("fromPage", fromPage);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/user/userLogin.rest", pars);
	}
}
