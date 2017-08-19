package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class CountOpenScreenRequest extends DemoCommon{
	/**
	 * 上报点击弹窗 from 5.6
	 * @param acticityId   //活动id     对应首页弹框的adPopupId
	 * @return
	 */
	public String getCountOpenScreenResponse(String acticityId){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("acticityId", acticityId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/homePage/countOpenScreen.rest", pars);
	}
}
