package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class ZoneHouseMiniRequest extends DemoCommon{
	/**
	 * 获取小区租售房源列表 && 关注带看次数
	 * @param esateId  小区ID
	 * @param uticket
	 * @param bizType    0-租售；1-租房；2-二手房 
	 * @param rentOrSale     租售类型：0-租房；1-二手房  3 品牌公寓
	 * @return
	 */
	public String getZoneHouseMiniResponse(String esateId,String uticket,String bizType,String rentOrSale){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("esateId", esateId);
			pars.put("bizType", bizType);
			pars.put("rentOrSale", rentOrSale);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/House/zoneHouseMini.rest", pars);
	}
}
