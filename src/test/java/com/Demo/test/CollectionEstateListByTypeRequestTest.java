package com.Demo.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.CollectionEstateListByTypeRequest;
import com.Model.CollectionEstate;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class CollectionEstateListByTypeRequestTest {
	public static final Logger LOGGER = Logger.getLogger(CollectionEstateListByTypeRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	String result;
	@BeforeClass
	public void getPorperties() {
		LOGGER.info("根据类型获取关注的小区列表（租房、二手房）--->>>");
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		result = new CollectionEstateListByTypeRequest().getCollectionEstateListByTypeResponse("1000", uticket, "0", "-1");
		if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
	    	LOGGER.error(result);
			throw new RuntimeException(result);
		}
	    LOGGER.info("result="+result+"");
		}
  @Test
  public void getCollectionEstateListByTypeResponse1() {
	  LOGGER.info("验证estateList--->size");
    int size = JSON.parseObject(result).getInteger("total");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    LOGGER.info("estateLists.size()="+estateLists.size()+"");
    Assert.assertTrue(size == estateLists.size());
  }
  @Test
  public void getCollectionEstateListByTypeResponse2() {
	  LOGGER.info("验证estateList--->Area");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	LOGGER.info("collectionEstate.getArea()="+collectionEstate.getArea()+"");
    	Assert.assertNotNull(collectionEstate.getArea());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse3() {
	  LOGGER.info("验证estateList--->AvgPrice");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	LOGGER.info("collectionEstate.getAvgPrice()="+collectionEstate.getAvgPrice()+"");
    	Assert.assertNotNull(collectionEstate.getAvgPrice());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse4() {
	  LOGGER.info("验证estateList--->CollId");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	LOGGER.info("collectionEstate.getCollId()="+collectionEstate.getCollId()+"");
    	Assert.assertNotNull(collectionEstate.getCollId());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse5() {
	  LOGGER.info("验证estateList--->EffectiveHouseNum");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	LOGGER.info("collectionEstate.getEffectiveHouseNum()="+collectionEstate.getEffectiveHouseNum()+"");
    	Assert.assertNotNull(collectionEstate.getEffectiveHouseNum());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse6() {
	  LOGGER.info("验证estateList--->EstateId");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	LOGGER.info("collectionEstate.getEstateId()="+collectionEstate.getEstateId()+"");
    	Assert.assertNotNull(collectionEstate.getEstateId());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse7() {
	  LOGGER.info("验证estateList--->EstateImg");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	LOGGER.info("collectionEstate.getEstateImg()="+collectionEstate.getEstateImg()+"");
    	Assert.assertNotNull(collectionEstate.getEstateImg());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse8() {
	  LOGGER.info("验证estateList--->EstateName");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	LOGGER.info("collectionEstate.getEstateName()="+collectionEstate.getEstateName()+"");
    	Assert.assertNotNull(collectionEstate.getEstateName());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse9() {
	  LOGGER.info("验证estateList--->RentOrSale");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	LOGGER.info("collectionEstate.getRentOrSale()="+collectionEstate.getRentOrSale()+"");
    	Assert.assertNotNull(collectionEstate.getRentOrSale());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse10() {
	  LOGGER.info("验证estateList--->Type");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	LOGGER.info("collectionEstate.getType()="+collectionEstate.getType()+"");
    	Assert.assertNotNull(collectionEstate.getType());
	}
  }
  
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---根据类型获取关注的小区列表（租房、二手房）");
  }
}
