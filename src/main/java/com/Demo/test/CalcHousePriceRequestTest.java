package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demo.CalcHousePriceRequest;
import com.qiang.utils.CommonUtils;

public class CalcHousePriceRequestTest {

  @Test
  public void getCalcHousePriceResponse() {
	 String result = new CalcHousePriceRequest().getCalcHousePriceResponse("9023", "1", "0", "1", "3", "12", "", "", "", "", "", "60", "1");
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
