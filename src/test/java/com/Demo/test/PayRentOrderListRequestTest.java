package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.PayRentOrderListRequest;
import com.qiang.utils.UseProperties;

public class PayRentOrderListRequestTest {
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
  public void getPayRentOrderResponse() {
    String result = new PayRentOrderListRequest().getPayRentOrderResponse("20", uticket, "0");
    System.err.println(result);
  }
}
