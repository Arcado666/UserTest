package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.Model.HouseMarkByLevelModel;
import com.qiang.httpClient.HttpPostClient;

public class HouseSummaryListByEstateIdRequest extends DemoCommon {
	/**
	 * 小区房源列表(v5.6,V6.6,V6.7更新)
	 * @param HouseMarkByLevel
	 * @param uticket
	 * @return
	 */
	public String getHouseSummaryListByEstateIdResponse(HouseMarkByLevelModel HouseMarkByLevel, String uticket) {
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		Map<String, Object> pars = new HashMap<String, Object>();
		pars.put("city", HouseMarkByLevel.getCity());
		pars.put("rentOrSale", HouseMarkByLevel.getRentOrSale());
		pars.put("sort", HouseMarkByLevel.getSort());
		pars.put("level", HouseMarkByLevel.getLevel());
		pars.put("areaId", HouseMarkByLevel.getAreaId());
		pars.put("lon", HouseMarkByLevel.getLon());
		pars.put("lat", HouseMarkByLevel.getLat());
		pars.put("offset", HouseMarkByLevel.getOffset());
		pars.put("sequence", HouseMarkByLevel.getSequence());
		pars.put("pageSize", HouseMarkByLevel.getPageSize());
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars, new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://" + DemoCommon.url + "/ihouse/Map/houseSummaryListByEstateId.rest",
				pars);
	}
}
