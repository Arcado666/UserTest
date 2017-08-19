package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demo.CountOpenScreenRequest;
import com.qiang.utils.CommonUtils;

public class CountOpenScreenRequestTest {

  @Test
  public void getCountOpenScreenResponse() {
    String result = new CountOpenScreenRequest().getCountOpenScreenResponse("123");
    System.out.println(result);
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
