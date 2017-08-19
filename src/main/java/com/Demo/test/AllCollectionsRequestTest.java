package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.AllCollectionsRequest;
import com.qiang.utils.UseProperties;

public class AllCollectionsRequestTest {
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
  public void getAllCollectionsResponse() {
    String result = new AllCollectionsRequest().getAllCollectionsResponse("0", uticket, "1", "5");
    System.err.println(result);
  }
}
