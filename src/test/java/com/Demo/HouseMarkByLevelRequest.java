package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.Model.HouseMarkByLevelModel;
import com.qiang.httpClient.HttpPostClient;

public class HouseMarkByLevelRequest extends DemoCommon{
	/**
	 * 根据地图层级获取打点数据
	 * @param HouseMarkByLevel  参数
	 * @param uticket
	 * @return
	 */
	public String getHouseMarkByLevelResponse(HouseMarkByLevelModel HouseMarkByLevel,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("city", HouseMarkByLevel.getCity());
			pars.put("rentOrSale", HouseMarkByLevel.getRentOrSale());
			pars.put("latlonArray", HouseMarkByLevel.getLatlonArray());
			pars.put("level", HouseMarkByLevel.getLevel());
			pars.put("flag", HouseMarkByLevel.getFlag());
			pars.put("lon", HouseMarkByLevel.getLon());
			pars.put("lat", HouseMarkByLevel.getLat());
			pars.put("stationId", HouseMarkByLevel.getStationId());
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/Map/houseMarkByLevel.rest", pars);
	}
}
