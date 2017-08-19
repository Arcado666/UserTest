package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.SecondHouseRecommendRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class SecondHouseRecommendRequestTest {
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
  public void getSecondHouseRecommendResponse() {
    String result = new SecondHouseRecommendRequest().getSecondHouseRecommendResponse("1", uticket);
    Assert.assertFalse(CommonUtils.parseJson("recommendId", result).equals(""));
    Assert.assertFalse(CommonUtils.parseJson("hasNextPage", result).equals("true"));
  }
}
