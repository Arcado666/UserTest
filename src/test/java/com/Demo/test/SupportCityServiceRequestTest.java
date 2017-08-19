package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Demo.SupportCityServiceRequest;
import com.qiang.utils.CommonUtils;

public class SupportCityServiceRequestTest {
	String result;
	@BeforeClass
	public void BeforeClass() {
		result = new SupportCityServiceRequest().getSupportCityServiceResponse();
		System.err.println(result);
	}

	@Test
	public void getSupportCityServiceResponse1() {
		Assert.assertEquals(CommonUtils.parseJson("aboveFiveMemo", result), "是指业主房产证从出证开始计算，时间满五年或超过五年，且登记在国土局系统里的只有这一套房子。购买产权证满5年，并且是唯一住房的普通住房，免征个税和营业税。");
	}
	@Test
	public void getSupportCityServiceResponse2() {
		Assert.assertEquals(CommonUtils.parseJson("aboveTwoMemo", result), "是指房源业主房产证从出证开始计算，时间满二年或超过二年。自2015年3月31日起，个人将购买2年以上（含2年）的普通住房对外销售的，免征营业税。");
	}
	@Test
	public void getSupportCityServiceResponse3() {
		Assert.assertEquals(CommonUtils.parseJson("myAilicaiTips", result), "预计年化超7%");
	}
	@Test
	public void getSupportCityServiceResponse4() {
		Assert.assertEquals(CommonUtils.parseJson("adPopupImgUrl", result), "http://files.iwjw.com/resource/userapp/image/may_promo_pop.png");
	}
	@Test
	public void getSupportCityServiceResponse5() {
		Assert.assertEquals(CommonUtils.parseJson("helpCenterUrl", result), "http://m.iwjw.com/help");
	}
	@Test
	public void getSupportCityServiceResponse6() {
		Assert.assertEquals(CommonUtils.parseJson("openAccountDebitMsg", result), "开户须从该卡扣除0.01元，用于验卡，扣款将转入钱包");
	}
	@Test
	public void getSupportCityServiceResponse7() {
		Assert.assertEquals(CommonUtils.parseJson("rentHouseCommissionUrl", result), "http://m.iwjw.com/jiaizhai/chuzumanager");
	}
	@Test
	public void getSupportCityServiceResponse8() {
		Assert.assertEquals(CommonUtils.parseJson("schoolMemo", result), "即学区房，一般特指对口学校的房子。购房者本人的子女可就读区、市、省级的重点学校");
	}
	@Test
	public void getSupportCityServiceResponse9() {
		Assert.assertEquals(CommonUtils.parseJson("serviceTel", result), "1010-6622");
	}
	@Test
	public void getSupportCityServiceResponse10() {
		Assert.assertEquals(CommonUtils.parseJson("setSafeCardMsg", result), "设置安全卡须从该卡扣除0.01元，用于验卡，扣款将转入钱包");
	}
	@Test
	public void getSupportCityServiceResponse() {
		Assert.assertEquals(CommonUtils.parseJson("subwayMemo", result), "特指地铁站周边1公里范围内的房子");
	}
	
	
}
