package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class HouseNoticeReadRequest extends DemoCommon{
	/**
	 * 设置单个房源动态为已读（From5.6）
	 * @param houseId //房源Id
	 * @param uticket
	 * @param rentOrSale  //租售类型 0-出租；1-二手房
	 * @return
	 */
	public String getHouseNoticeReadResponse(String houseId,String uticket,String rentOrSale){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("houseId", houseId);
			pars.put("rentOrSale", rentOrSale);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/notice/setNoticeHouseFeedRead.rest", pars);
	}
}
