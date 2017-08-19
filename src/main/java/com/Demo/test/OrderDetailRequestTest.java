package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.OrderDetailRequest;
import com.qiang.utils.UseProperties;

public class OrderDetailRequestTest {
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
  public void getOrderDetailResponse() {
    String result = new OrderDetailRequest().getOrderDetailResponse("129422", uticket, "1");
    System.out.println(result);
  }
}
