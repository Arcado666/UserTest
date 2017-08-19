package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.UserPageRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class UserPageRequestTest {
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
		result = new UserPageRequest().getUserPageResponse(userId, "", uticket, "", "", "", "");
		}
  @Test
  public void getUserPageResponse() {
    Assert.assertFalse(CommonUtils.parseJson("scheduleHouseGroup", result).equals(null));
  }
}
