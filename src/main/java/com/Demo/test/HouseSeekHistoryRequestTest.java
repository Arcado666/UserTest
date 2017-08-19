package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.HouseSeekHistoryRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class HouseSeekHistoryRequestTest {
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
  public void getHouseSeekHistoryResponse() {
	  String result = new HouseSeekHistoryRequest().getHouseSeekHistoryResponse("2", uticket, "170134", "66666", "", "0", "10");
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
