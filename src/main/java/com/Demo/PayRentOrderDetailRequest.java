package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class PayRentOrderDetailRequest extends DemoCommon{
	/**
	 * 合同详情接口
	 * @param contractId  合同ID
	 * @param uticket
	 * @param type   业务类型1：出租，2：房管房，3：出售
	 * @return
	 */
	public String getPayRentOrderDetailResponse(String contractId,String uticket,String type){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("contractId", contractId);
			pars.put("type", type);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/payRent/contractDetail.rest", pars);
	}
}
