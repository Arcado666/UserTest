package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.OnekeyAppointmentRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class OnekeyAppointmentRequestTest {
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
  public void getOnekeyAppointmentResponse() {
    String result = new OnekeyAppointmentRequest().getOnekeyAppointmentResponse("李三", uticket, "", "", "", "2", "");
    Assert.assertEquals(CommonUtils.parseJson("", result), "");
  }
}
