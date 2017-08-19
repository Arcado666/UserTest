package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class Iwjwh5urlRequest extends DemoCommon{
	/**
	 * html地址统一下发接口
	 * @return
	 */
	public String getIwjwh5urlResponse(){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/About/iwjwh5url.rest", pars);
	}
}
