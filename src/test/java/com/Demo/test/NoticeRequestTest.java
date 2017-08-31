package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.NoticeRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class NoticeRequestTest {
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
  public void getNoticeResponse1() {
    String result = new NoticeRequest().getNoticeResponse(uticket, "1");
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
  @Test
  public void getNoticeResponse2() {
    String result = new NoticeRequest().getNoticeResponse(uticket);
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
