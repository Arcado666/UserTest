package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.FeedbackRequest;
import com.Demo.GetStrongWeakAgentListRequest;
import com.Model.GetStrongWeakAgentListModel;
import com.qiang.utils.UseProperties;

public class GetStrongWeakAgentListRequestTest {

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
  @Test(enabled=true, threadPoolSize=10, invocationCount=10)
  public void GetStrongWeakAgentListResponse() {
    GetStrongWeakAgentListModel getStrongWeakAgentListModel = new GetStrongWeakAgentListModel();
    GetStrongWeakAgentListRequest getStrongWeakAgentListRequest = new GetStrongWeakAgentListRequest();
    getStrongWeakAgentListModel.setBizType(2);
    getStrongWeakAgentListModel.setHouseId("3096159");
    getStrongWeakAgentListModel.setType(6);
    String result = getStrongWeakAgentListRequest.getGetStrongWeakAgentListResponse(uticket, getStrongWeakAgentListModel);
    Assert.assertTrue(result.contains("47916"));
    Assert.assertTrue(result.contains("75389"));
    Assert.assertTrue(result.contains("19482"));
    
  }
}
