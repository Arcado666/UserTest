package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.MortgageCalcRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class MortgageCalcRequestTest {
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	@BeforeClass
	public void getPorperties() {
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		}
  @Test
  public void getMortgageCalcResponse() {
	  String result = new MortgageCalcRequest().getMortgageCalcResponse(userId, uticket, "2");
	  Assert.assertNotNull(CommonUtils.parseJson("provFundInter", result));
	  Assert.assertNotNull(CommonUtils.parseJson("commerLoanInter", result));
	  Assert.assertNotNull(CommonUtils.parseJson("provFundMoney", result));
	  Assert.assertNotNull(CommonUtils.parseJson("commerLoanMoney", result));
	  Assert.assertNotNull(CommonUtils.parseJson("normalProcent", result));
	  Assert.assertNotNull(CommonUtils.parseJson("provFundRateTimes", result));
  }
}
