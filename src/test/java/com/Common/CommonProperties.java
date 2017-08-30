package com.Common;

import java.io.IOException;

import com.Demo.SendVerifyCodeRequest;
import com.Demo.UserLoginRequest;
import com.qiang.db.slim.DbSlimSelectQuery;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.FitnesseUtils;
import com.qiang.utils.UseProperties;

public class CommonProperties {
	//测试分支合并
	String mobile = "18701963886";
	String url = new UserCommon().getHost();
	String verify;
	String result;
	String uticket;
	String userId;
	public void setProperties() throws IOException{
		
		if (url.contains("test")) {
			String message = new SendVerifyCodeRequest().getVerifyCodeResponse( mobile);
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
		result = uLoginRequest.getUserLoginResponse(mobile, verify, new UserCommon().getImei(), "0");

		uticket = CommonUtils.parseJson("uticket", result);
		userId = CommonUtils.parseJson("userId", result);
		UseProperties.WriteProperties("config.properties", "uticket", uticket);
		UseProperties.WriteProperties("config.properties", "mobile", mobile);
		UseProperties.WriteProperties("config.properties", "userId", userId);
	}
	
	public static void main(String[] args) {
		try {
			new CommonProperties().setProperties();
			System.out.println("文件写入成功");
		} catch (IOException e) {
			System.out.println("文件写入失败");
			e.printStackTrace();
			
		}
	}
	
}
