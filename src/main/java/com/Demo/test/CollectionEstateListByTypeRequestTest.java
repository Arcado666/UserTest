package com.Demo.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.CollectionEstateListByTypeRequest;
import com.Model.CollectionEstate;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class CollectionEstateListByTypeRequestTest {
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	String result;
	@BeforeClass
	public void getPorperties() {
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		result = new CollectionEstateListByTypeRequest().getCollectionEstateListByTypeResponse("1000", uticket, "0", "-1");
		}
  @Test
  public void getCollectionEstateListByTypeResponse1() {
    int size = JSON.parseObject(result).getInteger("total");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    Assert.assertTrue(size == estateLists.size());
  }
  @Test
  public void getCollectionEstateListByTypeResponse2() {
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	Assert.assertNotNull(collectionEstate.getArea());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse3() {
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	Assert.assertNotNull(collectionEstate.getAvgPrice());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse4() {
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	Assert.assertNotNull(collectionEstate.getCollId());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse5() {
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	Assert.assertNotNull(collectionEstate.getEffectiveHouseNum());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse6() {
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	Assert.assertNotNull(collectionEstate.getEstateId());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse7() {
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	Assert.assertNotNull(collectionEstate.getEstateImg());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse8() {
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	Assert.assertNotNull(collectionEstate.getEstateName());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse9() {
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	Assert.assertNotNull(collectionEstate.getRentOrSale());
	}
  }
  @Test
  public void getCollectionEstateListByTypeResponse10() {
    String estateList = CommonUtils.parseJson("estateList", result);
    List<CollectionEstate> estateLists = JSON.parseArray(estateList,CollectionEstate.class);
    for (int i = 0; i < estateLists.size(); i++) {
    	CollectionEstate collectionEstate = estateLists.get(i);
    	Assert.assertNotNull(collectionEstate.getType());
	}
  }
}
