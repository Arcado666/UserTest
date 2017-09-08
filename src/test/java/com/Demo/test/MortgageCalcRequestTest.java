package com.Demo.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.MortgageCalcRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class MortgageCalcRequestTest {
	public static final Logger LOGGER = Logger.getLogger(MortgageCalcRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	@BeforeClass
	public void getPorperties() {
		LOGGER.info("读取用户房贷计算记录--->>>");
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		}
  @Test
  public void getMortgageCalcResponse() {
	  String result = new MortgageCalcRequest().getMortgageCalcResponse(userId, uticket, "2");
	  if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
	    	LOGGER.error(result);
			throw new RuntimeException(result);
		}
	    LOGGER.info("result="+result+"");
	    LOGGER.info("provFundInter="+CommonUtils.parseJson("provFundInter", result)+"");
	  Assert.assertNotNull(CommonUtils.parseJson("provFundInter", result));
	  LOGGER.info("commerLoanInter="+CommonUtils.parseJson("commerLoanInter", result)+"");
	  Assert.assertNotNull(CommonUtils.parseJson("commerLoanInter", result));
	  LOGGER.info("provFundMoney="+CommonUtils.parseJson("provFundMoney", result)+"");
	  Assert.assertNotNull(CommonUtils.parseJson("provFundMoney", result));
	  LOGGER.info("commerLoanMoney="+CommonUtils.parseJson("commerLoanMoney", result)+"");
	  Assert.assertNotNull(CommonUtils.parseJson("commerLoanMoney", result));
	  LOGGER.info("normalProcent="+CommonUtils.parseJson("normalProcent", result)+"");
	  Assert.assertNotNull(CommonUtils.parseJson("normalProcent", result));
	  LOGGER.info("provFundRateTimes="+CommonUtils.parseJson("provFundRateTimes", result)+"");
	  Assert.assertNotNull(CommonUtils.parseJson("provFundRateTimes", result));
  }
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---读取用户房贷计算记录");
  }
}
