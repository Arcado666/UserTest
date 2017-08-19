package com.Demo.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.GetBigHomePageInfoRequest;
import com.Model.FunctionChannel;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class GetBigHomePageInfoRequestTest {
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
	    System.err.println(result);
		}
  @Test
  public void getGetBigHomePageInfoResponse1() {
    Assert.assertEquals(CommonUtils.parseJson("brandedResidenceTitle", result), "租房免中介费！");
  }
  @Test
  public void getGetBigHomePageInfoResponse2() {
    Assert.assertTrue(CommonUtils.parseJson("cityTradeHistoryDetailUrl", result).contains("http://m.iwjw.com/hisTradeData/"));
  }
  @Test
  public void getGetBigHomePageInfoResponse3() {
    Assert.assertEquals(CommonUtils.parseJson("cityTradeHistoryTitle", result), "上海二手房交易报告");
  }
  @Test
  public void getGetBigHomePageInfoResponse4() {
	  List<FunctionChannel> fChannels = JSON.parseArray(functionChannel1, FunctionChannel.class);
	  int size = fChannels.size();
	  for (int i = 0; i < size; i++) {
		FunctionChannel fChannel = fChannels.get(i);
		if (fChannel.getType() == 1) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_main_ershoufang.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "二手房");
		}
		if (fChannel.getType() == 2) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_main_xinfang.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "新房");
			Assert.assertTrue(fChannel.getDetailUrl().contains("newHouseIndex/shanghai"));
		}
		if (fChannel.getType() == 3) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_main_zufang.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "租房");
		}
		if (fChannel.getType() == 4) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_main_ailicai.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "爱理财");
			Assert.assertTrue(fChannel.getDetailUrl().contains("licai/licaiindex"));
		}
		if (fChannel.getType() == 20) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_main_gongyu.png");
			Assert.assertEquals(fChannel.getIsHot(), "1");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "公寓租房");
			Assert.assertTrue(fChannel.getDetailUrl().contains("m.rent"));
		}
	}
    
  }
  @Test
  public void getGetBigHomePageInfoResponse5() {
	  List<FunctionChannel> fChannels = JSON.parseArray(functionChannel2, FunctionChannel.class);
	  int size = fChannels.size();
	  for (int i = 0; i < size; i++) {
		FunctionChannel fChannel = fChannels.get(i);
		if (fChannel.getType() == 21) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_main_baike.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "查小区");
		}
		if (fChannel.getType() == 5) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_main_maifang.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "房东委托");
		}
		if (fChannel.getType() == 13) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.2/home_main_daizongguan.png");
			Assert.assertEquals(fChannel.getIsHot(), "0");
			Assert.assertEquals(fChannel.getIsTool(), "0");
			Assert.assertEquals(fChannel.getTitle(), "贷总管");
			Assert.assertTrue(fChannel.getDetailUrl().contains("/borrower#!/"));
		}
	}
  }
  @Test
  public void getGetBigHomePageInfoResponse6() {
	  List<FunctionChannel> fChannels = JSON.parseArray(functionChannelTools, FunctionChannel.class);
	  int size = fChannels.size();
	  for (int i = 0; i < size; i++) {
		FunctionChannel fChannel = fChannels.get(i);
		if (fChannel.getType() == 18) {
			Assert.assertEquals(fChannel.getIconUrl(), "http://files.iwjw.com/resource/userapp/v6.4/home_tool_chafangjia@3x.png?6.5");
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
}
