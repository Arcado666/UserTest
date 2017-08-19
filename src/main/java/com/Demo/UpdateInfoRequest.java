package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class UpdateInfoRequest extends DemoCommon{
	/**
	 * 获取更新信息接口（update 5.7）
	 * @param channel 终端类型 1：android 2：iphone
	 * @param uticket
	 * @param type 渠道号
	 * @return
	 */
	public String getUpdateInfoResponse(String channel,String uticket,String type){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("channel", channel);
			pars.put("type", type);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/user/updateInfo.rest", pars);
	}
}
