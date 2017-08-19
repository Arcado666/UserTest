package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class AreaDataServiceRequest extends DemoCommon{
	/**
	 * 获取区域/板块列表
	 * @param city 选择的城市
	 * @return
	 */
	public String getAreaDataServiceResponse(String city){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("city", city);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/Search/areaDataService.rest", pars);
	}
	/**
	 * 
	 * @param city 选择的城市
	 * @param rentOrSale  租售类型：0-租房；1-二手房；2-新房
	 * @return
	 */
	public String getAreaDataServiceResponse(String city,String rentOrSale ){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("city", city);
			pars.put("rentOrSale", rentOrSale);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/Search/areaDataService.rest", pars);
	}
}
