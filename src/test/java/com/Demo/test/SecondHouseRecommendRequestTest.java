package com.Demo.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.SecondHouseRecommendRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class SecondHouseRecommendRequestTest {
	public static final Logger LOGGER = Logger.getLogger(SecondHouseRecommendRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	@BeforeClass
	public void getPorperties() {
		LOGGER.info("首页猜你喜欢--->>>");
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		}
  @Test
  public void getSecondHouseRecommendResponse() {
    String result = new SecondHouseRecommendRequest().getSecondHouseRecommendResponse("1", uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    Assert.assertFalse(CommonUtils.parseJson("recommendId", result).equals(""));
    Assert.assertFalse(CommonUtils.parseJson("hasNextPage", result).equals("true"));
  }
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---首页猜你喜欢");
  }
}
