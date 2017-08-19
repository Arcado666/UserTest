package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.BindRecommenderRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class BindRecommenderRequestTest {
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	String result;
	@BeforeClass
	public void getPorperties() {
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		}
  @Test
  //正常
  public void getBindRecommenderResponse1() {
    result = new BindRecommenderRequest().getBindRecommenderResponse("318936", uticket, "3");
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
  @Test
  //200050：您不是新用户，不能绑定推荐人
  public void getBindRecommenderResponse2() {
    result = new BindRecommenderRequest().getBindRecommenderResponse("318936", uticket, "3");
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "200050");
  }
  @Test
  //-1   查找不到推荐人
  public void getBindRecommenderResponse3() {
    result = new BindRecommenderRequest().getBindRecommenderResponse(userId, uticket, "1");
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "-1");
  }
  @Test
  //-1   查找不到推荐人
  public void getBindRecommenderResponse4() {
    result = new BindRecommenderRequest().getBindRecommenderResponse(userId, uticket, "2");
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "-1");
  }
}
