package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;
//获取我的经纪人接口
public class MySHAgentRequest extends DemoCommon{
	/**
	 * 获取我的经纪人接口
	 * @param url
	 * @param userId
	 * @param uticket
	 * @return
	 */
	public String getMySHAgentResponse(String userId,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("userId", userId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/user/mySHAgent.rest", pars);
	}
	public static void main(String[] args) {

		System.out.println(new MySHAgentRequest().getMySHAgentResponse("2070809", "TmFmejhrcDhybHMlQCVhMDY0ZjdhZmI3ZDk4NWI1MjdhOGVlZTIxODliMDhjZg=="));
	}
}
