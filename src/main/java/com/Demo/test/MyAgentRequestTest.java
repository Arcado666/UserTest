package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.MyAgentRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class MyAgentRequestTest {
	String mobile;
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
	public void getMyAgentResponse() {
		result = new MyAgentRequest().getMyAgentResponse(uticket, "44866", "20", "0", "1", "1");
		Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
	}
}
