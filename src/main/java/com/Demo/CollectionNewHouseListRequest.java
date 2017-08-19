package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class CollectionNewHouseListRequest extends DemoCommon{
	/**
	 * 新房关注列表（From5.7）
	 * @param uticket
	 * @param pageSize    //每次加载10条数据
	 * @param offSet    //数据偏移量
	 * @return
	 */
	public String getCollectionNewHouseListResponse(String uticket,String pageSize,String offSet){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("pageSize", pageSize);
			pars.put("offSet", offSet);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/collection/getCollNewHouseList.rest", pars);
	}
}
