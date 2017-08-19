package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.HouseEventsRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class HouseEventsRequestTest {
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
  public void getHouseEventsResponse() {
	  String result = new HouseEventsRequest().getHouseEventsResponse("2", uticket, "1700250", "3333", "22", "", "0", "10");
    System.out.println(result);
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
