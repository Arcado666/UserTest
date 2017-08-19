package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class BannerListRequest extends DemoCommon{
	/**
	 * banner查询接口(From5.5)
	 * @param btype  banner类型 0-普通banner，1-爱理财bannner，3-头条，4-贷总管，6-交房租
	 * @param uticket
	 * @return
	 */
	public String getBannerListResponse(String btype,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("btype", btype);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/cms/bannerList.rest", pars);
	}
}
