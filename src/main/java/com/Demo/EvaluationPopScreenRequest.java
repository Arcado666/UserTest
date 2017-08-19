package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class EvaluationPopScreenRequest extends DemoCommon{
	/**
	 * 日程的评价弹窗初始化接口(v5.8更新)
	 * @param appointmentId   约会ID
	 * @param uticket
	 * @param appointmentCode  短链时传的加密后约会ID
	 * @param bizType   业务类型 1：租房，2：二手房
	 * @return
	 */
	public String getEvaluationPopScreenResponse(String appointmentId,String uticket,String appointmentCode,String bizType){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("appointmentId", appointmentId);
			pars.put("appointmentCode", appointmentCode);
			pars.put("bizType", bizType);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/schedule/evaluationPopScreenInit.rest", pars);
	}
}
