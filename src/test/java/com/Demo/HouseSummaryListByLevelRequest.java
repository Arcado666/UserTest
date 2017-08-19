package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.Model.HouseMarkByLevelModel;
import com.qiang.httpClient.HttpPostClient;

public class HouseSummaryListByLevelRequest extends DemoCommon{
	/**
	 * 地图可视范围内的房源列表（v5.5，v6.6,v6.7更新）
	 * @param HouseMarkByLevel
	 * @param uticket
	 * @return
	 */
	public String getHouseSummaryListByLevelResponse(HouseMarkByLevelModel HouseMarkByLevel,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("offset", HouseMarkByLevel.getOffset());
			pars.put("sort", HouseMarkByLevel.getSort());
			pars.put("sequence", HouseMarkByLevel.getSequence());
			pars.put("pageSize", HouseMarkByLevel.getPageSize());
			pars.put("rentOrSale", HouseMarkByLevel.getRentOrSale());
			pars.put("level", HouseMarkByLevel.getLevel());
			pars.put("city", HouseMarkByLevel.getCity());
			pars.put("latlonArray", HouseMarkByLevel.getLatlonArray());
			pars.put("lat", HouseMarkByLevel.getLat());
			pars.put("lon", HouseMarkByLevel.getLon());
			pars.put("sequence", HouseMarkByLevel.getSequence());
			pars.put("rentOrBrand", HouseMarkByLevel.getRentOrBrand());
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/Map/houseSummaryListByLevel.rest", pars);
	}
	public String getHouseSummaryListByLevelResponse2(HouseMarkByLevelModel HouseMarkByLevel,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("offset", HouseMarkByLevel.getOffset());
			pars.put("sort", HouseMarkByLevel.getSort());
			pars.put("latlonArray", HouseMarkByLevel.getLatlonArray());
			pars.put("pageSize", HouseMarkByLevel.getPageSize());
			pars.put("rentOrSale", HouseMarkByLevel.getRentOrSale());
			pars.put("level", HouseMarkByLevel.getLevel());
			pars.put("city", HouseMarkByLevel.getCity());
			pars.put("lon", HouseMarkByLevel.getLon());
			pars.put("lat", HouseMarkByLevel.getLat());
			pars.put("sequence", HouseMarkByLevel.getSequence());
			pars.put("rentOrBrand", HouseMarkByLevel.getRentOrBrand());
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/Map/houseSummaryListByLevel.rest", pars);
	}
}
