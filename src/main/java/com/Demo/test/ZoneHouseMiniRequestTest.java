package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.ZoneHouseMiniRequest;
import com.qiang.utils.UseProperties;

public class ZoneHouseMiniRequestTest {
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
  public void getZoneHouseMiniResponse() {
     String result = new ZoneHouseMiniRequest().getZoneHouseMiniResponse("6938", uticket, "1", "0");
     System.err.println(result);
  }
}
