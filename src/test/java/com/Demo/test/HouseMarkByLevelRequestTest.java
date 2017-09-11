package com.Demo.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.AddLogWrap;
import com.Common.UserCommon;
import com.Demo.HouseMarkByLevelRequest;
import com.Model.HouseMarkByLevelModel;
import com.Model.MapMarkModel;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class HouseMarkByLevelRequestTest {
	public static final Logger LOGGER = Logger.getLogger(HouseMarkByLevelRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	@BeforeClass
	public void getPorperties() {
		LOGGER.info("根据地图层级获取打点数据--->>>");
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		}
  @Test
  /**
   * 租房
   */
  public void getHouseMarkByLevelResponse1() {
	  LOGGER.info("租房");
    String result = new HouseMarkByLevelRequest().getHouseMarkByLevelResponse(getHouseMarkByLevelModel(0), uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    LOGGER.info("markNewHouseList="+CommonUtils.parseJson("markNewHouseList", result)+"");
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    LOGGER.info("mapTitle="+CommonUtils.parseJson("mapTitle", result)+"");
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
    	LOGGER.error("获取地图层级数据失败");
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			LOGGER.info("mapMarkModel.getAreaId()="+mapMarkModel.getAreaId()+"");
			Assert.assertNotNull(mapMarkModel.getAreaId());
			LOGGER.info("mapMarkModel.getAreaName()="+mapMarkModel.getAreaName()+"");
			Assert.assertNotNull(mapMarkModel.getAreaName());
			LOGGER.info("mapMarkModel.getLat()="+mapMarkModel.getLat()+"");
			Assert.assertNotNull(mapMarkModel.getLat());
			LOGGER.info("mapMarkModel.getLon()="+mapMarkModel.getLon()+"");
			Assert.assertNotNull(mapMarkModel.getLon());
			LOGGER.info("mapMarkModel.getGrade()="+mapMarkModel.getGrade()+"");
			Assert.assertNotNull(mapMarkModel.getGrade());
			LOGGER.info("mapMarkModel.getStationId()="+mapMarkModel.getStationId()+"");
			Assert.assertNotNull(mapMarkModel.getStationId());
			LOGGER.info("mapMarkModel.getHouseNum()="+mapMarkModel.getHouseNum()+"");
			Assert.assertNotNull(mapMarkModel.getHouseNum());
		}
	}
  }
  @Test
  /**
   * 二手房 
   */
  public void getHouseMarkByLevelResponse2() {
	  LOGGER.info("二手房 ");
    String result = new HouseMarkByLevelRequest().getHouseMarkByLevelResponse(getHouseMarkByLevelModel(1), uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    LOGGER.info("markNewHouseList="+CommonUtils.parseJson("markNewHouseList", result)+"");
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    LOGGER.info("mapTitle="+CommonUtils.parseJson("mapTitle", result)+"");
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
    	LOGGER.error("获取地图层级数据失败");
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			LOGGER.info("mapMarkModel.getAreaId()="+mapMarkModel.getAreaId()+"");
			Assert.assertNotNull(mapMarkModel.getAreaId());
			LOGGER.info("mapMarkModel.getAreaName()="+mapMarkModel.getAreaName()+"");
			Assert.assertNotNull(mapMarkModel.getAreaName());
			LOGGER.info("mapMarkModel.getLat()="+mapMarkModel.getLat()+"");
			Assert.assertNotNull(mapMarkModel.getLat());
			LOGGER.info("mapMarkModel.getLon()="+mapMarkModel.getLon()+"");
			Assert.assertNotNull(mapMarkModel.getLon());
			LOGGER.info("mapMarkModel.getGrade()="+mapMarkModel.getGrade()+"");
			Assert.assertNotNull(mapMarkModel.getGrade());
			LOGGER.info("mapMarkModel.getStationId()="+mapMarkModel.getStationId()+"");
			Assert.assertNotNull(mapMarkModel.getStationId());
			LOGGER.info("mapMarkModel.getHouseNum()="+mapMarkModel.getHouseNum()+"");
			Assert.assertNotNull(mapMarkModel.getHouseNum());
		}
	}
  }
  @Test
  /**
   *  品牌公寓
   */
  public void getHouseMarkByLevelResponse3() {
	  LOGGER.info("品牌公寓 ");
    String result = new HouseMarkByLevelRequest().getHouseMarkByLevelResponse(getHouseMarkByLevelModel(3), uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    LOGGER.info("markNewHouseList="+CommonUtils.parseJson("markNewHouseList", result)+"");
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    LOGGER.info("mapTitle="+CommonUtils.parseJson("mapTitle", result)+"");
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
    	LOGGER.error("获取地图层级数据失败");
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			LOGGER.info("mapMarkModel.getAreaId()="+mapMarkModel.getAreaId()+"");
			Assert.assertNotNull(mapMarkModel.getAreaId());
			LOGGER.info("mapMarkModel.getAreaName()="+mapMarkModel.getAreaName()+"");
			Assert.assertNotNull(mapMarkModel.getAreaName());
			LOGGER.info("mapMarkModel.getLat()="+mapMarkModel.getLat()+"");
			Assert.assertNotNull(mapMarkModel.getLat());
			LOGGER.info("mapMarkModel.getLon()="+mapMarkModel.getLon()+"");
			Assert.assertNotNull(mapMarkModel.getLon());
			LOGGER.info("mapMarkModel.getGrade()="+mapMarkModel.getGrade()+"");
			Assert.assertNotNull(mapMarkModel.getGrade());
			LOGGER.info("mapMarkModel.getStationId()="+mapMarkModel.getStationId()+"");
			Assert.assertNotNull(mapMarkModel.getStationId());
			LOGGER.info("mapMarkModel.getHouseNum()="+mapMarkModel.getHouseNum()+"");
			Assert.assertNotNull(mapMarkModel.getHouseNum());
		}
	}
  }
  @Test
  /**
   *  二手房地图页宝山区域层级
   */
  public void getHouseMarkByLevelResponse4() {
	  LOGGER.info("二手房地图页宝山区域层级");
	  String[] latlonArray = {"31.373118,121.372355","31.373118,121.444921","31.262368,121.444921","31.262368,121.372355"};
	  LOGGER.info("坐标为："+latlonArray+"");
	  HouseMarkByLevelModel houseMarkByLevelModel = new HouseMarkByLevelModel();
	  houseMarkByLevelModel.setCity("2");
	  houseMarkByLevelModel.setRentOrSale(1);
	  houseMarkByLevelModel.setLatlonArray(latlonArray);
	  houseMarkByLevelModel.setLevel(15);
	  houseMarkByLevelModel.setFlag(1);
	  houseMarkByLevelModel.setLon(121.479660);
	  houseMarkByLevelModel.setLat(31.238092);
	  houseMarkByLevelModel.setStationId(0);
    String result = new HouseMarkByLevelRequest().getHouseMarkByLevelResponse(houseMarkByLevelModel, uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    LOGGER.info("markNewHouseList="+CommonUtils.parseJson("markNewHouseList", result)+"");
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    LOGGER.info("mapTitle="+CommonUtils.parseJson("mapTitle", result)+"");
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
    	LOGGER.error("获取地图层级数据失败");
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			LOGGER.info("mapMarkModel.getAreaId()="+mapMarkModel.getAreaId()+"");
			Assert.assertNotNull(mapMarkModel.getAreaId());
			LOGGER.info("mapMarkModel.getAreaName()="+mapMarkModel.getAreaName()+"");
			Assert.assertNotNull(mapMarkModel.getAreaName());
			LOGGER.info("mapMarkModel.getLat()="+mapMarkModel.getLat()+"");
			Assert.assertNotNull(mapMarkModel.getLat());
			LOGGER.info("mapMarkModel.getLon()="+mapMarkModel.getLon()+"");
			Assert.assertNotNull(mapMarkModel.getLon());
			LOGGER.info("mapMarkModel.getGrade()="+mapMarkModel.getGrade()+"");
			Assert.assertNotNull(mapMarkModel.getGrade());
			LOGGER.info("mapMarkModel.getStationId()="+mapMarkModel.getStationId()+"");
			Assert.assertNotNull(mapMarkModel.getStationId());
			LOGGER.info("mapMarkModel.getHouseNum()="+mapMarkModel.getHouseNum()+"");
			Assert.assertNotNull(mapMarkModel.getHouseNum());
		}
	}
    
  }
  
  @Test
  /**
   *  租房地图页长寿路板块层级
   */
  public void getHouseMarkByLevelResponse5() {
	  LOGGER.info("租房地图页长寿路板块层级");
	  String[] latlonArray = {"31.255790,121.441360","31.255790,121.450424","31.241936,121.450424","31.241936,121.441360"};
	  LOGGER.info("坐标为："+latlonArray+"");
	  HouseMarkByLevelModel houseMarkByLevelModel = new HouseMarkByLevelModel();
	  houseMarkByLevelModel.setCity("2");
	  houseMarkByLevelModel.setRentOrSale(0);
	  houseMarkByLevelModel.setLatlonArray(latlonArray);
	  houseMarkByLevelModel.setLevel(18);
	  houseMarkByLevelModel.setFlag(1);
	  houseMarkByLevelModel.setLon(121.445892);
	  houseMarkByLevelModel.setLat(31.248863);
	  houseMarkByLevelModel.setStationId(0);
    String result = new HouseMarkByLevelRequest().getHouseMarkByLevelResponse(houseMarkByLevelModel, uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    LOGGER.info("markNewHouseList="+CommonUtils.parseJson("markNewHouseList", result)+"");
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    LOGGER.info("mapTitle="+CommonUtils.parseJson("mapTitle", result)+"");
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
    	LOGGER.error("获取地图层级数据失败");
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			 LOGGER.info("mapMarkModel.getAreaId()="+mapMarkModel.getAreaId()+"");
			Assert.assertNotNull(mapMarkModel.getAreaId());
			LOGGER.info("mapMarkModel.getAreaName()="+mapMarkModel.getAreaName()+"");
			Assert.assertNotNull(mapMarkModel.getAreaName());
			LOGGER.info("mapMarkModel.getLat()="+mapMarkModel.getLat()+"");
			Assert.assertNotNull(mapMarkModel.getLat());
			LOGGER.info("mapMarkModel.getLon()="+mapMarkModel.getLon()+"");
			Assert.assertNotNull(mapMarkModel.getLon());
			LOGGER.info("mapMarkModel.getGrade()="+mapMarkModel.getGrade()+"");
			Assert.assertNotNull(mapMarkModel.getGrade());
			LOGGER.info("mapMarkModel.getStationId()="+mapMarkModel.getStationId()+"");
			Assert.assertNotNull(mapMarkModel.getStationId());
			LOGGER.info("mapMarkModel.getHouseNum()="+mapMarkModel.getHouseNum()+"");
			Assert.assertNotNull(mapMarkModel.getHouseNum());
		}
	}
    
  }
  
  
  @Test
  /**
   *  租房地图页长寿路板块层级
   */
  public void getHouseMarkByLevelResponse6() {
	  LOGGER.info("租房地图页长寿路板块层级");
	  String[] latlonArray = {"31.255790,121.441360","31.255790,121.450424","31.241936,121.450424","31.241936,121.441360"};
	  LOGGER.info("坐标为："+latlonArray+"");
	  HouseMarkByLevelModel houseMarkByLevelModel = new HouseMarkByLevelModel();
	  houseMarkByLevelModel.setCity("2");
	  houseMarkByLevelModel.setRentOrSale(0);
	  houseMarkByLevelModel.setLatlonArray(latlonArray);
	  houseMarkByLevelModel.setLevel(18);
	  houseMarkByLevelModel.setFlag(1);
	  houseMarkByLevelModel.setLon(121.445892);
	  houseMarkByLevelModel.setLat(31.248863);
	  houseMarkByLevelModel.setStationId(0);
    String result = new HouseMarkByLevelRequest().getHouseMarkByLevelResponse(houseMarkByLevelModel, uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    LOGGER.info("markNewHouseList="+CommonUtils.parseJson("markNewHouseList", result)+"");
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    LOGGER.info("mapTitle="+CommonUtils.parseJson("mapTitle", result)+"");
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
    	LOGGER.error("获取地图层级数据失败");
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			 LOGGER.info("mapMarkModel.getAreaId()="+mapMarkModel.getAreaId()+"");
			Assert.assertNotNull(mapMarkModel.getAreaId());
			LOGGER.info("mapMarkModel.getAreaName()="+mapMarkModel.getAreaName()+"");
			Assert.assertNotNull(mapMarkModel.getAreaName());
			LOGGER.info("mapMarkModel.getLat()="+mapMarkModel.getLat()+"");
			Assert.assertNotNull(mapMarkModel.getLat());
			LOGGER.info("mapMarkModel.getLon()="+mapMarkModel.getLon()+"");
			Assert.assertNotNull(mapMarkModel.getLon());
			LOGGER.info("mapMarkModel.getGrade()="+mapMarkModel.getGrade()+"");
			Assert.assertNotNull(mapMarkModel.getGrade());
			LOGGER.info("mapMarkModel.getStationId()="+mapMarkModel.getStationId()+"");
			Assert.assertNotNull(mapMarkModel.getStationId());
			LOGGER.info("mapMarkModel.getHouseNum()="+mapMarkModel.getHouseNum()+"");
			Assert.assertNotNull(mapMarkModel.getHouseNum());
		}
	}
    
  }
  /**
   * 设置参数
   * @param rentOrSale    租售类型：0-租房；1-二手房  2新房  3品牌公寓
   * @return
   */
  private static HouseMarkByLevelModel getHouseMarkByLevelModel(int rentOrSale){
	  String[] latlonArray = {"31.459788,121.334534","31.459788,121.624786","31.016397,121.624786","31.016397,121.334534"};
	  HouseMarkByLevelModel houseMarkByLevelModel = new HouseMarkByLevelModel();
	  houseMarkByLevelModel.setCity("2");
	  houseMarkByLevelModel.setRentOrSale(rentOrSale);
	  houseMarkByLevelModel.setLatlonArray(latlonArray);
	  houseMarkByLevelModel.setLevel(13);
	  houseMarkByLevelModel.setFlag(0);
	  houseMarkByLevelModel.setLon(121.479660);
	  houseMarkByLevelModel.setLat(31.238092);
	  houseMarkByLevelModel.setStationId(0);
	  return houseMarkByLevelModel;
  }
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---根据地图层级获取打点数据");
	  new AddLogWrap();
  }
}
