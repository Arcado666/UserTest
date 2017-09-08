package com.Demo.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.CollectionNewHouseListRequest;
import com.Model.LayoutModel;
import com.Model.NewHouseList;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class CollectionNewHouseListRequestTest {
	public static final Logger LOGGER = Logger.getLogger(CollectionNewHouseListRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	String result;
	@BeforeClass
	public void getPorperties() {
		LOGGER.info("新房关注列表--->>>");
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		result = new CollectionNewHouseListRequest().getCollectionNewHouseListResponse(uticket, "100", "0");
		if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
	    	LOGGER.error(result);
			throw new RuntimeException(result);
		}
	    LOGGER.info("result="+result+"");
		}
  @Test
  public void getCollectionNewHouseListResponse1() {
	  LOGGER.info("验证estateList");
    String estateList = CommonUtils.parseJson("estateList", result);
    List<NewHouseList> estateLists = JSON.parseArray(estateList, NewHouseList.class);
    for (int i = 0; i < estateLists.size(); i++) {
		NewHouseList newHouseList = estateLists.get(i);
		LOGGER.info("newHouseList.getNewHouseId()="+newHouseList.getNewHouseId()+"");
		Assert.assertNotNull(newHouseList.getNewHouseId());
		LOGGER.info("newHouseList.getImageUrl()="+newHouseList.getImageUrl()+"");
		Assert.assertNotNull(newHouseList.getImageUrl());
		LOGGER.info("newHouseList.getName()="+newHouseList.getName()+"");
		Assert.assertNotNull(newHouseList.getName());
		LOGGER.info("newHouseList.getDistrictId()="+newHouseList.getDistrictId()+"");
		Assert.assertNotNull(newHouseList.getDistrictId());
		LOGGER.info("newHouseList.getDistrictName()="+newHouseList.getDistrictName()+"");
		Assert.assertNotNull(newHouseList.getDistrictName());
		LOGGER.info("newHouseList.getTownId()="+newHouseList.getTownId()+"");
		Assert.assertNotNull(newHouseList.getTownId());
		LOGGER.info("newHouseList.getTownName()="+newHouseList.getTownName()+"");
		Assert.assertNotNull(newHouseList.getTownName());
		LOGGER.info("newHouseList.getBedRoom()="+newHouseList.getBedRoom()+"");
		Assert.assertNotNull(newHouseList.getBedRoom());
		LOGGER.info("newHouseList.getDefaultPrice()="+newHouseList.getDefaultPrice()+"");
		Assert.assertNotNull(newHouseList.getDefaultPrice());
		LOGGER.info("newHouseList.getPriceFlag()="+newHouseList.getPriceFlag()+"");
		Assert.assertNotNull(newHouseList.getPriceFlag());
		LOGGER.info("newHouseList.getPropertyType()="+newHouseList.getPropertyType()+"");
		Assert.assertNotNull(newHouseList.getPropertyType());
		LOGGER.info("newHouseList.getVideoType()="+newHouseList.getVideoType()+"");
		Assert.assertNotNull(newHouseList.getVideoType());
		LOGGER.info("newHouseList.getEnable()="+newHouseList.getEnable()+"");
		Assert.assertNotNull(newHouseList.getEnable());
		LOGGER.info("newHouseList.getConcessions()="+newHouseList.getConcessions()+"");
		Assert.assertNotNull(newHouseList.getConcessions());
		LOGGER.info("newHouseList.getConcessionsList()="+newHouseList.getConcessionsList()+"");
		Assert.assertNotNull(newHouseList.getConcessionsList());
		LOGGER.info("newHouseList.getMaidian()="+newHouseList.getMaidian()+"");
		Assert.assertNotNull(newHouseList.getMaidian());
	}
  }
  @Test
  public void getCollectionNewHouseListResponse() {
	  LOGGER.info("验证layoutModel");
	    String estateList = CommonUtils.parseJson("estateList", result);
	    List<NewHouseList> estateLists = JSON.parseArray(estateList, NewHouseList.class);
	    if(estateLists.size()!=0){
	    	for (int i = 0; i < estateLists.size(); i++) {
	    	NewHouseList newHouseList = estateLists.get(i);
	    	if (newHouseList.getLayoutModelList()!= null&&!newHouseList.getLayoutModelList().isEmpty()) {
				List<LayoutModel> layoutModels = JSON.parseArray(JSON.toJSONString(newHouseList.getLayoutModelList()), LayoutModel.class);
				for (int j = 0; j < layoutModels.size(); j++) {
					LayoutModel layoutModel = layoutModels.get(j);
					LOGGER.info("layoutModel.getImageUrl()="+layoutModel.getImageUrl()+"");
					Assert.assertNotNull(layoutModel.getImageUrl());
					LOGGER.info("layoutModel.getSmallImageUrl()="+layoutModel.getSmallImageUrl()+"");
					Assert.assertNotNull(layoutModel.getSmallImageUrl());
					LOGGER.info("layoutModel.getName()="+layoutModel.getName()+"");
					Assert.assertNotNull(layoutModel.getName());
					LOGGER.info("layoutModel.getPriceUnit()="+layoutModel.getPriceUnit()+"");
					Assert.assertNotNull(layoutModel.getPriceUnit());
					LOGGER.info("layoutModel.getId()="+layoutModel.getId()+"");
					Assert.assertNotNull(layoutModel.getId());
					LOGGER.info("layoutModel.getVideoType()="+layoutModel.getVideoType()+"");
					Assert.assertNotNull(layoutModel.getVideoType());
					LOGGER.info("layoutModel.getSpaceArea()="+layoutModel.getSpaceArea()+"");
					Assert.assertNotNull(layoutModel.getSpaceArea());
					LOGGER.info("layoutModel.getTotalPrice()="+layoutModel.getTotalPrice()+"");
					Assert.assertNotNull(layoutModel.getTotalPrice());
					LOGGER.info("layoutModel.getPropertyId()="+layoutModel.getPropertyId()+"");
					Assert.assertNotNull(layoutModel.getPropertyId());
					LOGGER.info("layoutModel.getAreaUnit()="+layoutModel.getAreaUnit()+"");
					Assert.assertNotNull(layoutModel.getAreaUnit());
					LOGGER.info("layoutModel.getStatus()="+layoutModel.getStatus()+"");
					Assert.assertNotNull(layoutModel.getStatus());
				}
			}
	    	}
	    }
	    }
  
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---新房关注列表");
  }
}
