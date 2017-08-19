package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.NotEvaluatedAppointListRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class NotEvaluatedAppointListRequestTest {
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
  public void getNotEvaluatedAppointListResponse() {
	  String result = new NotEvaluatedAppointListRequest().getNotEvaluatedAppointListResponse(uticket, "0", "5");
	  System.out.println(result);
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
