package com.Demo.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Demo.SupportCityServiceRequest;
import com.qiang.utils.CommonUtils;

public class SupportCityServiceRequestTest {
	public static final Logger LOGGER = Logger.getLogger(SupportCityServiceRequestTest.class); 
	String result;
	@BeforeClass
	public void BeforeClass() {
		result = new SupportCityServiceRequest().getSupportCityServiceResponse();
		System.err.println(result);
		LOGGER.info("支持城市及相关信息--->>>");
		LOGGER.info("result="+result+"");
	}

	@Test
	public void getSupportCityServiceResponse1() {
		LOGGER.info("验证aboveFiveMemo字段");
		Assert.assertEquals(CommonUtils.parseJson("aboveFiveMemo", result), "是指业主房产证从出证开始计算，时间满五年或超过五年，且登记在国土局系统里的只有这一套房子。购买产权证满5年，并且是唯一住房的普通住房，免征个税和营业税。");
	}
	@Test
	public void getSupportCityServiceResponse2() {
		LOGGER.info("验证aboveTwoMemo字段");
		Assert.assertEquals(CommonUtils.parseJson("aboveTwoMemo", result), "是指房源业主房产证从出证开始计算，时间满二年或超过二年。自2015年3月31日起，个人将购买2年以上（含2年）的普通住房对外销售的，免征营业税。");
	}
	@Test
	public void getSupportCityServiceResponse3() {
		LOGGER.info("验证myAilicaiTips字段");
		Assert.assertEquals(CommonUtils.parseJson("myAilicaiTips", result), "预计年化超7%");
	}
	@Test
	public void getSupportCityServiceResponse4() {
		LOGGER.info("验证adPopupImgUrl字段");
		Assert.assertEquals(CommonUtils.parseJson("adPopupImgUrl", result), "http://files.iwjw.com/resource/userapp/image/may_promo_pop.png");
	}
	@Test
	public void getSupportCityServiceResponse5() {
		LOGGER.info("验证helpCenterUrl字段");
		Assert.assertEquals(CommonUtils.parseJson("helpCenterUrl", result), "http://m.iwjwbeta.com/help");
	}
	@Test
	public void getSupportCityServiceResponse6() {
		LOGGER.info("验证openAccountDebitMsg字段");
		Assert.assertEquals(CommonUtils.parseJson("openAccountDebitMsg", result), "开户须从该卡扣除0.01元，用于验卡，扣款将转入钱包");
	}
	@Test
	public void getSupportCityServiceResponse7() {
		LOGGER.info("验证rentHouseCommissionUrl字段");
		Assert.assertEquals(CommonUtils.parseJson("rentHouseCommissionUrl", result), "http://m.iwjw.com/jiaizhai/chuzumanager");
	}
	@Test
	public void getSupportCityServiceResponse8() {
		LOGGER.info("验证schoolMemo字段");
		Assert.assertEquals(CommonUtils.parseJson("schoolMemo", result), "即学区房，一般特指对口学校的房子。购房者本人的子女可就读区、市、省级的重点学校");
	}
	@Test
	public void getSupportCityServiceResponse9() {
		LOGGER.info("验证serviceTel字段");
		Assert.assertEquals(CommonUtils.parseJson("serviceTel", result), "400-700-6622");
	}
	@Test
	public void getSupportCityServiceResponse10() {
		LOGGER.info("验证setSafeCardMsg字段");
		Assert.assertEquals(CommonUtils.parseJson("setSafeCardMsg", result), "设置安全卡须从该卡扣除0.01元，用于验卡，扣款将转入钱包");
	}
	@Test
	public void getSupportCityServiceResponse() {
		LOGGER.info("验证subwayMemo字段");
		Assert.assertEquals(CommonUtils.parseJson("subwayMemo", result), "特指地铁站周边1公里范围内的房子");
	}
	 @AfterClass
	  public void afterclass(){
		  LOGGER.info("<<<---支持城市及相关信息");
	  }
	
}
