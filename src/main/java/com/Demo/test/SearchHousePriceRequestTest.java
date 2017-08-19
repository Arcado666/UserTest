package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demo.SearchHousePriceRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.FormJSON;

public class SearchHousePriceRequestTest {

  @Test
  public void getSearchHousePriceResponse() {
	  String result = new SearchHousePriceRequest().getSearchHousePriceResponse("2", "4");
	  System.out.println(FormJSON.format(result));
	  Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "0");
  }
}
