package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.FeedHouseUnreadCountRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.FormJSON;
import com.qiang.utils.UseProperties;

public class FeedHouseUnreadCountRequestTest {
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
  public void getFeedHouseUnreadCountResponse() {
	  String result = new FeedHouseUnreadCountRequest().getFeedHouseUnreadCountResponse("1", uticket);
	  System.out.println(FormJSON.format(result));
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
