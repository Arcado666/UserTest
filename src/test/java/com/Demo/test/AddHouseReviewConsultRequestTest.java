package com.Demo.test;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.AddHouseReviewConsultRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class AddHouseReviewConsultRequestTest {
	
	public static final Logger LOGGER = Logger.getLogger(AddHouseReviewConsultRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	@BeforeClass
	public void getPorperties() {
		LOGGER.info("房源评价用户咨询接口--->>>");
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		}
  @Test
  public void getAddHouseReviewConsultResponse() {
    String result = new AddHouseReviewConsultRequest().getAddHouseReviewConsultResponse("", uticket, "", "", "");
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
  }
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---房源评价用户咨询接口");
  }
}
