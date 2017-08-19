package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class CollectionEstateListByTypeRequest extends DemoCommon{
	/**
	 * 根据类型获取关注的小区列表（租房、二手房）(From5.6)
	 * @param pageSize   每次加载10条数据
	 * @param uticket   
	 * @param offSet    数据偏移量
	 * @param rentOrSale  租售类型 0-租房 1-二手房   -1全部查询
	 * @return
	 */
	public String getCollectionEstateListByTypeResponse(String pageSize,String uticket,String offSet,String rentOrSale){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("pageSize", pageSize);
			pars.put("offSet", offSet);
			pars.put("rentOrSale", rentOrSale);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/collection/getCollEstateListByType.rest", pars);
	}
}
