package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class BindRecommenderRequest extends DemoCommon{
	/**
	 * 绑定推荐人(From5.8)
	 * @param recommendId   推荐人的Id
	 * @param uticket
	 * @param recommendIdType   推荐人的Id类型 1：阿姨，2：经纪人，3：用户bindRecommender
	 * @return
	 */
	public String getBindRecommenderResponse(String recommendId,String uticket,String recommendIdType){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("recommendId", recommendId);
			pars.put("recommendIdType", recommendIdType);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/scan/bindRecommender.rest", pars);
	}
	
	public static void main(String[] args){
		System.out.println(new BindRecommenderRequest().getBindRecommenderResponse("318936", "UmdjSUtSOVFtTEElQCUxNTMyMzBjYmE4NGMzYzdjYmQ2MTQxY2ZjZDUwNTQyYw==", "3"));
	}
}
