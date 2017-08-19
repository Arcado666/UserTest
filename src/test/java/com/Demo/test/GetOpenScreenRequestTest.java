package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.GetOpenScreenRequest;
import com.qiang.utils.UseProperties;

public class GetOpenScreenRequestTest {
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
  public void getGetOpenScreenResponse() {
    String result = new GetOpenScreenRequest().getGetOpenScreenResponse("");
    System.err.println(result);
  }
  @Test
  public void getGetOpenScreenResponse2() {
    String result = new GetOpenScreenRequest().getGetOpenScreenResponse(uticket);
    System.err.println(result);
  }
}
