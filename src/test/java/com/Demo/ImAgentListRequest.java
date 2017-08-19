package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class ImAgentListRequest extends DemoCommon{
	/**
	 * 微聊的经纪人或用户列表(v5.8)
	 * @param uticket
	 * @return
	 */
	public String getImAgentListResponse(String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/agent/getImAgentList.rest", pars);
	}
	public static void main(String[] args) {
		System.out.println(new ImAgentListRequest().getImAgentListResponse("UmdjSUtSOVFtTEElQCUxNTMyMzBjYmE4NGMzYzdjYmQ2MTQxY2ZjZDUwNTQyYw=="));

	}

}
