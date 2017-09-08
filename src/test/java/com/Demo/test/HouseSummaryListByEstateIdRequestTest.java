package com.Demo.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Common.UserCommon;
import com.Demo.HouseSummaryListByEstateIdRequest;
import com.Model.HouseBaseModel;
import com.Model.HouseMarkByLevelModel;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class HouseSummaryListByEstateIdRequestTest {
	public static final Logger LOGGER = Logger.getLogger(HouseSummaryListByEstateIdRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	String result1;
	String result2;
	String result3;
	@BeforeClass
	public void getPorperties() {
		LOGGER.info("小区房源列表--->>>");
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		result1 = new HouseSummaryListByEstateIdRequest().getHouseSummaryListByEstateIdResponse(getHouseMarkByLevelModel1(), uticket);
		if (CommonUtils.parseJson("errorCode", result1).equals("110001")) {
	    	LOGGER.error(result1);
			throw new RuntimeException(result1);
		}
	    LOGGER.info("result1="+result1+"");
		result2 = new HouseSummaryListByEstateIdRequest().getHouseSummaryListByEstateIdResponse(getHouseMarkByLevelModel2(), uticket);
		if (CommonUtils.parseJson("errorCode", result2).equals("110001")) {
	    	LOGGER.error(result2);
			throw new RuntimeException(result2);
		}
	    LOGGER.info("result2="+result2+"");
		result3 = new HouseSummaryListByEstateIdRequest().getHouseSummaryListByEstateIdResponse(getHouseMarkByLevelModel3(), uticket);
		if (CommonUtils.parseJson("errorCode", result3).equals("110001")) {
	    	LOGGER.error(result3);
			throw new RuntimeException(result3);
		}
	    LOGGER.info("result="+result3+"");
		}
  @Test
  /**
   * 二手房宝山区上大板块祁连欣苑小区的房源
   */
  public void getHouseSummaryListByLevelResponse1() {
	  LOGGER.info("二手房宝山区上大板块祁连欣苑小区的房源");
	  LOGGER.info("estateName="+CommonUtils.parseJson("estateName", result1)+"");
    Assert.assertEquals(CommonUtils.parseJson("estateName", result1), "祁连欣苑");
    LOGGER.info("blockName="+CommonUtils.parseJson("blockName", result1)+"");
    Assert.assertEquals(CommonUtils.parseJson("blockName", result1), "上大");
    LOGGER.info("blockId="+CommonUtils.parseJson("blockId", result1)+"");
    Assert.assertEquals(CommonUtils.parseJson("blockId", result1), "8867");
    LOGGER.info("areaId="+CommonUtils.parseJson("areaId", result1)+"");
    Assert.assertEquals(CommonUtils.parseJson("areaId", result1), "13");
    LOGGER.info("areaName="+CommonUtils.parseJson("areaName", result1)+"");
    Assert.assertEquals(CommonUtils.parseJson("areaName", result1), "宝山");
    LOGGER.info("estateId="+CommonUtils.parseJson("estateId", result1)+"");
    Assert.assertEquals(CommonUtils.parseJson("estateId", result1), "9193");
    LOGGER.info("constructDate="+CommonUtils.parseJson("constructDate", result1)+"");
    Assert.assertEquals(CommonUtils.parseJson("constructDate", result1), "2005");
    LOGGER.info("attentionNo="+CommonUtils.parseJson("attentionNo", result1)+"");
    Assert.assertEquals(CommonUtils.parseJson("attentionNo", result1), "59");//关注数量
  }
  @Test
  public void getHouseSummaryListByLevelResponse2() {
    List<HouseBaseModel> houseBaseModels = JSON.parseArray(CommonUtils.parseJson("rows", result1), HouseBaseModel.class);
    int size = houseBaseModels.size();
    for (int i = 0; i < size; i++) {
		HouseBaseModel houseBaseModel = houseBaseModels.get(i);
		LOGGER.info("getCityName="+houseBaseModel.getCityName()+"");
		Assert.assertEquals(houseBaseModel.getCityName(), "宝山");
		LOGGER.info("getPicNum="+houseBaseModel.getPicNum()+"");
		Assert.assertNotNull(houseBaseModel.getPicNum());
		LOGGER.info("getPicUrls="+houseBaseModel.getPicUrls()+"");
		Assert.assertNotNull(houseBaseModel.getPicUrls());
		LOGGER.info("getDecorateType="+houseBaseModel.getDecorateType()+"");
		Assert.assertNotNull(houseBaseModel.getDecorateType());
		LOGGER.info("getEstateName="+houseBaseModel.getEstateName()+"");
		Assert.assertEquals(houseBaseModel.getEstateName(), "祁连欣苑");
		LOGGER.info("getAreaName="+houseBaseModel.getAreaName()+"");
		Assert.assertEquals(houseBaseModel.getAreaName(), "宝山 上大");
		LOGGER.info("getFloorType="+houseBaseModel.getFloorType()+"");
		Assert.assertNotNull(houseBaseModel.getFloorType());
		LOGGER.info("getFloorType2="+houseBaseModel.getFloorType2()+"");
		Assert.assertNotNull(houseBaseModel.getFloorType2());
		LOGGER.info("getBedroomSum="+houseBaseModel.getBedroomSum()+"");
		Assert.assertNotNull(houseBaseModel.getBedroomSum());
		LOGGER.info("getEstateId="+houseBaseModel.getEstateId()+"");
		Assert.assertEquals(houseBaseModel.getEstateId(), 9193);
		LOGGER.info("getHdUrls="+houseBaseModel.getHdUrls()+"");
		Assert.assertNotNull(houseBaseModel.getHdUrls());
		LOGGER.info("getLon="+houseBaseModel.getLon()+"");
		Assert.assertNotNull(houseBaseModel.getLon());
		LOGGER.info("getLat="+houseBaseModel.getLat()+"");
		Assert.assertNotNull(houseBaseModel.getLat());
		LOGGER.info("getPlateName="+houseBaseModel.getPlateName()+"");
		Assert.assertEquals(houseBaseModel.getPlateName(), "宝山 上大");
		LOGGER.info("getBuilding="+houseBaseModel.getBuilding()+"");
		Assert.assertEquals(houseBaseModel.getBuilding(), "祁连欣苑");
		LOGGER.info("getHouseSpace="+houseBaseModel.getHouseSpace()+"");
		Assert.assertNotNull(houseBaseModel.getHouseSpace());
		LOGGER.info("getSellPrice="+houseBaseModel.getSellPrice()+"");
		Assert.assertNotNull(houseBaseModel.getSellPrice());
		if (houseBaseModel.getVideoNum()>0) {
			LOGGER.info("getVideoUrl="+houseBaseModel.getVideoUrl()+"");
			Assert.assertNotNull(houseBaseModel.getVideoUrl());
		}
		LOGGER.info("getUnitPrice="+houseBaseModel.getUnitPrice()+"");
		Assert.assertNotNull(houseBaseModel.getUnitPrice());
		LOGGER.info("getRentOrBrand="+houseBaseModel.getRentOrBrand()+"");
		Assert.assertNotNull(houseBaseModel.getRentOrBrand());
		LOGGER.info("getRentType="+houseBaseModel.getRentType()+"");
		Assert.assertNotNull(houseBaseModel.getRentType());
	}
  }
  
  @Test
  /**
   * 租房普陀区真光板块真光四街坊小区房源
   */
  public void getHouseSummaryListByLevelResponse3() {
	  LOGGER.info("租房普陀区真光板块真光四街坊小区房源");
	  LOGGER.info("estateName="+CommonUtils.parseJson("estateName", result2)+"");
	  Assert.assertEquals(CommonUtils.parseJson("estateName", result2), "真光四街坊");
	  LOGGER.info("blockName="+CommonUtils.parseJson("blockName", result2)+"");
	    Assert.assertEquals(CommonUtils.parseJson("blockName", result2), "真光");
	    LOGGER.info("blockId="+CommonUtils.parseJson("blockId", result2)+"");
	    Assert.assertEquals(CommonUtils.parseJson("blockId", result2), "5758");
	    LOGGER.info("areaId="+CommonUtils.parseJson("areaId", result2)+"");
	    Assert.assertEquals(CommonUtils.parseJson("areaId", result2), "11");
	    LOGGER.info("areaName="+CommonUtils.parseJson("areaName", result2)+"");
	    Assert.assertEquals(CommonUtils.parseJson("areaName", result2), "普陀");
	    LOGGER.info("estateId="+CommonUtils.parseJson("estateId", result2)+"");
	    Assert.assertEquals(CommonUtils.parseJson("estateId", result2), "6367");
	    LOGGER.info("constructDate="+CommonUtils.parseJson("constructDate", result2)+"");
	    Assert.assertEquals(CommonUtils.parseJson("constructDate", result2), "1995");
	    LOGGER.info("attentionNo="+CommonUtils.parseJson("attentionNo", result2)+"");
	    Assert.assertEquals(CommonUtils.parseJson("attentionNo", result2), "25");
  }
  @Test
  public void getHouseSummaryListByLevelResponse4() {
    List<HouseBaseModel> houseBaseModels = JSON.parseArray(CommonUtils.parseJson("rows", result2), HouseBaseModel.class);
    int size = houseBaseModels.size();
    for (int i = 0; i < size; i++) {
		HouseBaseModel houseBaseModel = houseBaseModels.get(i);
		LOGGER.info("getPicNum="+houseBaseModel.getPicNum()+"");
		Assert.assertNotNull(houseBaseModel.getPicNum());
		LOGGER.info("getPicUrls="+houseBaseModel.getPicUrls()+"");
		Assert.assertNotNull(houseBaseModel.getPicUrls());
		LOGGER.info("getRentPrice="+houseBaseModel.getRentPrice()+"");
		Assert.assertNotNull(houseBaseModel.getRentPrice());
		LOGGER.info("getEstateName="+houseBaseModel.getEstateName()+"");
		Assert.assertEquals(houseBaseModel.getEstateName(), "真光四街坊");
		LOGGER.info("getAreaName="+houseBaseModel.getAreaName()+"");
		Assert.assertEquals(houseBaseModel.getAreaName(), "普陀");
		LOGGER.info("getFloorType="+houseBaseModel.getFloorType()+"");
		Assert.assertNotNull(houseBaseModel.getFloorType());
		LOGGER.info("getFloorType2="+houseBaseModel.getFloorType2()+"");
		Assert.assertNotNull(houseBaseModel.getFloorType2());
		LOGGER.info("getBedroomSum="+houseBaseModel.getBedroomSum()+"");
		Assert.assertNotNull(houseBaseModel.getBedroomSum());
		LOGGER.info("getPubDate="+houseBaseModel.getPubDate()+"");
		Assert.assertNotNull(houseBaseModel.getPubDate());
		LOGGER.info("getEstateId="+houseBaseModel.getEstateId()+"");
		Assert.assertEquals(houseBaseModel.getEstateId(), 6367);
		LOGGER.info("getHdUrls="+houseBaseModel.getHdUrls()+"");
		Assert.assertNotNull(houseBaseModel.getHdUrls());
		LOGGER.info("getLon="+houseBaseModel.getLon()+"");
		Assert.assertNotNull(houseBaseModel.getLon());
		LOGGER.info("getLat="+houseBaseModel.getLat()+"");
		Assert.assertNotNull(houseBaseModel.getLat());
		LOGGER.info("getPlateName="+houseBaseModel.getPlateName()+"");
		Assert.assertEquals(houseBaseModel.getPlateName(), "普陀 真光");
		LOGGER.info("getBuilding="+houseBaseModel.getBuilding()+"");
		Assert.assertEquals(houseBaseModel.getBuilding(), "真光四街坊");
		LOGGER.info("getHouseSpace="+houseBaseModel.getHouseSpace()+"");
		Assert.assertNotNull(houseBaseModel.getHouseSpace());
		LOGGER.info("getPublishDate="+houseBaseModel.getPublishDate()+"");
		Assert.assertNotNull(houseBaseModel.getPublishDate());
		LOGGER.info("getRentOrBrand="+houseBaseModel.getRentOrBrand()+"");
		Assert.assertNotNull(houseBaseModel.getRentOrBrand());
		LOGGER.info("getRentType="+houseBaseModel.getRentType()+"");
		Assert.assertNotNull(houseBaseModel.getRentType());
	}
  }
  
  
  @Test
  /**
   * 品牌公寓普陀区真光板块长征家苑小区房源
   */
  public void getHouseSummaryListByLevelResponse5() {
	  LOGGER.info("品牌公寓普陀区真光板块长征家苑小区房源");
	  LOGGER.info("estateName="+CommonUtils.parseJson("estateName", result3)+"");
	  Assert.assertEquals(CommonUtils.parseJson("estateName", result3), "长征家苑");
	  LOGGER.info("blockName="+CommonUtils.parseJson("blockName", result3)+"");
	    Assert.assertEquals(CommonUtils.parseJson("blockName", result3), "真光");
	    LOGGER.info("blockId="+CommonUtils.parseJson("blockId", result3)+"");
	    Assert.assertEquals(CommonUtils.parseJson("blockId", result3), "5758");
	    LOGGER.info("areaId="+CommonUtils.parseJson("areaId", result3)+"");
	    Assert.assertEquals(CommonUtils.parseJson("areaId", result3), "11");
	    LOGGER.info("areaName="+CommonUtils.parseJson("areaName", result3)+"");
	    Assert.assertEquals(CommonUtils.parseJson("areaName", result3), "普陀");
	    LOGGER.info("estateId="+CommonUtils.parseJson("estateId", result3)+"");
	    Assert.assertEquals(CommonUtils.parseJson("estateId", result3), "126253");
	    LOGGER.info("constructDate="+CommonUtils.parseJson("constructDate", result3)+"");
	    Assert.assertEquals(CommonUtils.parseJson("constructDate", result3), "0");
  }
  @Test
  public void getHouseSummaryListByLevelResponse6() {
    List<HouseBaseModel> houseBaseModels = JSON.parseArray(CommonUtils.parseJson("rows", result3), HouseBaseModel.class);
    int size = houseBaseModels.size();
    for (int i = 0; i < size; i++) {
		HouseBaseModel houseBaseModel = houseBaseModels.get(i);
		LOGGER.info("getPicNum="+houseBaseModel.getPicNum()+"");
		Assert.assertNotNull(houseBaseModel.getPicNum());
		LOGGER.info("getPicUrls="+houseBaseModel.getPicUrls()+"");
		Assert.assertNotNull(houseBaseModel.getPicUrls());
		LOGGER.info("getRentPrice="+houseBaseModel.getRentPrice()+"");
		Assert.assertNotNull(houseBaseModel.getRentPrice());
		LOGGER.info("getEstateName="+houseBaseModel.getEstateName()+"");
		Assert.assertEquals(houseBaseModel.getEstateName(), "长征家苑");
		LOGGER.info("getAreaName="+houseBaseModel.getAreaName()+"");
		Assert.assertEquals(houseBaseModel.getAreaName(), "普陀");
		LOGGER.info("getHouseId="+houseBaseModel.getHouseId()+"");
		Assert.assertNotNull(houseBaseModel.getHouseId());
		LOGGER.info("getFloorType="+houseBaseModel.getFloorType()+"");
		Assert.assertNotNull(houseBaseModel.getFloorType());
		LOGGER.info("getFloorType2="+houseBaseModel.getFloorType2()+"");
		Assert.assertNotNull(houseBaseModel.getFloorType2());
		LOGGER.info("getBedroomSum="+houseBaseModel.getBedroomSum()+"");
		Assert.assertNotNull(houseBaseModel.getBedroomSum());
		LOGGER.info("getPubDate="+houseBaseModel.getPubDate()+"");
		Assert.assertNotNull(houseBaseModel.getPubDate());
		LOGGER.info("getEstateId="+houseBaseModel.getEstateId()+"");
		Assert.assertEquals(houseBaseModel.getEstateId(), 126253);
		LOGGER.info("getLon="+houseBaseModel.getLon()+"");
		Assert.assertNotNull(houseBaseModel.getLon());
		LOGGER.info("getLat="+houseBaseModel.getLat()+"");
		Assert.assertNotNull(houseBaseModel.getLat());
		LOGGER.info("getPlateName="+houseBaseModel.getPlateName()+"");
		Assert.assertEquals(houseBaseModel.getPlateName(), "普陀 真光");
		LOGGER.info("getBuilding="+houseBaseModel.getBuilding()+"");
		Assert.assertEquals(houseBaseModel.getBuilding(), "长征家苑");
		LOGGER.info("getHouseSpace="+houseBaseModel.getHouseSpace()+"");
		Assert.assertNotNull(houseBaseModel.getHouseSpace());
		LOGGER.info("getPublishDate="+houseBaseModel.getPublishDate()+"");
		Assert.assertNotNull(houseBaseModel.getPublishDate());
		LOGGER.info("getRentOrBrand="+houseBaseModel.getRentOrBrand()+"");
		Assert.assertNotNull(houseBaseModel.getRentOrBrand());
		LOGGER.info("getRentType="+houseBaseModel.getRentType()+"");
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
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---小区房源列表");
  }
}
