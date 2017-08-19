package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class SearchHousePriceRequest extends DemoCommon{
	/**
	 * 查房价页面(From5.7)
	 * @param cityId  城市Id
	 * @param areaId  区域Id
	 * @return
	 */
	public String getSearchHousePriceResponse(String cityId,String areaId){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("cityId", cityId);
			pars.put("areaId", areaId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/housePrice/searchHousePrice.rest", pars);
	}
}
