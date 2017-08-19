package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.setAllHouseFeedReadRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class setAllHouseFeedReadRequestTest {
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	String result;
	@BeforeClass
	public void getPorperties() {
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		}
  @Test
  public void getsetAllHouseFeedReadResponse() {
	  result = new setAllHouseFeedReadRequest().getsetAllHouseFeedReadResponse(uticket);
	  Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
