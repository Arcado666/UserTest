package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class PayRentOrderListRequest extends DemoCommon{
	/**
	 * 交房租订单列表接口
	 * @param pageSize
	 * @param uticket
	 * @param offSet
	 * @return
	 */
	public String getPayRentOrderResponse(String pageSize,String uticket,String offSet){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("pageSize", pageSize);
			pars.put("offSet", offSet);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/payRent/payRentOrderList.rest", pars);
	}
}
