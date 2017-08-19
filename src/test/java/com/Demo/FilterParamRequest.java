package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class FilterParamRequest extends DemoCommon{
	/**
	 * 根据城市获取筛选属性
	 * @param city   城市名 如：北京、上海，也可以传cityID 比如上海city=2
	 * @return
	 */
	public String getFilterParamResponse(String city){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("city", city);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/Search/filterParam.rest", pars);
	}
}
