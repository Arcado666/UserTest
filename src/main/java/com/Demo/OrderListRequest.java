package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class OrderListRequest extends DemoCommon{
	/**
	 * 订单列表页接口（From 3.1； 5.0、5.2更新）
	 * @param pageSize   每次加载20条数据
	 * @param uticket
	 * @param offSet   数据偏移量
	 * @return
	 */
	public String getOrderListResponse(String pageSize,String uticket,String offSet){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("pageSize", pageSize); 
			pars.put("offSet", offSet);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/order/orderList.rest", pars);
	}
}
