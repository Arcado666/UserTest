package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demo.SendVerifyCodeRequest;
import com.qiang.utils.CommonUtils;

public class SendVerifyCodeRequestTest {
	String mobile = "17412341234";
	@Test
	//200002:手机号码格式不正确
	public void getVerifyCodeResponse1() {
		Assert.assertEquals(CommonUtils.parseJson("errorCode", new SendVerifyCodeRequest().getVerifyCodeResponse("1851234123")), "200002");
	}
	@Test
	//200001:手机号码不能为空
	public void getVerifyCodeResponse2() {
		String mobile = "";
		Assert.assertEquals(CommonUtils.parseJson("errorCode", new SendVerifyCodeRequest().getVerifyCodeResponse(mobile)), "200001");
	}
	@Test
	//发送成功
	public void getVerifyCodeResponse3() {
		Assert.assertEquals(CommonUtils.parseJson("errorCode", new SendVerifyCodeRequest().getVerifyCodeResponse(mobile)), "0");
	}
	@Test
	//同一号码一分钟只能发一次
	public void getVerifyCodeResponse4() {
		Assert.assertEquals(CommonUtils.parseJson("errorCode", new SendVerifyCodeRequest().getVerifyCodeResponse( mobile)), "200016");
	}
}
