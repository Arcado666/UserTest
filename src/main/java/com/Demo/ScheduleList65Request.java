package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;
import com.qiang.utils.FormJSON;

public class ScheduleList65Request extends DemoCommon{
	/**
	 * 看房日程一级页面（From6.5）
	 * @param uticket
	 * @return
	 */
	public String getScheduleList65Response(String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/schedule/getSchedules65.rest", pars);
	}
	public static void main(String[] args) {

		System.out.println(FormJSON.format(new ScheduleList65Request().getScheduleList65Response("ME9OSGFQMWNZTjAlQCVkY2I5MjU3YTY0MzhkYjI2ODExZThkYWI0NTk0NmU1OQ==")));
	}

}
