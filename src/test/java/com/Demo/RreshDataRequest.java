package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;
//获取最新全局数据接口（更新v6.4）
public class RreshDataRequest extends DemoCommon{
	/**
	 * 获取最新全局数据接口
	 * @param url
	 * @param userId
	 * @param uticket
	 * @return
	 */
	public String getRreshDataResponse(String userId,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("userId", userId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/user/freshData.rest", pars);
	}
}
