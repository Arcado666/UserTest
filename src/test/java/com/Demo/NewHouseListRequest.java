package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class NewHouseListRequest extends DemoCommon{
	/**
	 * 获取新房列表
	 * @param uticket
	 * @param offset // 已看多少条
	 * @param pageSize // 每页显示多少行
	 * @param city  // 省分ID
	 * @param areaId // 区域ID
	 * @param subwayNo  // 地铁线ID
	 * @param stationId  //地铁站id
	 * @param rooms // 用于过滤房源的房间数目
	 * @param lowPrice  // 最低价  100
	 * @param highPrice  // 最高价  200
	 * @param tipsType  1区域 2板块 3小区名 4地铁线 5地铁站 6小区别名 7小区地址 8学校全名 9学校常用名 10学校别名 11新房名 12新房别名 
	 * @param key   // 搜索关键字
	 * @param rentOrSale  // 租售类型：0-租房；1-二手房；2-新房
	 * @param wt    //房产类型  1 住宅 2别墅 3商住 4 商铺
	 * @return
	 */
	public String getNewHouseListResponse(String uticket,String offset,String pageSize,String city,String areaId,String subwayNo,String stationId,String rooms
			,String lowPrice,String highPrice,String tipsType,String key,String rentOrSale,String wt){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("offset", offset);
			pars.put("pageSize", pageSize);
			pars.put("city", city);
			pars.put("areaId", areaId);
			pars.put("subwayNo", subwayNo);
			pars.put("stationId", stationId);
			pars.put("lowPrice", lowPrice);
			pars.put("highPrice", highPrice);
			pars.put("tipsType", tipsType);
			pars.put("key", key);
			pars.put("rentOrSale", rentOrSale);
			pars.put("wt", wt);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/newHouse/getNewHouseList.rest", pars);
	}
}
