package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class ToBeSeePageRequest extends DemoCommon{
	/**
	 * 行程-待看的列表
	 * @param userId
	 * @param uticket
	 * @param offset   //已展现的数据条数
	 * @param pageSize   //每页显示数量
	 * @return
	 */
	public String getToBeSeePageResponse(String userId,String uticket,String offset,String pageSize){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("userId", userId);
			pars.put("offset", offset);
			pars.put("pageSize", pageSize);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/schedule/toBeSee.rest", pars);
	}

	public static void main(String[] args) {
		System.out.println(new ToBeSeePageRequest().getToBeSeePageResponse("2070809", "TmFmejhrcDhybHMlQCVhMDY0ZjdhZmI3ZDk4NWI1MjdhOGVlZTIxODliMDhjZg==", "0", "10"));
	}

}
