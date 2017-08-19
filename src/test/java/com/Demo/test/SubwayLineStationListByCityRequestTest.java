package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demo.SubwayLineStationListByCityRequest;

public class SubwayLineStationListByCityRequestTest {

  @Test
  public void getSubwayLineStationListByCityResponseString() {
    String result = new SubwayLineStationListByCityRequest().getSubwayLineStationListByCityResponse("12438");
    Assert.assertTrue(result.contains("八角游乐园"));
  }

  @Test
  public void getSubwayLineStationListByCityResponseStringString() {
	  String result = new SubwayLineStationListByCityRequest().getSubwayLineStationListByCityResponse("2","0");
	  Assert.assertTrue(result.contains("莲花路"));
  }
}
