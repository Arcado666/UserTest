package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class EsateHousePriceListRequest extends DemoCommon{
	/**
	 * 城市小区参考房价列表(From5.7)
	 * @param cityId   城市Id
	 * @param uticket
	 * @param areaId   区域板块Id
	 * @param areaType  区域类型 1-区域 2-板块
	 * @param pageSize   每次加载20条数据
	 * @param offset   数据偏移量
	 * @return
	 */
	public String getEsateHousePriceListResponse(String cityId,String uticket,String areaId,String areaType,String pageSize ,String offset){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("cityId", cityId);
			pars.put("areaId", areaId);
			pars.put("areaType", areaType);
			pars.put("pageSize", pageSize);
			pars.put("offset", offset);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/housePrice/esateHousePriceList.rest", pars);
	}
}
