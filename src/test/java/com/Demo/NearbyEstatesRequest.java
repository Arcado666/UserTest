package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class NearbyEstatesRequest extends DemoCommon{
	/**
	 * 根据用户坐标获取附近在售信息
	 * @param latitude   //坐标 纬度
	 * @param longitude  //坐标 经度
	 * @return
	 */
	public String getNearbyEstatesResponse(String latitude,String longitude){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("latitude", latitude);
			pars.put("longitude", longitude);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/homePage/getNearbyEstates.rest", pars);
	}
}
