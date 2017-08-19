package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.AddHouseReviewConsultRequest;
import com.qiang.utils.UseProperties;

public class AddHouseReviewConsultRequestTest {
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
  public void getAddHouseReviewConsultResponse() {
    String result = new AddHouseReviewConsultRequest().getAddHouseReviewConsultResponse("", uticket, "", "", "");
    System.err.println(result);
  }
}
