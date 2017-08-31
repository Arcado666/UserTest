package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.NoticeRequest;
import com.qiang.db.slim.DbSlimSelectQuery;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class NoticeRequestTest {
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	@BeforeClass
	public void getPorperties() {
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		}
  @Test
  public void getNoticeResponse1() {
    String result = new NoticeRequest().getNoticeResponse(uticket, "1");
    
    //查询用户未读消息数目SELECT COUNT(*) FROM iwnotice_beta.iw_notice_remind WHERE receiveId=2726861 and status = 0;
	  //测试
    DbSlimSelectQuery db = new DbSlimSelectQuery("121.40.127.92", "3309", "qa_tmp", "mjl84_)l23jda0l_23");
	String num = db.queryByName("COUNT(*)","SELECT COUNT(*) FROM iwnotice_beta.iw_notice_remind WHERE receiveId="+userId+" and status = 0;");
    Assert.assertEquals(CommonUtils.parseJson("remindNum", result), num);
  }
  @Test
  public void getNoticeResponse2() {
    String result = new NoticeRequest().getNoticeResponse(uticket);
    DbSlimSelectQuery db = new DbSlimSelectQuery("121.40.127.92", "3309", "qa_tmp", "mjl84_)l23jda0l_23");
	String num = db.queryByName("COUNT(*)","SELECT COUNT(*) FROM iwnotice_beta.iw_notice_remind WHERE receiveId="+userId+" and status = 0;");
    Assert.assertEquals(CommonUtils.parseJson("remindNum", result), num);
  }
}
