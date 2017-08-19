package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class SaveLandlordRequest extends DemoCommon{
	/**
	 * 编辑保存房东信息
	 * @param contractId    合同ID
	 * @param uticket
	 * @param landlordCardBank   房东卡号开户行
	 * @param landlordCardBankCode    房东卡号银行代码
	 * @param landlordCardNo    房东卡号
	 * @return
	 */
	public String getSaveLandlordResponse(String contractId,String uticket,String landlordCardBank,String landlordCardBankCode,String landlordCardNo){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("contractId", contractId);
			pars.put("landlordCardBank", landlordCardBank);
			pars.put("landlordCardBankCode", landlordCardBankCode);
			pars.put("landlordCardNo", landlordCardNo);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/payRent/saveLandlord.rest", pars);
	}
}
