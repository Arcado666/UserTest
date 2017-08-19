package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.ZoneHousePriceTradeRequest;
import com.qiang.utils.UseProperties;

public class ZoneHousePriceTradeRequestTest {
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
  public void getZoneHousePriceTradeResponse() {
    String result = new ZoneHousePriceTradeRequest().getZoneHousePriceTradeResponse("", uticket, "1", "20", "0");
    System.err.println(result);
  }
}
