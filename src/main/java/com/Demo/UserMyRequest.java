package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class UserMyRequest extends DemoCommon{
	/**
	 * 获取‘我的’页面信息 接口 (更新5.0、5.2、5.3)
	 * @param userId //用户ID
	 * @param uticket 
	 * @param bizType  // 1 出租， 2 出售
	 * @param cityId   //城市id
	 * @return
	 */
	public String getUserMyResponse(String userId,String uticket,String bizType,String cityId){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("userId", userId);
			pars.put("bizType", bizType);
			pars.put("cityId", cityId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/user/myAgent.rest", pars);
	}
}
