package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class NotEvaluatedAppointListRequest extends DemoCommon{
	/**
	 * 获取未评价的日程列表(分页用)(From5.6)
	 * @param uticket
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	public String getNotEvaluatedAppointListResponse(String uticket,String offset ,String pageSize){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("offset", offset );
			pars.put("pageSize", pageSize);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/schedule/notEvaluatedAppointList.rest", pars);
	}
}
