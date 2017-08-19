package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class BillListRequest extends DemoCommon{
	/**
	 * 账单列表接口
	 * @param orderId   合同ID
	 * @param uticket
	 * @param pageSize  每次加载20条数据
	 * @param offSet   数据偏移量
	 * @return
	 */
	public String getBillListResponse(String orderId,String uticket,String pageSize,String offSet){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("orderId", orderId);
			pars.put("pageSize", pageSize);
			pars.put("offSet", offSet);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/payRent/billList.rest", pars);
	}
}
