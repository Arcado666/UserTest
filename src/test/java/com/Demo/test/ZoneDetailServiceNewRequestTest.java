package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.ZoneDetailServiceNewRequest;
import com.qiang.utils.FormJSON;
import com.qiang.utils.UseProperties;

public class ZoneDetailServiceNewRequestTest {
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
  public void getZoneDetailServiceNewResponse() {
    String result = new ZoneDetailServiceNewRequest().getZoneDetailServiceNewResponse("60075", uticket, "1", "", "");
    System.err.println(FormJSON.format(result));
  }
}
