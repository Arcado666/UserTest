package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.ImAgentListRequest;
import com.qiang.utils.UseProperties;

public class ImAgentListRequestTest {
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
  public void getImAgentListResponse() {
    String result = new ImAgentListRequest().getImAgentListResponse(uticket);
    Assert.assertEquals(result.contains("周洋洋"), true);
  }
}
