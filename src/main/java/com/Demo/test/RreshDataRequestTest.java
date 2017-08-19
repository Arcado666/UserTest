package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.RreshDataRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class RreshDataRequestTest {
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	String result;
	@BeforeClass
	public void getPorperties() {
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		result = new RreshDataRequest().getRreshDataResponse(userId, uticket);
		}

	@Test
	// 待评价和待确认数量
	public void getRreshDataResponse1() {
		Assert.assertEquals(CommonUtils.parseJson("seekHouseNum", result), "0");
	}

	@Test
	// 待评价数量
	public void getRreshDataResponse2() {
		Assert.assertEquals(CommonUtils.parseJson("appointNum", result), "0");
	}

	@Test
	// 是否有提醒或通知或动态或活动 大于零:true,0:false
	public void getRreshDataResponse3() {
		Assert.assertEquals(CommonUtils.parseJson("hasNewNotify", result), "0");
	}

	@Test
	// 提醒数
	public void getRreshDataResponse4() {
		Assert.assertEquals(CommonUtils.parseJson("remindNum", result), "1");
	}

	@Test
	// 通知数
	public void getRreshDataResponse5() {
		Assert.assertEquals(CommonUtils.parseJson("noticeNum", result), "0");
	}

	@Test
	// 动态是否有最新消息 0：无，1：有
	public void getRreshDataResponse6() {
		Assert.assertEquals(CommonUtils.parseJson("hasNewDynamic", result), "0");
	}

	@Test
	// 未读的关注数（关注列表红点展示用）
	public void getRreshDataResponse7() {
		Assert.assertEquals(CommonUtils.parseJson("notReadCollectionNum", result), "45");
	}

	@Test
	// 是否有弹窗活动 1有 0没有
	public void getRreshDataResponse8() {
		Assert.assertEquals(CommonUtils.parseJson("hasPopActive", result), "0");
	}

	@Test
	// 活动未读数
	public void getRreshDataResponse9() {
		Assert.assertEquals(CommonUtils.parseJson("activityNum", result), "0");
	}

	@Test
	// 预约看房数
	public void getRreshDataResponse10() {
		Assert.assertEquals(CommonUtils.parseJson("reserveNum", result), "2");
	}

	@Test
	// 出租房源未读数 0:无；大于0：有
	public void getRreshDataResponse11() {
		Assert.assertEquals(CommonUtils.parseJson("rentFeedHouseUnreadCount", result), "0");
	}

	@Test
	// 出售房源未读数 0:无；大于0：有
	public void getRreshDataResponse12() {
		Assert.assertEquals(CommonUtils.parseJson("saleFeedHouseUnreadCount", result), "0");
	}

	@Test
	// 小区未读数 0:无；大于0：有
	public void getRreshDataResponse() {
		Assert.assertEquals(CommonUtils.parseJson("estateUnreadCount", result), "0");
	}
}
