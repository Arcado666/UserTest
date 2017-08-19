package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Demo.AppointmentHouseRequest;
import com.qiang.utils.CommonUtils;

public class AppointmentHouseRequestTest {

  @Test
  //200021:预约看房的数量不能超过10套
  public void getAppointmentHouseResponse1() {
    String result = new AppointmentHouseRequest().getAppointmentHouseResponse("2070809", "TmFmejhrcDhybHMlQCVhMDY0ZjdhZmI3ZDk4NWI1MjdhOGVlZTIxODliMDhjZg==","用户","1"
			,"2017-04-01 00:00:00","780678,780677,780676,780675,780674,780673,780672,780671,780670,780679,780658,780578","上海","1","44866","3","1","18701963886");
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "200021");
  }
  
  @Test
  //200015:只能提交一个城市的房源，多个城市是无法约看的
  public void getAppointmentHouseResponse2() {
    String result = new AppointmentHouseRequest().getAppointmentHouseResponse("2070809", "TmFmejhrcDhybHMlQCVhMDY0ZjdhZmI3ZDk4NWI1MjdhOGVlZTIxODliMDhjZg==","用户","1"
			,"2017-04-01 00:00:00","780678,780677,780676,780675,780674,780673,780672,13963480","上海","1","44866","3","1","18701963886");
    System.out.println(result);
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "200015");
  }
  
  @Test
  //200043：您已开启“屏蔽所有打扰”模式，看房顾问无法联系您；需关闭该模式，才能继续提交约看
  public void getAppointmentHouseResponse3() {
    String result = new AppointmentHouseRequest().getAppointmentHouseResponse("2070809", "TmFmejhrcDhybHMlQCVhMDY0ZjdhZmI3ZDk4NWI1MjdhOGVlZTIxODliMDhjZg==","用户","1"
			,"2017-04-01 00:00:00","780677","上海","1","44866","3","0","18701963886");
    System.out.println(result);
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "200043");
  }
  
  @Test
  //200022:预约超额了，先去看房吧~
  public void getAppointmentHouseResponse4() {
    String result = new AppointmentHouseRequest().getAppointmentHouseResponse("2070809", "TmFmejhrcDhybHMlQCVhMDY0ZjdhZmI3ZDk4NWI1MjdhOGVlZTIxODliMDhjZg==","用户","1"
			,"2017-04-01 00:00:00","780677,780676,780675,780674,780673,780672,780671,780670,780679,780658","上海","1","44866","3","0","18701963886");
    System.out.println(result);
    Assert.assertEquals(CommonUtils.parseJson("errorCode", result), "200022");
  }
}
