package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class OnekeyAppointmentRequest extends DemoCommon{
	/**
	 * 一键约看（From 5.6）
	 * @param username  //用户称呼
	 * @param uticket   
	 * @param gender    //性别 1：男，2：女 3:保密
	 * @param houseId    //约看房屋Id
	 * @param rentOrSale  // 约看房屋类型 0-租房 1-二手房
	 * @param cityId   //城市ID
	 * @param agentId   //经纪人Id
	 * @return
	 */
	public String getOnekeyAppointmentResponse(String username,String uticket,String gender,String houseId,String rentOrSale,String cityId,String agentId){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("username", username);
			pars.put("gender", gender);
			pars.put("houseId", houseId);
			pars.put("rentOrSale", rentOrSale);
			pars.put("cityId", cityId);
			pars.put("agentId", agentId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/House/onekeyAppointment.rest", pars);
	}
}
