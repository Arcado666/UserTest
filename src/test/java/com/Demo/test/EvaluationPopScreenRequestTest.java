package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.EvaluationPopScreenRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class EvaluationPopScreenRequestTest {
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
  //200047：此账户无权评价，请登录可评价该经纪人的账户
  public void getEvaluationPopScreenResponse() {
    String result = new EvaluationPopScreenRequest().getEvaluationPopScreenResponse("2312", uticket, "", "2");
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "200047");
  }
}
