package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class OrderDetailRequest extends DemoCommon{
	/**
	 * 订单详细页接口（5.3更新）
	 * @param orderId 订单ID
	 * @param uticket
	 * @param type  业务类型1：出租，2：房管房，3：二手房
	 * @return
	 */
	public String getOrderDetailResponse(String orderId,String uticket,String type){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("orderId", orderId);
			pars.put("type", type);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/order/orderDetail.rest", pars);
	}
}
