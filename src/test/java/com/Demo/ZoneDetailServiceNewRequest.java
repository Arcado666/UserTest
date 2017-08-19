package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class ZoneDetailServiceNewRequest extends DemoCommon{
	/**
	 * 获取小区基本信息
	 * @param esateId  小区ID
	 * @param uticket
	 * @param rentOrSale   0-租售；1-租房；2-二手房  -1 所有（用于关注查询）
	 * @param lat   纬度
	 * @param lon   经度
	 * @return
	 */
	public String getZoneDetailServiceNewResponse(String esateId,String uticket,String rentOrSale,String lat,String lon){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("esateId", esateId);
			pars.put("rentOrSale", rentOrSale);
			pars.put("lat", lat);
			pars.put("lon", lon);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/House/zoneDetailServiceNew.rest", pars);
	}
}
