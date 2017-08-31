package com.Demo.test;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Common.UserCommon;
import com.Demo.HouseSummaryListByEstateIdRequest;
import com.Model.HouseBaseModel;
import com.Model.HouseMarkByLevelModel;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.FormJSON;
import com.qiang.utils.UseProperties;

public class HouseSummaryListByEstateIdRequestTest {
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	String result1;
	String result2;
	String result3;
	@BeforeClass
	public void getPorperties() {
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		result1 = new HouseSummaryListByEstateIdRequest().getHouseSummaryListByEstateIdResponse(getHouseMarkByLevelModel1(), uticket);
		result2 = new HouseSummaryListByEstateIdRequest().getHouseSummaryListByEstateIdResponse(getHouseMarkByLevelModel2(), uticket);
		result3 = new HouseSummaryListByEstateIdRequest().getHouseSummaryListByEstateIdResponse(getHouseMarkByLevelModel3(), uticket);
		}
  @Test
  /**
   * 二手房宝山区上大板块祁连欣苑小区的房源
   */
  public void getHouseSummaryListByLevelResponse1() {
    Assert.assertEquals(CommonUtils.parseJson("estateName", result1), "祁连欣苑");
    Assert.assertEquals(CommonUtils.parseJson("blockName", result1), "上大");
    Assert.assertEquals(CommonUtils.parseJson("blockId", result1), "8867");
    Assert.assertEquals(CommonUtils.parseJson("areaId", result1), "13");
    Assert.assertEquals(CommonUtils.parseJson("areaName", result1), "宝山");
    Assert.assertEquals(CommonUtils.parseJson("estateId", result1), "9193");
    Assert.assertEquals(CommonUtils.parseJson("constructDate", result1), "2005");
    Assert.assertEquals(CommonUtils.parseJson("attentionNo", result1), "59");//关注数量
  }
  @Test
  public void getHouseSummaryListByLevelResponse2() {
    List<HouseBaseModel> houseBaseModels = JSON.parseArray(CommonUtils.parseJson("rows", result1), HouseBaseModel.class);
    int size = houseBaseModels.size();
    for (int i = 0; i < size; i++) {
		HouseBaseModel houseBaseModel = houseBaseModels.get(i);
		Assert.assertEquals(houseBaseModel.getCityName(), "宝山");
		Assert.assertNotNull(houseBaseModel.getPicNum());
		Assert.assertNotNull(houseBaseModel.getPicUrls());
		Assert.assertNotNull(houseBaseModel.getDecorateType());
		Assert.assertEquals(houseBaseModel.getEstateName(), "祁连欣苑");
		Assert.assertEquals(houseBaseModel.getAreaName(), "宝山 上大");
		Assert.assertNotNull(houseBaseModel.getFloorType());
		Assert.assertNotNull(houseBaseModel.getFloorType2());
		Assert.assertNotNull(houseBaseModel.getBedroomSum());
		Assert.assertEquals(houseBaseModel.getEstateId(), 9193);
		Assert.assertNotNull(houseBaseModel.getHdUrls());
		Assert.assertNotNull(houseBaseModel.getLon());
		Assert.assertNotNull(houseBaseModel.getLat());
		Assert.assertEquals(houseBaseModel.getPlateName(), "宝山 上大");
		Assert.assertEquals(houseBaseModel.getBuilding(), "祁连欣苑");
		Assert.assertNotNull(houseBaseModel.getHouseSpace());
		Assert.assertNotNull(houseBaseModel.getSellPrice());
		if (houseBaseModel.getVideoNum()>0) {
			Assert.assertNotNull(houseBaseModel.getVideoUrl());
		}
		Assert.assertNotNull(houseBaseModel.getUnitPrice());
		Assert.assertNotNull(houseBaseModel.getRentOrBrand());
		Assert.assertNotNull(houseBaseModel.getRentType());
	}
  }
  
  @Test
  /**
   * 租房普陀区真光板块真光四街坊小区房源
   */
  public void getHouseSummaryListByLevelResponse3() {
	  Assert.assertEquals(CommonUtils.parseJson("estateName", result2), "真光四街坊");
	    Assert.assertEquals(CommonUtils.parseJson("blockName", result2), "真光");
	    Assert.assertEquals(CommonUtils.parseJson("blockId", result2), "5758");
	    Assert.assertEquals(CommonUtils.parseJson("areaId", result2), "11");
	    Assert.assertEquals(CommonUtils.parseJson("areaName", result2), "普陀");
	    Assert.assertEquals(CommonUtils.parseJson("estateId", result2), "6367");
	    Assert.assertEquals(CommonUtils.parseJson("constructDate", result2), "1995");
	    Assert.assertEquals(CommonUtils.parseJson("attentionNo", result2), "25");
  }
  @Test
  public void getHouseSummaryListByLevelResponse4() {
    List<HouseBaseModel> houseBaseModels = JSON.parseArray(CommonUtils.parseJson("rows", result2), HouseBaseModel.class);
    int size = houseBaseModels.size();
    for (int i = 0; i < size; i++) {
		HouseBaseModel houseBaseModel = houseBaseModels.get(i);
		Assert.assertNotNull(houseBaseModel.getPicNum());
		Assert.assertNotNull(houseBaseModel.getPicUrls());
		Assert.assertNotNull(houseBaseModel.getRentPrice());
		Assert.assertEquals(houseBaseModel.getEstateName(), "真光四街坊");
		Assert.assertEquals(houseBaseModel.getAreaName(), "普陀 真光");
		Assert.assertNotNull(houseBaseModel.getFloorType());
		Assert.assertNotNull(houseBaseModel.getFloorType2());
		Assert.assertNotNull(houseBaseModel.getBedroomSum());
		Assert.assertNotNull(houseBaseModel.getPubDate());
		Assert.assertEquals(houseBaseModel.getEstateId(), 6367);
		Assert.assertNotNull(houseBaseModel.getHdUrls());
		Assert.assertNotNull(houseBaseModel.getLon());
		Assert.assertNotNull(houseBaseModel.getLat());
		Assert.assertEquals(houseBaseModel.getPlateName(), "普陀 真光");
		Assert.assertEquals(houseBaseModel.getBuilding(), "真光四街坊");
		Assert.assertNotNull(houseBaseModel.getHouseSpace());
		Assert.assertNotNull(houseBaseModel.getPublishDate());
		Assert.assertNotNull(houseBaseModel.getRentOrBrand());
		Assert.assertNotNull(houseBaseModel.getRentType());
	}
  }
  
  
  @Test
  /**
   * 品牌公寓普陀区真光板块长征家苑小区房源
   */
  public void getHouseSummaryListByLevelResponse5() {
	  Assert.assertEquals(CommonUtils.parseJson("estateName", result3), "长征家苑");
	    Assert.assertEquals(CommonUtils.parseJson("blockName", result3), "真光");
	    Assert.assertEquals(CommonUtils.parseJson("blockId", result3), "5758");
	    Assert.assertEquals(CommonUtils.parseJson("areaId", result3), "11");
	    Assert.assertEquals(CommonUtils.parseJson("areaName", result3), "普陀");
	    Assert.assertEquals(CommonUtils.parseJson("estateId", result3), "126253");
	    Assert.assertEquals(CommonUtils.parseJson("constructDate", result3), "0");
  }
  @Test
  public void getHouseSummaryListByLevelResponse6() {
	  System.err.println(FormJSON.format(result3));
    List<HouseBaseModel> houseBaseModels = JSON.parseArray(CommonUtils.parseJson("rows", result3), HouseBaseModel.class);
    int size = houseBaseModels.size();
    for (int i = 0; i < size; i++) {
		HouseBaseModel houseBaseModel = houseBaseModels.get(i);
		Assert.assertNotNull(houseBaseModel.getPicNum());
		Assert.assertNotNull(houseBaseModel.getPicUrls());
		Assert.assertNotNull(houseBaseModel.getRentPrice());
		Assert.assertEquals(houseBaseModel.getEstateName(), "长征家苑");
		Assert.assertEquals(houseBaseModel.getAreaName(), "普陀 真光");
		Assert.assertNotNull(houseBaseModel.getHouseId());
		Assert.assertNotNull(houseBaseModel.getFloorType());
		Assert.assertNotNull(houseBaseModel.getFloorType2());
		Assert.assertNotNull(houseBaseModel.getBedroomSum());
		Assert.assertNotNull(houseBaseModel.getPubDate());
		Assert.assertEquals(houseBaseModel.getEstateId(), 126253);
		Assert.assertNotNull(houseBaseModel.getLon());
		Assert.assertNotNull(houseBaseModel.getLat());
		Assert.assertEquals(houseBaseModel.getPlateName(), "普陀 真光");
		Assert.assertEquals(houseBaseModel.getBuilding(), "长征家苑");
		Assert.assertNotNull(houseBaseModel.getHouseSpace());
		Assert.assertNotNull(houseBaseModel.getPublishDate());
		Assert.assertNotNull(houseBaseModel.getRentOrBrand());
		Assert.assertNotNull(houseBaseModel.getRentType());
	}
  }
  
  /**
   * 二手房设置参数
   * @return
   */
  private static HouseMarkByLevelModel getHouseMarkByLevelModel1(){
	  HouseMarkByLevelModel houseMarkByLevelModel = new HouseMarkByLevelModel();
	  houseMarkByLevelModel.setCity("2");
	  houseMarkByLevelModel.setRentOrSale(1);
	  houseMarkByLevelModel.setLevel(18);
	  houseMarkByLevelModel.setAreaId(9193);
	  houseMarkByLevelModel.setLon(121.383627);
	  houseMarkByLevelModel.setLat(31.316807);
	  houseMarkByLevelModel.setPageSize(20);
	  houseMarkByLevelModel.setSequence(5);
	  return houseMarkByLevelModel;
  }
  /**
   * 租房设置参数
   * @return
   */
  private static HouseMarkByLevelModel getHouseMarkByLevelModel2(){
	  HouseMarkByLevelModel houseMarkByLevelModel = new HouseMarkByLevelModel();
	  houseMarkByLevelModel.setCity("2");
	  houseMarkByLevelModel.setRentOrSale(0);
	  houseMarkByLevelModel.setLevel(18);
	  houseMarkByLevelModel.setAreaId(6367);
	  houseMarkByLevelModel.setLon(121.392155);
	  houseMarkByLevelModel.setLat(31.258730);
	  houseMarkByLevelModel.setPageSize(20);
	  houseMarkByLevelModel.setSequence(5);
	  return houseMarkByLevelModel;
  }
  /**
   * 品牌公寓设置参数
   * @return
   */
  private static HouseMarkByLevelModel getHouseMarkByLevelModel3(){
	  HouseMarkByLevelModel houseMarkByLevelModel = new HouseMarkByLevelModel();
	  houseMarkByLevelModel.setCity("2");
	  houseMarkByLevelModel.setRentOrSale(0);
	  houseMarkByLevelModel.setLevel(18);
	  houseMarkByLevelModel.setAreaId(126253);
	  houseMarkByLevelModel.setLon(121.395069);
	  houseMarkByLevelModel.setLat(31.257864);
	  houseMarkByLevelModel.setPageSize(20);
	  houseMarkByLevelModel.setSequence(5);
	  return houseMarkByLevelModel;
  }
}
