package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class SecondHouseRecommendRequest extends DemoCommon{
	/**
	 * 首页猜你喜欢（v5.5更新）
	 * @param pageNum   页码  默认第一页  每页5条 最多4页  即20条
	 * @param uticket
	 * @return
	 */
	public String getSecondHouseRecommendResponse(String pageNum,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("pageNum", pageNum);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/homePage/getSecondHouseRecommenList.rest", pars);
	}
}
