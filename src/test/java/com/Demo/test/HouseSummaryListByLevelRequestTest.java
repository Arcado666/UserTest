package com.Demo.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.HouseSummaryListByLevelRequest;
import com.Model.HouseBaseModel;
import com.Model.HouseMarkByLevelModel;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class HouseSummaryListByLevelRequestTest {
	public static final Logger LOGGER = Logger.getLogger(HouseSummaryListByLevelRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	static String userId;
	String result1;
	String result2;
	String result3;
	@BeforeClass
	public void getPorperties() {
		LOGGER.info("地图可视范围内的房源列表--->>>");
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		result1 = new HouseSummaryListByLevelRequest().getHouseSummaryListByLevelResponse(getHouseMarkByLevelModel1(), uticket);
		if (CommonUtils.parseJson("errorCode", result1).equals("110001")) {
	    	LOGGER.error(result1);
			throw new RuntimeException(result1);
		}
	    LOGGER.info("result1="+result1+"");
		result2 = new HouseSummaryListByLevelRequest().getHouseSummaryListByLevelResponse(getHouseMarkByLevelModel2(), uticket);
		if (CommonUtils.parseJson("errorCode", result2).equals("110001")) {
	    	LOGGER.error(result2);
			throw new RuntimeException(result2);
		}
	    LOGGER.info("result2="+result2+"");
		result3 = new HouseSummaryListByLevelRequest().getHouseSummaryListByLevelResponse(getHouseMarkByLevelModel3(), uticket);
		if (CommonUtils.parseJson("errorCode", result3).equals("110001")) {
	    	LOGGER.error(result3);
			throw new RuntimeException(result3);
		}
	    LOGGER.info("result3="+result3+"");
		}
  @Test
  /**
   * 二手房默认列表页
   */
  public void getHouseSummaryListByLevelResponse1() {
	  LOGGER.info("二手房默认列表页");
    List<HouseBaseModel> houseBaseModels = JSON.parseArray(CommonUtils.parseJson("rows", result1), HouseBaseModel.class);
    int size = houseBaseModels.size();
    for (int i = 0; i < size; i++) {
    	HouseBaseModel houseBaseModel = houseBaseModels.get(i);
    	Assert.assertNotNull(houseBaseModel.getCityName());
    	Assert.assertNotNull(houseBaseModel.getHouseId());
    	Assert.assertNotNull(houseBaseModel.getPicNum());
    	Assert.assertNotNull(houseBaseModel.getPicUrls());
    	Assert.assertNotNull(houseBaseModel.getBedroomSum());
    	Assert.assertNotNull(houseBaseModel.getDecorateType());
    	Assert.assertNotNull(houseBaseModel.getEstateName());
    	Assert.assertNotNull(houseBaseModel.getAreaName());
    	Assert.assertNotNull(houseBaseModel.getFloorType());
    	Assert.assertNotNull(houseBaseModel.getFloor());
    	Assert.assertNotNull(houseBaseModel.getFloorType2());
    	Assert.assertNotNull(houseBaseModel.getEnable());
    	Assert.assertNotNull(houseBaseModel.getEstateId());
    	Assert.assertNotNull(houseBaseModel.getSpaceArea());
    	Assert.assertNotNull(houseBaseModel.getLon());
    	Assert.assertNotNull(houseBaseModel.getLat());
    	Assert.assertNotNull(houseBaseModel.getPlateName());
    	Assert.assertNotNull(houseBaseModel.getHouseSpace());
    	Assert.assertNotNull(houseBaseModel.getSellPrice());
    	Assert.assertNotNull(houseBaseModel.getVideoNum());
    	if(houseBaseModel.getVideoNum()>0){
    		Assert.assertNotNull(houseBaseModel.getVideoUrl());
    	}
    	Assert.assertNotNull(houseBaseModel.getUnitPrice());
	}
    
  }
  
  
  @Test
  /**
   * 租房默认列表页
   */
  public void getHouseSummaryListByLevelResponse2() {
	  LOGGER.info("租房默认列表页");
	  List<HouseBaseModel> houseBaseModels = JSON.parseArray(CommonUtils.parseJson("rows", result2), HouseBaseModel.class);
	    int size = houseBaseModels.size();
	    for (int i = 0; i < size; i++) {
	    	HouseBaseModel houseBaseModel = houseBaseModels.get(i);
	    	Assert.assertNotNull(houseBaseModel.getHouseId());
	    	Assert.assertNotNull(houseBaseModel.getRentPrice());
	    	Assert.assertNotNull(houseBaseModel.getPicNum());
	    	Assert.assertNotNull(houseBaseModel.getPicUrls());
	    	Assert.assertNotNull(houseBaseModel.getBedroomSum());
	    	Assert.assertNotNull(houseBaseModel.getEstateName());
	    	Assert.assertNotNull(houseBaseModel.getAreaName());
	    	Assert.assertNotNull(houseBaseModel.getPubDate());
	    	Assert.assertNotNull(houseBaseModel.getFloorType());
	    	Assert.assertNotNull(houseBaseModel.getFloorType2());
	    	Assert.assertNotNull(houseBaseModel.getEnable());
	    	Assert.assertNotNull(houseBaseModel.getEstateId());
	    	Assert.assertNotNull(houseBaseModel.getSpaceArea());
	    	Assert.assertNotNull(houseBaseModel.getLon());
	    	Assert.assertNotNull(houseBaseModel.getLat());
	    	Assert.assertNotNull(houseBaseModel.getPlateName());
	    	Assert.assertNotNull(houseBaseModel.getHouseSpace());
	    	if (houseBaseModel.getRentOrBrand() == 1) {
	    		Assert.assertNotNull(houseBaseModel.getPublishDate());
		    	Assert.assertNotNull(houseBaseModel.getHdUrls());
			}
	    	if (houseBaseModel.getRentOrBrand() == 2) {
	    		Assert.assertNotNull(houseBaseModel.getHouseRoom());
	    		Assert.assertNotNull(houseBaseModel.getTag());
			}
	    }
  }
  
  @Test
  /**
   * 品牌公寓默认列表页
   */
  public void getHouseSummaryListByLevelResponse3() {
	  LOGGER.info("品牌公寓默认列表页");
	  List<HouseBaseModel> houseBaseModels = JSON.parseArray(CommonUtils.parseJson("rows", result3), HouseBaseModel.class);
	    int size = houseBaseModels.size();
	    for (int i = 0; i < size; i++) {
	    	HouseBaseModel houseBaseModel = houseBaseModels.get(i);
	    	Assert.assertNotNull(houseBaseModel.getHouseId());
	    	Assert.assertNotNull(houseBaseModel.getRentPrice());
	    	Assert.assertNotNull(houseBaseModel.getPicNum());
	    	Assert.assertNotNull(houseBaseModel.getPicUrls());
	    	Assert.assertNotNull(houseBaseModel.getBedroomSum());
	    	Assert.assertNotNull(houseBaseModel.getEstateName());
	    	Assert.assertNotNull(houseBaseModel.getAreaName());
	    	Assert.assertNotNull(houseBaseModel.getPubDate());
	    	Assert.assertNotNull(houseBaseModel.getFloorType());
	    	Assert.assertNotNull(houseBaseModel.getFloorType2());
	    	Assert.assertNotNull(houseBaseModel.getEnable());
	    	Assert.assertNotNull(houseBaseModel.getEstateId());
	    	Assert.assertNotNull(houseBaseModel.getSpaceArea());
	    	Assert.assertNotNull(houseBaseModel.getLon());
	    	Assert.assertNotNull(houseBaseModel.getLat());
	    	Assert.assertNotNull(houseBaseModel.getPlateName());
	    	Assert.assertNotNull(houseBaseModel.getHouseSpace());
	    	Assert.assertNotNull(houseBaseModel.getHouseRoom());
	    	Assert.assertNotNull(houseBaseModel.getTag());
	    }
  }
  
  
  /**
   * 二手房设置参数
   * @return
   */
  private static HouseMarkByLevelModel getHouseMarkByLevelModel1(){
	  String[] latlonArray = {"0.000000,0.000000","0.000000,0.000000","0.000000,0.000000","0.000000,0.000000"};
	  HouseMarkByLevelModel houseMarkByLevelModel = new HouseMarkByLevelModel();
	  houseMarkByLevelModel.setRentOrSale(1);
	  houseMarkByLevelModel.setLevel(13);
	  houseMarkByLevelModel.setSort(0);
	  houseMarkByLevelModel.setLon(121.4797);
	  houseMarkByLevelModel.setLat(31.23809);
	  houseMarkByLevelModel.setPageSize(20);
	  houseMarkByLevelModel.setOffset(0);
	  houseMarkByLevelModel.setLatlonArray(latlonArray);
	  return houseMarkByLevelModel;
  }
  /**
   * 租房品牌公寓混合设置参数
   * @return
   */
  private static HouseMarkByLevelModel getHouseMarkByLevelModel2(){
	  String[] latlonArray = {"31.589946,121.248854","31.589946,121.710466","30.886239,121.710466","30.886239,121.248854"};
	  HouseMarkByLevelModel houseMarkByLevelModel = new HouseMarkByLevelModel();
	  houseMarkByLevelModel.setRentOrSale(0);
	  houseMarkByLevelModel.setLevel(13);
	  houseMarkByLevelModel.setSort(0);
	  houseMarkByLevelModel.setLon(121.4797);
	  houseMarkByLevelModel.setLat(31.23809);
	  houseMarkByLevelModel.setPageSize(20);
	  houseMarkByLevelModel.setOffset(0);
	  houseMarkByLevelModel.setLatlonArray(latlonArray);
	  houseMarkByLevelModel.setSequence(0);
	  houseMarkByLevelModel.setRentOrBrand(0);
//	  houseMarkByLevelModel.setUserId(Long.parseLong(userId));
	  return houseMarkByLevelModel;
  }
  /**
   * 租房列表查询品牌公寓设置参数
   * @return
   */
  private static HouseMarkByLevelModel getHouseMarkByLevelModel3(){
	  String[] latlonArray = {"31.459788,121.334534","31.459788,121.624786","31.016397,121.624786","31.016397,121.334534"};
	  HouseMarkByLevelModel houseMarkByLevelModel = new HouseMarkByLevelModel();
	  houseMarkByLevelModel.setRentOrSale(0);
	  houseMarkByLevelModel.setLevel(13);
	  houseMarkByLevelModel.setSort(0);
	  houseMarkByLevelModel.setLon(121.4797);
	  houseMarkByLevelModel.setLat(31.23809);
	  houseMarkByLevelModel.setPageSize(20);
	  houseMarkByLevelModel.setOffset(0);
	  houseMarkByLevelModel.setLatlonArray(latlonArray);
	  houseMarkByLevelModel.setSequence(0);
	  houseMarkByLevelModel.setRentOrBrand(2);
	  return houseMarkByLevelModel;
  }
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---地图可视范围内的房源列表");
  }
}
