package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class LayoutDetailRequest extends DemoCommon{
	/**
	 * 获取楼盘户型详情（From 5.7）
	 * @param layoutId // 楼盘户型ID
	 * @param houseId   //楼盘ID
	 * @return
	 */
	public String getLayoutDetailResponse(String layoutId,String houseId){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("layoutId", layoutId);
			pars.put("houseId", houseId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/newHouse/getLayoutDetail.rest", pars);
	}
}
