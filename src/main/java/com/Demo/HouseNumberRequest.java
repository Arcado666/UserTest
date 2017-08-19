package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class HouseNumberRequest extends DemoCommon{
	/**
	 * 获取二手房详情浏览次数、关注次数
	 * @param houseId
	 * @return
	 */
	public String getHouseNumberResponse(String houseId){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("houseId", houseId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/House/getHouseNumbers.rest", pars);
	}
}
