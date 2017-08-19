package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class AllCollectionsRequest extends DemoCommon{
	/**
	 * 我的关注界面 查看动态 （全部更新列表） 5.5
	 * @param offSet  已看多少条
	 * @param uticket  
	 * @param pageSize   每页显示多少行
	 * @param type   类型：0全部 1上架 2新增视频3调价 4下架 
	 * @return
	 */
	public String getAllCollectionsResponse(String offSet,String uticket,String pageSize,String type){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("offSet", offSet);
			pars.put("pageSize", pageSize);
			pars.put("type", type);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/collection/getAllCollection.rest", pars);
	}
}
