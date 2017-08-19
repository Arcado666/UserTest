package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demo.UpdateInfoRequest;
import com.qiang.utils.CommonUtils;

public class UpdateInfoRequestTest {

  @Test
//最新版本号
  public void getUpdateInfoResponse1() {
    Assert.assertEquals(CommonUtils.parseJson("version",new UpdateInfoRequest().getUpdateInfoResponse("1", "", "23")), "6.4.1");
  }
  @Test
  //是否需要强制更新 0：不需要 1：强制更新
  public void getUpdateInfoResponse2() {
	  Assert.assertEquals(CommonUtils.parseJson("forceUpdate",new UpdateInfoRequest().getUpdateInfoResponse("1", "", "23")), "1");
  }
  @Test
  //ios
  public void getUpdateInfoResponse3() {
	  System.out.println(new UpdateInfoRequest().getUpdateInfoResponse("2", "", ""));
//	  Assert.assertEquals(CommonUtils.parseJson("forceUpdate",new UpdateInfoRequest().getUpdateInfoResponse("1", "", "23")), "1");
  }
}
