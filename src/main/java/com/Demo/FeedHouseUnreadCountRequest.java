package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class FeedHouseUnreadCountRequest extends DemoCommon{
	/**
	 * 获取关注房源列表里面的小红点(From5.6)
	 * @param rentOrSale  //租售类型 0-出租；1-二手房
	 * @param uticket
	 * @return
	 */
	public String getFeedHouseUnreadCountResponse(String rentOrSale,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("rentOrSale", rentOrSale);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/notice/getFeedHouseUnreadCount.rest", pars);
	}
}
