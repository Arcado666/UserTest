package com.Demo.test;

import org.testng.annotations.Test;

import com.Demo.HtmlResourceVersionRequest;

public class HtmlResourceVersionRequestTest {
  @Test
  public void getHtmlResourceVersionResponse() {
	 String result = new HtmlResourceVersionRequest().getHtmlResourceVersionResponse("1", "5.0");
    System.err.println(result);
  }
}
