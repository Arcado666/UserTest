package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class GetBigHomePageInfoRequest extends DemoCommon{
	/**
	 * 获取大首页
	 * @param cityId
	 * @param uticket
	 * @return
	 */
	public String getGetBigHomePageInfoResponse(String cityId,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("cityId", cityId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/homePage/getBigHomePageInfo.rest", pars);
	}
}
