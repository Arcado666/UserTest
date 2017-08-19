package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.GetServerTimeRequst;
import com.qiang.utils.UseProperties;

public class GetServerTimeRequstTest {
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
  public void getGetServerTimeResponse() {
   String result = new GetServerTimeRequst().getGetServerTimeResponse("");
   System.err.println(result);
  }
}
