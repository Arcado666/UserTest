package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class BillDetailRequest extends DemoCommon{
	/**
	 * 交房租-账单详情（update5.7.1） 
	 * @param billId    账单Id
	 * @param uticket
	 * @param type      业务类型1：出租佣金，2：房管房，3：二手房出售，11出租租金
	 * @return
	 */
	public String getBillDetailResponse(String billId,String uticket,String type){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("billId", billId);
			pars.put("type", type);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/payRent/billDetail.rest", pars);
	}
}
