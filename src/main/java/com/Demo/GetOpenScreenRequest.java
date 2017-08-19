package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class GetOpenScreenRequest extends DemoCommon{
	/**
	 * 获取开机弹窗相关配置（v5.6更新）
	 * @param uticket
	 * @return
	 */
	public String getGetOpenScreenResponse(String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/homePage/getOpenScreen.rest", pars);
	}
}
