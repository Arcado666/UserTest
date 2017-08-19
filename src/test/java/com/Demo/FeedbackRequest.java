package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class FeedbackRequest extends DemoCommon{
	/**
	 * 意见反馈接口
	 * @param userId  //用户ID
	 * @param uticket   
	 * @param advice  //意见
	 * @param mobileSn   //手机设备唯一标识，用于（意见反馈无需注册登录即可使用。不过一旦用户登录，这个反馈信息就应绑定到对应账号，以便我们在后台进行查询）
	 * @return
	 */
	public String getFeedbackResponse(String userId,String uticket,String advice,String mobileSn){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("userId", userId);
			pars.put("advice", advice);
			pars.put("mobileSn", mobileSn);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/user/feedback.rest", pars);
	}
	
}
