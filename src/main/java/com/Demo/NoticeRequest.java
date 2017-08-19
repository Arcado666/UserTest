package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class NoticeRequest extends DemoCommon{
	/**
	 * 提醒、通知当前数目（From 3.0）（v5.5更新）
	 * @param uticket
	 * @param dataStatus   // 1：获取免打扰的经纪人列表，0不获取
	 * @return
	 */
	public String getNoticeResponse(String uticket,String dataStatus){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("dataStatus", dataStatus);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/notice/getNoticeNums.rest", pars);
	}
	public String getNoticeResponse(String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/notice/getNoticeNums.rest", pars);
	}
}
