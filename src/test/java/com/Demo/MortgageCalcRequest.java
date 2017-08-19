package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class MortgageCalcRequest extends DemoCommon{
	/**
	 * 读取用户房贷计算记录(5.2更新)
	 * @param userId
	 * @param uticket
	 * @param cityId
	 * @return
	 */
	public String getMortgageCalcResponse(String userId,String uticket,String cityId){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("userId", userId);
			pars.put("cityId", cityId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/House/getMortgageCalculator.rest", pars);
	}
}
