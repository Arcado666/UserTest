package com.Demo.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.HouseMarkByLevelRequest;
import com.Model.HouseMarkByLevelModel;
import com.Model.MapMarkModel;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.FormJSON;
import com.qiang.utils.UseProperties;

public class HouseMarkByLevelRequestTest {
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
  /**
   * 租房
   */
  public void getHouseMarkByLevelResponse1() {
    String result = new HouseMarkByLevelRequest().getHouseMarkByLevelResponse(getHouseMarkByLevelModel(0), uticket);
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			Assert.assertNotNull(mapMarkModel.getAreaId());
			Assert.assertNotNull(mapMarkModel.getAreaName());
			Assert.assertNotNull(mapMarkModel.getLat());
			Assert.assertNotNull(mapMarkModel.getLon());
			Assert.assertNotNull(mapMarkModel.getGrade());
			Assert.assertNotNull(mapMarkModel.getStationId());
			Assert.assertNotNull(mapMarkModel.getHouseNum());
		}
	}
  }
  @Test
  /**
   * 二手房 
   */
  public void getHouseMarkByLevelResponse2() {
    String result = new HouseMarkByLevelRequest().getHouseMarkByLevelResponse(getHouseMarkByLevelModel(1), uticket);
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			Assert.assertNotNull(mapMarkModel.getAreaId());
			Assert.assertNotNull(mapMarkModel.getAreaName());
			Assert.assertNotNull(mapMarkModel.getLat());
			Assert.assertNotNull(mapMarkModel.getLon());
			Assert.assertNotNull(mapMarkModel.getGrade());
			Assert.assertNotNull(mapMarkModel.getStationId());
			Assert.assertNotNull(mapMarkModel.getHouseNum());
		}
	}
  }
  @Test
  /**
   *  品牌公寓
   */
  public void getHouseMarkByLevelResponse3() {
    String result = new HouseMarkByLevelRequest().getHouseMarkByLevelResponse(getHouseMarkByLevelModel(3), uticket);
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			Assert.assertNotNull(mapMarkModel.getAreaId());
			Assert.assertNotNull(mapMarkModel.getAreaName());
			Assert.assertNotNull(mapMarkModel.getLat());
			Assert.assertNotNull(mapMarkModel.getLon());
			Assert.assertNotNull(mapMarkModel.getGrade());
			Assert.assertNotNull(mapMarkModel.getStationId());
			Assert.assertNotNull(mapMarkModel.getHouseNum());
		}
	}
  }
  @Test
  /**
   *  二手房地图页宝山区域层级
   */
  public void getHouseMarkByLevelResponse4() {
	  String[] latlonArray = {"31.373118,121.372355","31.373118,121.444921","31.262368,121.444921","31.262368,121.372355"};
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
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			Assert.assertNotNull(mapMarkModel.getAreaId());
			Assert.assertNotNull(mapMarkModel.getAreaName());
			Assert.assertNotNull(mapMarkModel.getLat());
			Assert.assertNotNull(mapMarkModel.getLon());
			Assert.assertNotNull(mapMarkModel.getGrade());
			Assert.assertNotNull(mapMarkModel.getStationId());
			Assert.assertNotNull(mapMarkModel.getHouseNum());
		}
	}
    
  }
  
  @Test
  /**
   *  租房地图页长寿路板块层级
   */
  public void getHouseMarkByLevelResponse5() {
	  String[] latlonArray = {"31.255790,121.441360","31.255790,121.450424","31.241936,121.450424","31.241936,121.441360"};
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
    System.err.println(FormJSON.format(result));
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			Assert.assertNotNull(mapMarkModel.getAreaId());
			Assert.assertNotNull(mapMarkModel.getAreaName());
			Assert.assertNotNull(mapMarkModel.getLat());
			Assert.assertNotNull(mapMarkModel.getLon());
			Assert.assertNotNull(mapMarkModel.getGrade());
			Assert.assertNotNull(mapMarkModel.getStationId());
			Assert.assertNotNull(mapMarkModel.getHouseNum());
		}
	}
    
  }
  
  
  @Test
  /**
   *  租房地图页长寿路板块层级
   */
  public void getHouseMarkByLevelResponse6() {
	  String[] latlonArray = {"31.255790,121.441360","31.255790,121.450424","31.241936,121.450424","31.241936,121.441360"};
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
    System.err.println(FormJSON.format(result));
    Assert.assertNull(CommonUtils.parseJson("markNewHouseList", result));
    Assert.assertNotNull(CommonUtils.parseJson("mapTitle", result));
    List<MapMarkModel> mapMarkModels = JSON.parseArray(CommonUtils.parseJson("markList", result), MapMarkModel.class);
    if (mapMarkModels.isEmpty()) {
		throw new RuntimeException("获取地图层级数据失败");
	}else{
		int size = mapMarkModels.size();
		for (int i = 0; i < size; i++) {
			MapMarkModel mapMarkModel = mapMarkModels.get(i);
			Assert.assertNotNull(mapMarkModel.getAreaId());
			Assert.assertNotNull(mapMarkModel.getAreaName());
			Assert.assertNotNull(mapMarkModel.getLat());
			Assert.assertNotNull(mapMarkModel.getLon());
			Assert.assertNotNull(mapMarkModel.getGrade());
			Assert.assertNotNull(mapMarkModel.getStationId());
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
}
