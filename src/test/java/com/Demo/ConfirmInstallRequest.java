package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class ConfirmInstallRequest extends DemoCommon{
	/**
	 * 确认推荐安装经纪人(v5.7更新)
	 * @param agentId  经纪人Id
	 * @param uticket
	 * @param loginTime  确认时间戳
	 * @return
	 */
	public String getConfirmInstallResponse(String agentId,String uticket,String loginTime){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("agentId", agentId);
			pars.put("loginTime", loginTime);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/agent/confirmInstallAgent.rest", pars);
	}
}
