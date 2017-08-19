package com.Demo.test;

import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.ConfirmInstallRequest;
import com.qiang.utils.UseProperties;

public class ConfirmInstallRequestTest {
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
  @Test
  public void getConfirmInstallResponse() {
    String result = new ConfirmInstallRequest().getConfirmInstallResponse("5599", uticket, ""+new Date().getTime()+"");
    System.out.println(result);
  }
}
