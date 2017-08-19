package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.EsateHousePriceListRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.FormJSON;
import com.qiang.utils.UseProperties;

public class EsateHousePriceListRequestTest {

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
  public void getEsateHousePriceListResponse() {
	  String result = new EsateHousePriceListRequest().getEsateHousePriceListResponse("2", uticket, "6", "1", "20", "0");
    System.out.println(FormJSON.format(result));
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
    
  }
}
