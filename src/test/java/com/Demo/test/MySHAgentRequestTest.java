package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.MySHAgentRequest;
import com.qiang.utils.UseProperties;

public class MySHAgentRequestTest {
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
		result = new MySHAgentRequest().getMySHAgentResponse(userId, uticket);
		}
  @Test
  public void getMyAgentResponse() {
    Assert.assertFalse(result.contains("产品测试—出售经纪人2"));
  }
}
