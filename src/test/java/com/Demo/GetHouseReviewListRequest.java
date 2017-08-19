package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class GetHouseReviewListRequest extends DemoCommon{
	/**
	 * 获取房源房评列表接口(From5.5)
	 * @param houseId  房源Id
	 * @param uticket
	 * @param publishId  房源发布Id
	 * @param pageSize   每次加载10条数据
	 * @param offset    数据偏移量，减去置顶评论后的偏移量
	 * @return
	 */
	public String getGetHouseReviewListResponse(String houseId,String uticket,String publishId,String pageSize,String offset){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("houseId", houseId);
			pars.put("publishId", publishId);
			pars.put("pageSize", pageSize);
			pars.put("offset", offset);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/agent/getHouseReviewList.rest", pars);
	}
}
