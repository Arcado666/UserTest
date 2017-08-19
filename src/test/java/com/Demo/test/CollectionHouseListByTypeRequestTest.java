package com.Demo.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.CollectionHouseListByTypeRequest;
import com.Model.CollectionHouseModel;
import com.Model.HistoryModel;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class CollectionHouseListByTypeRequestTest {
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	String result1;
	String result2;
	@BeforeClass
	public void getPorperties() {
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		result1 = new CollectionHouseListByTypeRequest().getCollectionHouseListByTypeResponse("100", uticket, "0", "0", "-1");
		result2 = new CollectionHouseListByTypeRequest().getCollectionHouseListByTypeResponse("100", uticket, "0", "1", "-1");
		}
  @Test
  public void getCollectionHouseListByTypeResponse1() {
    String houseList = CommonUtils.parseJson("houseList", result1);
    List<CollectionHouseModel> collectionHouseModels = JSON.parseArray(houseList, CollectionHouseModel.class);
    int size = collectionHouseModels.size();
    for (int i = 0; i < size; i++) {
		CollectionHouseModel collectionHouseModel = collectionHouseModels.get(i);
		Assert.assertNotNull(collectionHouseModel.getEnable());
		Assert.assertNotNull(collectionHouseModel.getEstateId());
		Assert.assertNotNull(collectionHouseModel.getHouseId());
		Assert.assertNotNull(collectionHouseModel.getEstateName());
		Assert.assertNotNull(collectionHouseModel.getRentPrice());
		Assert.assertNotNull(collectionHouseModel.getBedroomSum());
		Assert.assertNotNull(collectionHouseModel.getLivingRoomSum());
		Assert.assertNotNull(collectionHouseModel.getWcSum());
		Assert.assertNotNull(collectionHouseModel.getHouseSpace());
		Assert.assertEquals(collectionHouseModel.getRentOrSale(), 0);
		Assert.assertNotNull(collectionHouseModel.getVideoNum());
		Assert.assertNotNull(collectionHouseModel.getReadStatus());
		Assert.assertNotNull(collectionHouseModel.getMarkContent());
		Assert.assertNotNull(collectionHouseModel.getFloorStr());
		Assert.assertNotNull(collectionHouseModel.getFloorType2());
		Assert.assertNotNull(collectionHouseModel.getTag());
		if (collectionHouseModel.getHis() != null) {
			List<HistoryModel> historyModels = JSON.parseArray(JSON.toJSONString(collectionHouseModel.getHis()), HistoryModel.class);
			int x = historyModels.size();
			for (int j = 0; j < x; j++) {
				HistoryModel historyModel = historyModels.get(j);
				Assert.assertNotNull(historyModel.getCreateDate());
				Assert.assertNotNull(historyModel.getMarkContent());
				Assert.assertNotNull(historyModel.getReadStatus());
				Assert.assertNotNull(historyModel.getFeedType());
			}
		}
    }
  }
  @Test
  public void getCollectionHouseListByTypeResponse2() {
	  String houseList = CommonUtils.parseJson("houseList", result2);
	    List<CollectionHouseModel> collectionHouseModels = JSON.parseArray(houseList, CollectionHouseModel.class);
	    int size = collectionHouseModels.size();
	    for (int i = 0; i < size; i++) {
			CollectionHouseModel collectionHouseModel = collectionHouseModels.get(i);
			Assert.assertNotNull(collectionHouseModel.getEnable());
			Assert.assertNotNull(collectionHouseModel.getEstateId());
			Assert.assertNotNull(collectionHouseModel.getHouseId());
			Assert.assertNotNull(collectionHouseModel.getEstateName());
			Assert.assertNotNull(collectionHouseModel.getSellPrice());
			Assert.assertNotNull(collectionHouseModel.getBedroomSum());
			Assert.assertNotNull(collectionHouseModel.getLivingRoomSum());
			Assert.assertNotNull(collectionHouseModel.getWcSum());
			Assert.assertNotNull(collectionHouseModel.getHouseSpace());
			Assert.assertEquals(collectionHouseModel.getRentOrSale(), 1);
			Assert.assertNotNull(collectionHouseModel.getVideoNum());
			Assert.assertNotNull(collectionHouseModel.getReadStatus());
			Assert.assertNotNull(collectionHouseModel.getMarkContent());
			Assert.assertNotNull(collectionHouseModel.getFloorStr());
			Assert.assertNotNull(collectionHouseModel.getFloorType2());
			Assert.assertNotNull(collectionHouseModel.getTag());
			Assert.assertNotNull(collectionHouseModel.getUnitPrice());
			if (collectionHouseModel.getHis() != null) {
				List<HistoryModel> historyModels = JSON.parseArray(JSON.toJSONString(collectionHouseModel.getHis()), HistoryModel.class);
				int x = historyModels.size();
				for (int j = 0; j < x; j++) {
					HistoryModel historyModel = historyModels.get(j);
					Assert.assertNotNull(historyModel.getCreateDate());
					Assert.assertNotNull(historyModel.getMarkContent());
					Assert.assertNotNull(historyModel.getReadStatus());
					Assert.assertNotNull(historyModel.getFeedType());
				}
			}
	    }
  }
}
