package com.Demo.test;

import org.testng.annotations.Test;

import com.Demo.LayoutDetailRequest;

public class LayoutDetailRequestTest {

  @Test
  public void getLayoutDetailResponse() {
    String result = new LayoutDetailRequest().getLayoutDetailResponse("3689", "15784");
    System.out.println(result);
  }
}
