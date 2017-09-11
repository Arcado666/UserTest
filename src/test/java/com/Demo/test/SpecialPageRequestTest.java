package com.Demo.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.AddLogWrap;
import com.Common.UserCommon;
import com.Demo.SpecialPageRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class SpecialPageRequestTest {
	public static final Logger LOGGER = Logger.getLogger(SpecialPageRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	@BeforeClass
	public void getPorperties() {
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		LOGGER.info("热门推荐/个性化推荐--->>>");
		}
  @Test
  public void getSpecialPageResponse() {
    String result = new SpecialPageRequest().getSpecialPageResponse(uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    Assert.assertNotNull(CommonUtils.parseJson("list", result));
  }
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---热门推荐/个性化推荐");
	  new AddLogWrap();
  }
}
