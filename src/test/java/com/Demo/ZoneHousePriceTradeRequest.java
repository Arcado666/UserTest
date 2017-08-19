package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class ZoneHousePriceTradeRequest extends DemoCommon{
	/**
	 * 获取房价成交记录 5.5更新
	 * @param esateId  小区ID
	 * @param uticket
	 * @param bizType  0-租售；1-租房；2-二手房
	 * @param pageSize  每次加载20条数据
	 * @param offSet   数据偏移量
	 * @return
	 */
	public String getZoneHousePriceTradeResponse(String esateId,String uticket,String bizType,String pageSize,String offSet){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("esateId", esateId);
			pars.put("bizType", bizType);
			pars.put("pageSize", pageSize);
			pars.put("offSet", offSet);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/House/zoneHousePriceTrade.rest", pars);
	}
}
