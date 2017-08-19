package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demo.HousePriceTipsSearchRequest;

public class HousePriceTipsSearchResponseTest {

  @Test
  public void getHousePriceTipsResponse() {
	  String result = new HousePriceTipsSearchRequest().getHousePriceTipsResponse("2", "永和");
	  Assert.assertEquals(result.contains("永和二村"), true);
  }
}
