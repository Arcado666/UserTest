package com.Demo.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.CollectionNewHouseListRequest;
import com.Model.LayoutModel;
import com.Model.NewHouseList;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.FormJSON;
import com.qiang.utils.UseProperties;

public class CollectionNewHouseListRequestTest {
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
		result = new CollectionNewHouseListRequest().getCollectionNewHouseListResponse(uticket, "100", "0");
		System.err.println(FormJSON.format(result));
		}
  @Test
  public void getCollectionNewHouseListResponse1() {
    String estateList = CommonUtils.parseJson("estateList", result);
    List<NewHouseList> estateLists = JSON.parseArray(estateList, NewHouseList.class);
    for (int i = 0; i < estateLists.size(); i++) {
		NewHouseList newHouseList = estateLists.get(i);
		Assert.assertNotNull(newHouseList.getNewHouseId());
		Assert.assertNotNull(newHouseList.getImageUrl());
		Assert.assertNotNull(newHouseList.getName());
		Assert.assertNotNull(newHouseList.getDistrictId());
		Assert.assertNotNull(newHouseList.getDistrictName());
		Assert.assertNotNull(newHouseList.getTownId());
		Assert.assertNotNull(newHouseList.getTownName());
		Assert.assertNotNull(newHouseList.getBedRoom());
		Assert.assertNotNull(newHouseList.getDefaultPrice());
		Assert.assertNotNull(newHouseList.getPriceFlag());
		Assert.assertNotNull(newHouseList.getPropertyType());
		Assert.assertNotNull(newHouseList.getVideoType());
		Assert.assertNotNull(newHouseList.getEnable());
		Assert.assertNotNull(newHouseList.getConcessions());
		Assert.assertNotNull(newHouseList.getConcessionsList());
		Assert.assertNotNull(newHouseList.getMaidian());
	}
  }
  @Test
  public void getCollectionNewHouseListResponse() {
	    String estateList = CommonUtils.parseJson("estateList", result);
	    List<NewHouseList> estateLists = JSON.parseArray(estateList, NewHouseList.class);
	    if(estateLists.size()!=0){
	    	for (int i = 0; i < estateLists.size(); i++) {
	    	NewHouseList newHouseList = estateLists.get(i);
	    	if (!newHouseList.getLayoutModelList().isEmpty()) {
				List<LayoutModel> layoutModels = JSON.parseArray(JSON.toJSONString(newHouseList.getLayoutModelList()), LayoutModel.class);
				for (int j = 0; j < layoutModels.size(); j++) {
					LayoutModel layoutModel = layoutModels.get(j);
					Assert.assertNotNull(layoutModel.getImageUrl());
					Assert.assertNotNull(layoutModel.getSmallImageUrl());
					Assert.assertNotNull(layoutModel.getName());
					Assert.assertNotNull(layoutModel.getPriceUnit());
					Assert.assertNotNull(layoutModel.getId());
					Assert.assertNotNull(layoutModel.getVideoType());
					Assert.assertNotNull(layoutModel.getSpaceArea());
					Assert.assertNotNull(layoutModel.getTotalPrice());
					Assert.assertNotNull(layoutModel.getPropertyId());
					Assert.assertNotNull(layoutModel.getAreaUnit());
					Assert.assertNotNull(layoutModel.getStatus());
				}
			}
	    	}
	    }
	    }
}
