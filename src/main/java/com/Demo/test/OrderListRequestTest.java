package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.OrderListRequest;
import com.qiang.utils.FormJSON;
import com.qiang.utils.UseProperties;

public class OrderListRequestTest {
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
  public void getOrderListResponse() {
    String result = new OrderListRequest().getOrderListResponse("50", uticket, "0");
    System.err.println(FormJSON.format(result));
  }
}
