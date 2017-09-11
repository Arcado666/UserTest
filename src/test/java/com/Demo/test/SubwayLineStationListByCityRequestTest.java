package com.Demo.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.Common.AddLogWrap;
import com.Demo.SubwayLineStationListByCityRequest;

public class SubwayLineStationListByCityRequestTest {
	public static final Logger LOGGER = Logger.getLogger(SubwayLineStationListByCityRequestTest.class);
  @Test
  public void getSubwayLineStationListByCityResponseString() {
	  LOGGER.info("根据城市获取地铁线(包括地铁站)的信息--->>>");
	  LOGGER.info("获取北京地铁线(包括地铁站)的信息");
    String result = new SubwayLineStationListByCityRequest().getSubwayLineStationListByCityResponse("12438");
    LOGGER.info("result="+result+"");
    Assert.assertTrue(result.contains("八角游乐园"));
  }

  @Test
  public void getSubwayLineStationListByCityResponseStringString() {
	  LOGGER.info("获取上海地铁线(包括地铁站)的信息");
	  String result = new SubwayLineStationListByCityRequest().getSubwayLineStationListByCityResponse("2","0");
	  LOGGER.info("result="+result+"");
	  Assert.assertTrue(result.contains("莲花路"));
  }
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---根据城市获取地铁线(包括地铁站)的信息");
	  new AddLogWrap();
  }
}
