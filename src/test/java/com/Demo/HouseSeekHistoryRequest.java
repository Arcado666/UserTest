package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class HouseSeekHistoryRequest extends DemoCommon{
	/**
	 * 获取带看记录相关 From app5.6
	 * @param bizType   //业务类型 1租房 2二手房 
	 * @param uticket   
	 * @param houseId   //房屋id
	 * @param publishId    //发布id
	 * @param publishTime  //发布时间
	 * @param offset  //偏移量
	 * @param pageSize  //每页条数
	 * @return
	 */
	public String getHouseSeekHistoryResponse(String bizType,String uticket,String houseId,String publishId,String publishTime,String offset,String pageSize){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("bizType", bizType);
			pars.put("houseId", houseId);
			pars.put("publishId", publishId);
			pars.put("publishTime", publishTime);
			pars.put("offset", offset);
			pars.put("pageSize", pageSize);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/House/getHouseSeekHistory.rest", pars);
	}
}
