package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class MyAgentRequest extends DemoCommon{
	/**
	 *  经纪人记录相关（带看 or 成交）
	 * @param uticket
	 * @param agentId    //经纪人Id
	 * @param pageSize   每次加载20条数据
	 * @param offSet   //数据偏移量
	 * @param houseType   //房屋类型 1 出租 2出售 3 新房 0全部 用户记录页初始化    只下发一种类型业务数据
	 * @param recordType   //业务类型 1带看 2成交 0经纪人详情页带看&&成交
	 * @return
	 */
	public String getMyAgentResponse(String uticket,String agentId,String pageSize ,String offSet,String houseType,String recordType){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("agentId", agentId);
			pars.put("pageSize", pageSize);
			pars.put("offSet ", offSet );
			pars.put("houseType", houseType);
			pars.put("recordType", recordType);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/agent/getAgentRecord.rest", pars);
	}
	public static void main(String[] args) {
		System.out.println(new MyAgentRequest().getMyAgentResponse("UmdjSUtSOVFtTEElQCUxNTMyMzBjYmE4NGMzYzdjYmQ2MTQxY2ZjZDUwNTQyYw==","55250", "", "", "2", "0"));

	}

}
