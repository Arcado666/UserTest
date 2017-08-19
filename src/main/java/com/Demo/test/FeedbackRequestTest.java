package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.FeedbackRequest;
import com.qiang.utils.UseProperties;

public class FeedbackRequestTest {
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
    System.out.println(new FeedbackRequest().getFeedbackResponse(userId, uticket, "测试提交意见反馈", new UserCommon().getImei()));
  }
}
