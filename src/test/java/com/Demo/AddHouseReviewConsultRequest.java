package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class AddHouseReviewConsultRequest extends DemoCommon{
	/**
	 * 房源评价用户咨询接口(From5.5)
	 * @param agentId   经纪人Id
	 * @param uticket
	 * @param houseId   房源Id
	 * @param publishId   房源发布Id
	 * @param reviewId    评论Id
	 * @return
	 */
	public String getAddHouseReviewConsultResponse(String agentId,String uticket,String houseId,String publishId,String reviewId){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("agentId", agentId);
			pars.put("houseId", houseId);
			pars.put("publishId", publishId);
			pars.put("reviewId", reviewId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/agent/addHouseReviewConsult.rest", pars);
	}
}
