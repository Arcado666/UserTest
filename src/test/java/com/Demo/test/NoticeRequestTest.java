package com.Demo.test;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.AddLogWrap;
import com.Common.UserCommon;
import com.Demo.NoticeRequest;
import com.qiang.db.slim.DbSlimSelectQuery;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class NoticeRequestTest {
	public static final Logger logger = Logger.getLogger(NoticeRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	@BeforeClass
	public void getPorperties() {
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		
		logger.info(NoticeRequestTest.class.getName());
		logger.info("账户提醒、通知测试 --->>>");
		}
  @Test
  public void getNoticeResponse1() {
	  logger.info("获取免打扰的经纪人列表");
    String result = new NoticeRequest().getNoticeResponse(uticket, "1");
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
		logger.error(result);
		throw new RuntimeException(result);
	}
    logger.info("result="+result+"");
    //查询用户未读消息数目SELECT COUNT(*) FROM iwnotice_beta.iw_notice_remind WHERE receiveId=2726861 and status = 0;
    DbSlimSelectQuery db = new DbSlimSelectQuery("121.40.127.92", "3309", "qa_tmp", "mjl84_)l23jda0l_23");
	String num = db.queryByName("COUNT(*)","SELECT COUNT(*) FROM iwnotice_beta.iw_notice_remind WHERE receiveId="+userId+" and status = 0;");
	logger.info("获取消息数量为 "+num+"");
    Assert.assertEquals(CommonUtils.parseJson("remindNum", result), num);
  }
  @Test
  public void getNoticeResponse2() {
	  logger.info("不获取免打扰的经纪人列表");
    String result = new NoticeRequest().getNoticeResponse(uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
		logger.error(result);
		throw new RuntimeException(result);
	}
    logger.info("result="+result+"");
    DbSlimSelectQuery db = new DbSlimSelectQuery("121.40.127.92", "3309", "qa_tmp", "mjl84_)l23jda0l_23");
	String num = db.queryByName("COUNT(*)","SELECT COUNT(*) FROM iwnotice_beta.iw_notice_remind WHERE receiveId="+userId+" and status = 0;");
	logger.info("获取消息数量为 "+num+"");
    Assert.assertEquals(CommonUtils.parseJson("remindNum", result), num);
  }
  @AfterClass
  public void afterclass(){
	  logger.info("<<<---账户提醒、通知测试");
	  new AddLogWrap();
  }
}
