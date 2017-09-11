package com.Demo.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.Common.AddLogWrap;
import com.Demo.AreaDataServiceRequest;

public class AreaDataServiceRequestTest {
	public static final Logger LOGGER = Logger.getLogger(AreaDataServiceRequestTest.class);
  @Test
  public void getAreaDataServiceResponseString1() {
	  LOGGER.info("获取区域/板块列表--->>>");
	  String result = new AreaDataServiceRequest().getAreaDataServiceResponse("北京");
	  LOGGER.info("result="+result+"");
    Assert.assertTrue(result.contains("朝阳"));
  }
  @Test
  public void getAreaDataServiceResponseString2() {
	  String result = new AreaDataServiceRequest().getAreaDataServiceResponse("上海");
	  LOGGER.info("result="+result+"");
    Assert.assertTrue(result.contains("宝山"));
  }
  @Test
  public void getAreaDataServiceResponseString3() {
	  String result = new AreaDataServiceRequest().getAreaDataServiceResponse("2","0");
	  LOGGER.info("result="+result+"");
	    Assert.assertTrue(result.contains("浦东"));
  }
  @Test
  public void getAreaDataServiceResponseString4() {
	  String result = new AreaDataServiceRequest().getAreaDataServiceResponse("2","1");
	  LOGGER.info("result="+result+"");
	    Assert.assertTrue(result.contains("闸北"));
  }
  @Test
  public void getAreaDataServiceResponseString5() {
	  String result = new AreaDataServiceRequest().getAreaDataServiceResponse("2","2");
	  LOGGER.info("result="+result+"");
	    Assert.assertTrue(result.contains("杨浦"));
  }
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---获取区域/板块列表");
	  new AddLogWrap();
  }
}
