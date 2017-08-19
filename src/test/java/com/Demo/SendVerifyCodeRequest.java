package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

//发送验证码接口（v5.1更新）
public class SendVerifyCodeRequest extends DemoCommon{
	
	public String getVerifyCodeResponse(String mobile){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("mobile", mobile);
			pars.put("type", "0");
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/user/sendVerifyCode.rest", pars);
	}
	
}
