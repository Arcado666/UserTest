package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class SubmitLoanRequest extends DemoCommon{
	/**
	 * 提交贷款申请（From5.5）
	 * @param cityId     城市ID
	 * @param uticket    
	 * @param loanType   贷款类型 1-赎楼贷；2-消费贷；3-尾款贷；4-置换;5-其他;6-按揭
	 * @param loanAmount   贷款金额 单位元
	 * @param loanTerm   贷款期限（天数）
	 * @param realName   /姓名
	 * @param mobile    手机号码
	 * @return
	 */
	public String getSubmitLoanResponse(String cityId,String uticket,String loanType,String loanAmount,String loanTerm,String realName,String mobile){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("cityId", cityId);
			pars.put("loanType", loanType);
			pars.put("loanAmount", loanAmount);
			pars.put("loanTerm", loanTerm);
			pars.put("realName", realName);
			pars.put("mobile", mobile);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/loan/submitLoan.rest", pars);
	}
}
