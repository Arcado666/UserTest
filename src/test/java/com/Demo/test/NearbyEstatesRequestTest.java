package com.Demo.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.AddLogWrap;
import com.Common.UserCommon;
import com.Demo.NearbyEstatesRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class NearbyEstatesRequestTest {
	public static final Logger LOGGER = Logger.getLogger(NearbyEstatesRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	@BeforeClass
	public void getPorperties() {
		LOGGER.info("根据用户坐标获取附近在售信息--->>>");
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		}
  @Test
  public void getNearbyEstatesResponse() {
	  String result = new NearbyEstatesRequest().getNearbyEstatesResponse("31.248119", "121.452609");
	  LOGGER.info("result="+result+"");
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---根据用户坐标获取附近在售信息");
	  new AddLogWrap();
  }
}
