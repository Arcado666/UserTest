package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.NewHouseListRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class NewHouseListRequestTest {
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
  public void getNewHouseListResponse() {
	  String result = new NewHouseListRequest().getNewHouseListResponse("", "", "", "", "", "", "", "", "", "", "", "", "", "");
    System.out.println(result);
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
