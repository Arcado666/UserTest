package com.Demo.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.AddLogWrap;
import com.Common.UserCommon;
import com.Demo.CollectionHouseListByTypeRequest;
import com.Model.CollectionHouseModel;
import com.Model.HistoryModel;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class CollectionHouseListByTypeRequestTest {
	public static final Logger LOGGER = Logger.getLogger(CollectionHouseListByTypeRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	String result1;
	String result2;
	@BeforeClass
	public void getPorperties() {
		LOGGER.info("根据房源类型获取关注的房源列表（租房、二手房）--->>>");
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		LOGGER.info("根据房源类型获取关注的房源列表（租房）");
		result1 = new CollectionHouseListByTypeRequest().getCollectionHouseListByTypeResponse("100", uticket, "0", "0", "-1");
		if (CommonUtils.parseJson("errorCode", result1).equals("110001")) {
	    	LOGGER.error(result1);
			throw new RuntimeException(result1);
		}
	    LOGGER.info("result1="+result1+"");
	    LOGGER.info("根据房源类型获取关注的房源列表（二手房）");
		result2 = new CollectionHouseListByTypeRequest().getCollectionHouseListByTypeResponse("100", uticket, "0", "1", "-1");
		if (CommonUtils.parseJson("errorCode", result2).equals("110001")) {
	    	LOGGER.error(result2);
			throw new RuntimeException(result2);
		}
	    LOGGER.info("result="+result2+"");
		}
  @Test
  public void getCollectionHouseListByTypeResponse1() {
	  LOGGER.info("验证租房houseList");
    String houseList = CommonUtils.parseJson("houseList", result1);
    List<CollectionHouseModel> collectionHouseModels = JSON.parseArray(houseList, CollectionHouseModel.class);
    int size = collectionHouseModels.size();
    for (int i = 0; i < size; i++) {
		CollectionHouseModel collectionHouseModel = collectionHouseModels.get(i);
		LOGGER.info("collectionHouseModel.getEnable()="+collectionHouseModel.getEnable()+"");
		Assert.assertNotNull(collectionHouseModel.getEnable());
		LOGGER.info("collectionHouseModel.getEstateId()="+collectionHouseModel.getEstateId()+"");
		Assert.assertNotNull(collectionHouseModel.getEstateId());
		LOGGER.info("collectionHouseModel.getHouseId()="+collectionHouseModel.getHouseId()+"");
		Assert.assertNotNull(collectionHouseModel.getHouseId());
		LOGGER.info("collectionHouseModel.getEstateName()="+collectionHouseModel.getEstateName()+"");
		Assert.assertNotNull(collectionHouseModel.getEstateName());
		LOGGER.info("collectionHouseModel.getRentPrice()="+collectionHouseModel.getRentPrice()+"");
		Assert.assertNotNull(collectionHouseModel.getRentPrice());
		LOGGER.info("collectionHouseModel.getBedroomSum()="+collectionHouseModel.getBedroomSum()+"");
		Assert.assertNotNull(collectionHouseModel.getBedroomSum());
		LOGGER.info("collectionHouseModel.getLivingRoomSum()="+collectionHouseModel.getLivingRoomSum()+"");
		Assert.assertNotNull(collectionHouseModel.getLivingRoomSum());
		LOGGER.info("collectionHouseModel.getWcSum()="+collectionHouseModel.getWcSum()+"");
		Assert.assertNotNull(collectionHouseModel.getWcSum());
		LOGGER.info("collectionHouseModel.getHouseSpace()="+collectionHouseModel.getHouseSpace()+"");
		Assert.assertNotNull(collectionHouseModel.getHouseSpace());
		LOGGER.info("collectionHouseModel.getRentOrSale()="+collectionHouseModel.getRentOrSale()+"");
		Assert.assertEquals(collectionHouseModel.getRentOrSale(), 0);
		LOGGER.info("collectionHouseModel.getVideoNum()="+collectionHouseModel.getVideoNum()+"");
		Assert.assertNotNull(collectionHouseModel.getVideoNum());
		LOGGER.info("collectionHouseModel.getReadStatus()="+collectionHouseModel.getReadStatus()+"");
		Assert.assertNotNull(collectionHouseModel.getReadStatus());
		LOGGER.info("collectionHouseModel.getMarkContent()="+collectionHouseModel.getMarkContent()+"");
		Assert.assertNotNull(collectionHouseModel.getMarkContent());
		LOGGER.info("collectionHouseModel.getFloorStr()="+collectionHouseModel.getFloorStr()+"");
		Assert.assertNotNull(collectionHouseModel.getFloorStr());
		LOGGER.info("collectionHouseModel.getFloorType2()="+collectionHouseModel.getFloorType2()+"");
		Assert.assertNotNull(collectionHouseModel.getFloorType2());
		LOGGER.info("collectionHouseModel.getTag()="+collectionHouseModel.getTag()+"");
		Assert.assertNotNull(collectionHouseModel.getTag());
		if (collectionHouseModel.getHis() != null) {
			List<HistoryModel> historyModels = JSON.parseArray(JSON.toJSONString(collectionHouseModel.getHis()), HistoryModel.class);
			int x = historyModels.size();
			for (int j = 0; j < x; j++) {
				HistoryModel historyModel = historyModels.get(j);
				LOGGER.info("historyModel.getCreateDate()="+historyModel.getCreateDate()+"");
				Assert.assertNotNull(historyModel.getCreateDate());
				LOGGER.info("historyModel.getMarkContent()="+historyModel.getMarkContent()+"");
				Assert.assertNotNull(historyModel.getMarkContent());
				LOGGER.info("historyModel.getReadStatus()="+historyModel.getReadStatus()+"");
				Assert.assertNotNull(historyModel.getReadStatus());
				LOGGER.info("historyModel.getFeedType()="+historyModel.getFeedType()+"");
				Assert.assertNotNull(historyModel.getFeedType());
			}
		}
    }
  }
  @Test
  public void getCollectionHouseListByTypeResponse2() {
	  LOGGER.info("验证二手房houseList");
	  String houseList = CommonUtils.parseJson("houseList", result2);
	    List<CollectionHouseModel> collectionHouseModels = JSON.parseArray(houseList, CollectionHouseModel.class);
	    int size = collectionHouseModels.size();
	    for (int i = 0; i < size; i++) {
			CollectionHouseModel collectionHouseModel = collectionHouseModels.get(i);
			LOGGER.info("collectionHouseModel.getEnable()="+collectionHouseModel.getEnable()+"");
			Assert.assertNotNull(collectionHouseModel.getEnable());
			LOGGER.info("collectionHouseModel.getEstateId()="+collectionHouseModel.getEstateId()+"");
			Assert.assertNotNull(collectionHouseModel.getEstateId());
			LOGGER.info("collectionHouseModel.getHouseId()="+collectionHouseModel.getHouseId()+"");
			Assert.assertNotNull(collectionHouseModel.getHouseId());
			LOGGER.info("collectionHouseModel.getEstateName()="+collectionHouseModel.getEstateName()+"");
			Assert.assertNotNull(collectionHouseModel.getEstateName());
			LOGGER.info("collectionHouseModel.getSellPrice()="+collectionHouseModel.getSellPrice()+"");
			Assert.assertNotNull(collectionHouseModel.getSellPrice());
			LOGGER.info("collectionHouseModel.getBedroomSum()="+collectionHouseModel.getBedroomSum()+"");
			Assert.assertNotNull(collectionHouseModel.getBedroomSum());
			LOGGER.info("collectionHouseModel.getLivingRoomSum()="+collectionHouseModel.getLivingRoomSum()+"");
			Assert.assertNotNull(collectionHouseModel.getLivingRoomSum());
			LOGGER.info("collectionHouseModel.getWcSum()="+collectionHouseModel.getWcSum()+"");
			Assert.assertNotNull(collectionHouseModel.getWcSum());
			LOGGER.info("collectionHouseModel.getHouseSpace()="+collectionHouseModel.getHouseSpace()+"");
			Assert.assertNotNull(collectionHouseModel.getHouseSpace());
			LOGGER.info("collectionHouseModel.getRentOrSale()="+collectionHouseModel.getRentOrSale()+"");
			Assert.assertEquals(collectionHouseModel.getRentOrSale(), 1);
			LOGGER.info("collectionHouseModel.getVideoNum()="+collectionHouseModel.getVideoNum()+"");
			Assert.assertNotNull(collectionHouseModel.getVideoNum());
			LOGGER.info("collectionHouseModel.getReadStatus()="+collectionHouseModel.getReadStatus()+"");
			Assert.assertNotNull(collectionHouseModel.getReadStatus());
			LOGGER.info("collectionHouseModel.getMarkContent()="+collectionHouseModel.getMarkContent()+"");
			Assert.assertNotNull(collectionHouseModel.getMarkContent());
			LOGGER.info("collectionHouseModel.getFloorStr()="+collectionHouseModel.getFloorStr()+"");
			Assert.assertNotNull(collectionHouseModel.getFloorStr());
			LOGGER.info("collectionHouseModel.getFloorType2()="+collectionHouseModel.getFloorType2()+"");
			Assert.assertNotNull(collectionHouseModel.getFloorType2());
			LOGGER.info("collectionHouseModel.getTag()="+collectionHouseModel.getTag()+"");
			Assert.assertNotNull(collectionHouseModel.getTag());
			LOGGER.info("collectionHouseModel.getUnitPrice()="+collectionHouseModel.getUnitPrice()+"");
			Assert.assertNotNull(collectionHouseModel.getUnitPrice());
			if (collectionHouseModel.getHis() != null) {
				List<HistoryModel> historyModels = JSON.parseArray(JSON.toJSONString(collectionHouseModel.getHis()), HistoryModel.class);
				int x = historyModels.size();
				for (int j = 0; j < x; j++) {
					HistoryModel historyModel = historyModels.get(j);
					LOGGER.info("historyModel.getCreateDate()="+historyModel.getCreateDate()+"");
					Assert.assertNotNull(historyModel.getCreateDate());
					LOGGER.info("historyModel.getMarkContent()="+historyModel.getMarkContent()+"");
					Assert.assertNotNull(historyModel.getMarkContent());
					LOGGER.info("historyModel.getReadStatus()="+historyModel.getReadStatus()+"");
					Assert.assertNotNull(historyModel.getReadStatus());
					LOGGER.info("historyModel.getFeedType()="+historyModel.getFeedType()+"");
					Assert.assertNotNull(historyModel.getFeedType());
				}
			}
	    }
  }
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---根据房源类型获取关注的房源列表（租房、二手房）");
	  new AddLogWrap();
  }
}
