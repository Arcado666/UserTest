package com.Demo.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.GetBigHomePageInfoRequest;
import com.Model.FunctionChannel;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class GetBigHomePageInfoRequestTest {
	public static final Logger LOGGER = Logger.getLogger(GetBigHomePageInfoRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	String result;
	String functionChannel1;
	String functionChannel2;
	String functionChannelTools;
	@BeforeClass
	public void getPorperties() {
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		result = new GetBigHomePageInfoRequest().getGetBigHomePageInfoResponse("2", "");
		functionChannel1 = CommonUtils.parseJson("functionChannel1", result);
		functionChannel2 = CommonUtils.parseJson("functionChannel2", result);
		functionChannelTools = CommonUtils.parseJson("functionChannelTools", result);
		LOGGER.info("获取大首页--->>>");
	    LOGGER.info(result+"="+result+"");
	    LOGGER.info(functionChannel1+"="+functionChannel1+"");
	    LOGGER.info(functionChannel2+"="+functionChannel2+"");
	    LOGGER.info(functionChannelTools+"="+functionChannelTools+"");
		}
//	7.2需求变更，去掉品牌公寓租房免中介费显示
//  @Test
//  public void getGetBigHomePageInfoResponse1() {
//    Assert.assertEquals(CommonUtils.parseJson("brandedResidenceTitle", result), "租房免中介费！");
//  }
  @Test
  public void getGetBigHomePageInfoResponse2() {
	  LOGGER.info("验证cityTradeHistoryDetailUrl字段");
    Assert.assertTrue(CommonUtils.parseJson("cityTradeHistoryDetailUrl", result).contains("http://m.iwjw.com/hisTradeData/"));
  }
  @Test
  public void getGetBigHomePageInfoResponse3() {
	  LOGGER.info("验证cityTradeHistoryTitle字段");
    Assert.assertEquals(CommonUtils.parseJson("cityTradeHistoryTitle", result), "上海二手房交易报告");
  }
  @Test
  public void getGetBigHomePageInfoResponse4() {
	  LOGGER.info("验证functionChannel1字段");
	  List<FunctionChannel> fChannels = JSON.parseArray(functionChannel1, FunctionChannel.class);
	  
	  int size = fChannels.size();
	  for (int i = 0; i < size; i++) {
		FunctionChannel fChannel = fChannels.get(i);
		if (fChannel.getType() == 1) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/directwaterbucket/appconfig/2017/6/2/55a8b795d5a04f3e94f0e48ee7ca82bc");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "二手房");
		}
		if (fChannel.getType() == 2) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/directwaterbucket/appconfig/2017/6/2/9ec0ec471a044516a21c6828d2785b05");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "新房");
			Assert.assertTrue(fChannel.getDetailUrl().contains("newHouseIndex/shanghai"));
		}
		if (fChannel.getType() == 3) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/directwaterbucket/appconfig/2017/6/2/a6bf2490e85b43f0a0420d4639f07ab2");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "租房");
		}
		if (fChannel.getType() == 4) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/directwaterbucket/appconfig/2017/8/21/7724514d730844f696edd37ba5315677");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "吉爱财");
			Assert.assertTrue(fChannel.getDetailUrl().contains("licai/licaiindex"));
		}
		if (fChannel.getType() == 20) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/directwaterbucket/appconfig/2017/8/3/9f2df692c1d74c3f8f44076db4fc1c2c");
			Assert.assertEquals(fChannel.getIsHot(), "1");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "公寓租房");
			Assert.assertTrue(fChannel.getDetailUrl().contains("m.rent"));
		}
	}
    
  }
  /**
   * 大首页九宫格内第二排数据functionChannel2放入 functionChannel1中，functionChannel2舍弃
   */
//  @Test
//  public void getGetBigHomePageInfoResponse5() {
//	  List<FunctionChannel> fChannels = JSON.parseArray(functionChannel2, FunctionChannel.class);
//	  int size = fChannels.size();
//	  for (int i = 0; i < size; i++) {
//		FunctionChannel fChannel = fChannels.get(i);
//		if (fChannel.getType() == 21) {
//			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_main_baike.png");
//			Assert.assertEquals(fChannel.getIsHot(), "0");
//			Assert.assertEquals(fChannel.getIsTool(), "0");
//			Assert.assertEquals(fChannel.getTitle(), "查小区");
//		}
//		if (fChannel.getType() == 5) {
//			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_main_maifang.png");
//			Assert.assertEquals(fChannel.getIsHot(), "0");
//			Assert.assertEquals(fChannel.getIsTool(), "0");
//			Assert.assertEquals(fChannel.getTitle(), "房东委托");
//		}
//		if (fChannel.getType() == 13) {
//			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_main_daizongguan.png");
//			Assert.assertEquals(fChannel.getIsHot(), "0");
//			Assert.assertEquals(fChannel.getIsTool(), "0");
//			Assert.assertEquals(fChannel.getTitle(), "贷总管");
//			Assert.assertTrue(fChannel.getDetailUrl().contains("/borrower#!/"));
//		}
//	}
//  }
  @Test
  public void getGetBigHomePageInfoResponse6() {
	  LOGGER.info("验证functionChannelTools字段");
	  List<FunctionChannel> fChannels = JSON.parseArray(functionChannelTools, FunctionChannel.class);
	  
	  int size = fChannels.size();
	  for (int i = 0; i < size; i++) {
		FunctionChannel fChannel = fChannels.get(i);
		if (fChannel.getType() == 18) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/image/home_icon/home_tool_chafangjiav67.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "1");
			Assert.assertEquals(fChannel.getTitle(), "查房价");
		}
		if (fChannel.getType() == 19) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/image/home_icon/home_tool_gufangjiav60.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "1");
			Assert.assertEquals(fChannel.getTitle(), "估房价");
		}
		if (fChannel.getType() == 16) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/image/home_icon/home_tool_jiaofangzuv60.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "1");
			Assert.assertEquals(fChannel.getTitle(), "交房租");
			Assert.assertTrue(fChannel.getDetailUrl().contains("myorder#!/payrent?_router=server"));
		}
		if (fChannel.getType() == 8) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/image/home_icon/home_tool_calculator_v58.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "1");
			Assert.assertEquals(fChannel.getTitle(), "算房贷");
		}
		if (fChannel.getType() == 17) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/image/home_icon/home_tool_suanshuifei_v58.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "1");
			Assert.assertEquals(fChannel.getTitle(), "算税费");
			Assert.assertTrue(fChannel.getDetailUrl().contains("/calc/tax"));
		}
		if (fChannel.getType() == 6) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_tool_goufanggonglue.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "1");
			Assert.assertEquals(fChannel.getTitle(), "购房攻略");
			Assert.assertTrue(fChannel.getDetailUrl().contains("/baike/shanghai"));
		}
	}
  }
  
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---获取大首页");
  }
}
