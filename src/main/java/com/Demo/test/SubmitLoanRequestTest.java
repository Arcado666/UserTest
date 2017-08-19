package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.SubmitLoanRequest;
import com.qiang.utils.UseProperties;

public class SubmitLoanRequestTest {
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
  public void getSubmitLoanResponse() {
    String result = new SubmitLoanRequest().getSubmitLoanResponse("2", uticket, "1", "2000", "60", "007", "18701963886");
    System.out.println(result);
  }
}
