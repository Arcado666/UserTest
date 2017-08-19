package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.UserMyRequest;
import com.qiang.utils.UseProperties;

public class UserMyRequestTest {
	
	private String bizType = "1"; // 1 出租， 2 出售
	private String cityId = "2";//城市id
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
		result = new UserMyRequest().getUserMyResponse(userId, uticket, bizType, cityId);
		}
  @Test
  public void getUserMyResponse() {
    System.out.println(result);
  }
}
