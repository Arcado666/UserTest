package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class HousePriceTipsSearchRequest extends DemoCommon{
	/**
	 * 查房价tips搜索(From5.7)
	 * @param cityId   城市id
	 * @param uticket
	 * @param keyword   // 关键词
	 * @return
	 */
	public String getHousePriceTipsResponse(String cityId,String keyword){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("cityId", cityId);
			pars.put("keyword", keyword);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/housePrice/housePriceTipsSearch.rest", pars);
	}
	public static void main(String[] args) {
		System.out.println(new HousePriceTipsSearchRequest().getHousePriceTipsResponse("2", "永和"));

	}

}
