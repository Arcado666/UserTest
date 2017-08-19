package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.SaveLandlordRequest;
import com.qiang.utils.UseProperties;

public class SaveLandlordRequestTest {
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
  public void getFeedbackResponse() {
    String result = new SaveLandlordRequest().getSaveLandlordResponse("11211", uticket, "411122", "icbc", "12345878545");
    System.err.println(result);
  }
}
