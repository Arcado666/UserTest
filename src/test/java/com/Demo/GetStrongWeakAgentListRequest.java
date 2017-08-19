package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.Model.GetStrongWeakAgentListModel;
import com.qiang.httpClient.HttpPostClient;

public class GetStrongWeakAgentListRequest extends DemoCommon{
	/**
	 * 查看推荐安装经纪人列表（v5.7更新）
	 * @param uticket
	 * @return
	 */
	public String getGetStrongWeakAgentListResponse(String uticket,GetStrongWeakAgentListModel list){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
		 pars.put("bizType", list.getBizType());
		 pars.put("type", list.getType());
		 pars.put("houseId", list.getHouseId());
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/agent/getInstallAgent.rest", pars);
	}
}
