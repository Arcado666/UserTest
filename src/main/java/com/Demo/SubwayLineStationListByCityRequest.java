package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class SubwayLineStationListByCityRequest extends DemoCommon{
	/**
	 * 根据城市获取地铁线(包括地铁站)的信息（From 5.6更新）
	 * @param city   城市：上海 如果在地铁模块检索数据,参数为城市在地铁表里的代码 上海：21 ；北京10码
	 * @return
	 */
	public String getSubwayLineStationListByCityResponse(String city){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("city", city);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/Map/subwayLineStationListByCity.rest", pars);
	}
	/**
	 * 根据城市获取地铁线(包括地铁站)的信息（From 5.6更新）
	 * @param city    城市：上海 如果在地铁模块检索数据,参数为城市在地铁表里的代码 上海：21 ；北京10码
	 * @param rentOrSale   租售类型：0-租房；1-二手房 2 新房
	 * @return
	 */
	public String getSubwayLineStationListByCityResponse(String city,String rentOrSale){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("city", city);
			pars.put("rentOrSale", rentOrSale);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/Map/subwayLineStationListByCity.rest", pars);
	}
}
