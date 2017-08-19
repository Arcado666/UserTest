package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demo.HouseNumberRequest;
import com.qiang.utils.CommonUtils;

public class HouseNumberRequestTest {

  @Test
  public void getHouseNumberResponse() {
    String result = new HouseNumberRequest().getHouseNumberResponse("17421515");
    System.out.println(result);
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
