package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demo.AreaDataServiceRequest;

public class AreaDataServiceRequestTest {
  @Test
  public void getAreaDataServiceResponseString() {
	  String result = new AreaDataServiceRequest().getAreaDataServiceResponse("北京");
    Assert.assertTrue(result.contains("朝阳"));
  }

  @Test
  public void getAreaDataServiceResponseStringString() {
	  String result = new AreaDataServiceRequest().getAreaDataServiceResponse("2","0");
	    Assert.assertTrue(result.contains("浦东"));
  }
}
