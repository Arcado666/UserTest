package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class HtmlResourceVersionRequest extends DemoCommon{
	/**
	 * html资源文件版本控制
	 * @param netType
	 * @param version
	 * @return
	 */
	public String getHtmlResourceVersionResponse(String netType,String version){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("netType", netType);
			pars.put("version", version);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/About/htmlResourceVersion.rest", pars);
	}
}
