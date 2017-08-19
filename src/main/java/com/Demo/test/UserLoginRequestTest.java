package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.SendVerifyCodeRequest;
import com.Demo.UserLoginRequest;
import com.qiang.db.slim.DbSlimSelectQuery;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.FitnesseUtils;

public class UserLoginRequestTest {
	String mobile = "18701963886";
	String url = new UserCommon().getHost();
	String verify;
	@BeforeClass
	public void getVerifyCode() {
		if(url.contains("test")){
			String message = new SendVerifyCodeRequest().getVerifyCodeResponse( mobile);
			System.out.println(message);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbSlimSelectQuery db = new DbSlimSelectQuery("db.iwjwtest.com", "3306", "root", "QA@2015");
			verify = db.queryByName("content", "SELECT * FROM sms_fyb.iw_sms where mobile = '"+mobile+"' order by id desc limit 1;");
			verify = new FitnesseUtils().regex("\\d{4,}", verify);
		}
		else{
			String message = new SendVerifyCodeRequest().getVerifyCodeResponse(mobile);
			System.out.println(message);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbSlimSelectQuery db = new DbSlimSelectQuery("121.40.127.92", "3309", "qa_tmp", "mjl84_)l23jda0l_23");
			verify = db.queryByName("content",
					"SELECT * FROM sms_fyb_beta.iw_sms where mobile = '" + mobile + "' order by id desc limit 1;");
			verify = new FitnesseUtils().regex("\\d{4,}", verify);
		}
	}

	@Test
	//手机号码错误
	public void getUserLoginResponse1() {
		UserLoginRequest uLoginRequest = new UserLoginRequest();
		System.out.println(verify);
		String result = uLoginRequest.getUserLoginResponse( "17411122211", verify, new UserCommon().getImei(), "0");
		System.out.println(result);
		Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "200004");
	}
	
	@Test
	//验证码错误
	public void getUserLoginResponse2() {
		UserLoginRequest uLoginRequest = new UserLoginRequest();
		String result = uLoginRequest.getUserLoginResponse(mobile, "0000", new UserCommon().getImei(), "0");
		System.out.println(result);
		Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "200005");
	}
	
	@Test
	public void getUserLoginResponse3() {
		UserLoginRequest uLoginRequest = new UserLoginRequest();
		String result = uLoginRequest.getUserLoginResponse(mobile, verify, new UserCommon().getImei(), "0");
		System.out.println(result);
		Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
	}
//	@Test
//	//超过验证次数
//	public void getUserLoginResponse4() {
//		String result = null ;
//		for(int x= 0;x < 10;x++){
//			UserLoginRequest uLoginRequest = new UserLoginRequest();
//			result = uLoginRequest.getUserLoginResponse( "17498765432", verify, new UserCommon().getImei(), "0");
//		}
//		System.out.println(result);
//		Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "6");
//	}
}
