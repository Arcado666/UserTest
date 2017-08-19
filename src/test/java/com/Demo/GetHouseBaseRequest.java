package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class GetHouseBaseRequest extends DemoCommon{
	/**
	 * 房源详情 房源基础信息
	 * @param houseId    房源ID
	 * @param uticket
	 * @param lat   纬度
	 * @param lon   经度
	 * @param esateId   小区ID
	 * @param rentOrSale   租售类型：0-租房；1-二手房
	 * @return
	 */
	public String getGetHouseBaseResponse(String houseId,String uticket,String lat,String lon,String esateId,String rentOrSale){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("houseId", houseId);
			pars.put("lat", lat);
			pars.put("lon", lon);
			pars.put("esateId", esateId);
			pars.put("rentOrSale", rentOrSale);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/House/getHouseBaseInfo.rest", pars);
	}
}
