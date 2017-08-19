package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.HouseNoticeReadRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class HouseNoticeReadRequestTest {
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
  public void getHouseNoticeReadResponse() {
	  String result = new HouseNoticeReadRequest().getHouseNoticeReadResponse("17367019", uticket, "1");
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
