package com.Demo.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.BannerListRequest;
import com.qiang.utils.FormJSON;
import com.qiang.utils.UseProperties;

public class BannerListRequestTest {
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
  public void getBannerListResponse() {
    String result = new BannerListRequest().getBannerListResponse("1", "");
    System.out.println(FormJSON.format(result));
  }
}
