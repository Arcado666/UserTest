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

public class UserLoginRequestTest2 {
	String mobile = "18701963886";
	String url = new UserCommon().getHost();
	String verify;
	String result;

	@BeforeClass
	public void getVerifyCode() {
		if (url.contains("test")) {
			String message = new SendVerifyCodeRequest().getVerifyCodeResponse(mobile);
			System.out.println(message);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			DbSlimSelectQuery db = new DbSlimSelectQuery("db.iwjwtest.com", "3306", "root", "QA@2015");
			verify = db.queryByName("content",
					"SELECT * FROM sms_fyb.iw_sms where mobile = '" + mobile + "' order by id desc limit 1;");
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
		UserLoginRequest uLoginRequest = new UserLoginRequest();
		result = uLoginRequest.getUserLoginResponse( mobile, verify, new UserCommon().getImei(), "0");
	}

	@Test
	// 是否为新浪渠道内测用户 0-否 1-是
	public void getUserLoginResponse1() {
		Assert.assertEquals(CommonUtils.parseJson("isTestUser", result), "1");
	}

	@Test
	// 判断是否是否开户 0:否，1:已开户，2：开户中
	public void getUserLoginResponse2() {
		Assert.assertEquals(CommonUtils.parseJson("isOpenAccount", result), "1");
	}

	@Test
	// 是否已绑定安全卡 0:否，1:是
	public void getUserLoginResponse3() {
		Assert.assertEquals(CommonUtils.parseJson("hasSafeCard", result), "1");
	}

	@Test
	// 判断是否设置支付密码 0:否，1:是
	public void getUserLoginResponse4() {
		Assert.assertEquals(CommonUtils.parseJson("isSetPayPwd", result), "1");
	}

	@Test
	// 爱理财是否通过实名认证 0:否，1:是
	public void getUserLoginResponse5() {
		Assert.assertEquals(CommonUtils.parseJson("isRealNameVerify", result), "1");
	}

	@Test
	// 爱理财是否已绑定借记卡 0:否，1:是
	public void getUserLoginResponse6() {
		Assert.assertEquals(CommonUtils.parseJson("isBinDebitCard", result), "1");
	}

	@Test
	// 用户真实姓名（5.2更新）
	public void getUserLoginResponse7() {
		Assert.assertEquals(CommonUtils.parseJson("rName", result), "金鹏");
	}

	@Test
	// 身份证号（5.2更新）
	public void getUserLoginResponse8() {
		Assert.assertEquals(CommonUtils.parseJson("idCardNo", result), "1****************6");
	}

	@Test
	// 0-首次 1-否
	public void getUserLoginResponse9() {
		Assert.assertEquals(CommonUtils.parseJson("firstLogin", result), "1");
	}

	@Test
	// 是否设置了全量免打扰 0：否，1：是
	public void getUserLoginResponse10() {
		Assert.assertEquals(CommonUtils.parseJson("isAllDontDisturb", result), "0");
	}

	@Test
	// 业务类型 1：租房，2：二手房
	public void getUserLoginResponse11() {
		Assert.assertEquals(CommonUtils.parseJson("appointBizType", result), "0");
	}

	@Test
	// 用户ID
	public void getUserLoginResponse12() {
		Assert.assertEquals(CommonUtils.parseJson("userId", result), "2070809");
	}

	@Test
	// 用户姓名
	public void getUserLoginResponse13() {
		Assert.assertEquals(CommonUtils.parseJson("name", result), "金鹏");
	}

	@Test
	// 性别 1：男，2：女， 3:保密
	public void getUserLoginResponse14() {
		Assert.assertEquals(CommonUtils.parseJson("gender", result), "1");
	}

	@Test
	// 我的是否有更新
	public void getUserLoginResponse15() {
		Assert.assertEquals(CommonUtils.parseJson("myupdate", result), "false");
	}

	@Test
	// 我的是否有更新
	public void getUserLoginResponse16() {
		Assert.assertNotNull(CommonUtils.parseJson("uticket", result));
	}
}
