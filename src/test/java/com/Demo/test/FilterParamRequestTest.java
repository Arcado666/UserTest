package com.Demo.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Demo.FilterParamRequest;
import com.Model.RegionProperties;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.FormJSON;

public class FilterParamRequestTest {
	 public List<RegionProperties> priceRegion; // 价格区间
	 public List<RegionProperties> spaceRegion; // 面积区间
	 public List<RegionProperties> estateRegion; // 小区均价区间
	 @BeforeClass
	 public void BeforeClass(){
		 String result = new FilterParamRequest().getFilterParamResponse("上海");
		    priceRegion = JSON.parseArray(CommonUtils.parseJson("priceRegion", result), RegionProperties.class);
		    spaceRegion = JSON.parseArray(CommonUtils.parseJson("spaceRegion", result), RegionProperties.class);
		    estateRegion = JSON.parseArray(CommonUtils.parseJson("estateRegion", result), RegionProperties.class);
	 }
  @Test
  public void getFilterParamResponse1() {
    String result = new FilterParamRequest().getFilterParamResponse("北京");
    Assert.assertEquals(CommonUtils.parseJson("cityId", result), "12438");
  }
  @Test
  public void getFilterParamResponse2() {
    String result = new FilterParamRequest().getFilterParamResponse("2");
    Assert.assertEquals(CommonUtils.parseJson("cityId", result), "2");
  }
  @Test
  public void getFilterParamResponse3() {
    String result = new FilterParamRequest().getFilterParamResponse("上海");
    System.err.println(FormJSON.format(result));
    Assert.assertEquals(CommonUtils.parseJson("cityId", result), "2");
  }
  @Test
  public void getFilterParamResponse4() {
    int size = priceRegion.size();
    for (int i = 0; i < size; i++) {
		RegionProperties regionProperties = priceRegion.get(i);
		if (regionProperties.getTitle().equals("不限")) {
			Assert.assertTrue(regionProperties.getHighValue().equals("0"));
			Assert.assertTrue(regionProperties.getLowValue().equals("0"));
		}
		if (regionProperties.getTitle().equals("100万以下")) {
			Assert.assertTrue(regionProperties.getHighValue().equals("100"));
			Assert.assertTrue(regionProperties.getLowValue().equals("0"));
		}
		if (regionProperties.getTitle().equals("100-150万")) {
			Assert.assertTrue(regionProperties.getHighValue().equals("150"));
			Assert.assertTrue(regionProperties.getLowValue().equals("100"));
		}
		if (regionProperties.getTitle().equals("150-200万")) {
			Assert.assertTrue(regionProperties.getHighValue().equals("200"));
			Assert.assertTrue(regionProperties.getLowValue().equals("150"));
		}
		if (regionProperties.getTitle().equals("200-300万")) {
			Assert.assertTrue(regionProperties.getHighValue().equals("300"));
			Assert.assertTrue(regionProperties.getLowValue().equals("200"));
		}
		if (regionProperties.getTitle().equals("300-500万")) {
			Assert.assertTrue(regionProperties.getHighValue().equals("500"));
			Assert.assertTrue(regionProperties.getLowValue().equals("300"));
		}
		if (regionProperties.getTitle().equals("500-700万")) {
			Assert.assertTrue(regionProperties.getHighValue().equals("700"));
			Assert.assertTrue(regionProperties.getLowValue().equals("500"));
		}
		if (regionProperties.getTitle().equals("700-1000万")) {
			Assert.assertTrue(regionProperties.getHighValue().equals("1000"));
			Assert.assertTrue(regionProperties.getLowValue().equals("700"));
		}
		if (regionProperties.getTitle().equals("1000万以上")) {
			Assert.assertTrue(regionProperties.getHighValue().equals("0"));
			Assert.assertTrue(regionProperties.getLowValue().equals("1000"));
		}
	}
    
  }
  @Test
  public void getFilterParamResponse5() {
	  int size = spaceRegion.size();
	  for (int i = 0; i < size; i++) {
		  RegionProperties regionProperties = spaceRegion.get(i);
			if (regionProperties.getTitle().equals("不限")) {
				Assert.assertTrue(regionProperties.getLowValue().equals(""));
				Assert.assertTrue(regionProperties.getHighValue().equals(""));
			}
			if (regionProperties.getTitle().equals("50平米以下")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("0"));
				Assert.assertTrue(regionProperties.getHighValue().equals("50"));
			}
			if (regionProperties.getTitle().equals("50-70平米")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("50"));
				Assert.assertTrue(regionProperties.getHighValue().equals("70"));
			}
			if (regionProperties.getTitle().equals("70-90平米")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("70"));
				Assert.assertTrue(regionProperties.getHighValue().equals("90"));
			}
			if (regionProperties.getTitle().equals("90-110平米")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("90"));
				Assert.assertTrue(regionProperties.getHighValue().equals("110"));
			}
			if (regionProperties.getTitle().equals("110-130平米")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("110"));
				Assert.assertTrue(regionProperties.getHighValue().equals("130"));
			}
			if (regionProperties.getTitle().equals("130-150平米")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("130"));
				Assert.assertTrue(regionProperties.getHighValue().equals("150"));
			}
			if (regionProperties.getTitle().equals("150-200平米")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("150"));
				Assert.assertTrue(regionProperties.getHighValue().equals("200"));
			}
			if (regionProperties.getTitle().equals("200-300平米")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("200"));
				Assert.assertTrue(regionProperties.getHighValue().equals("300"));
			}
			if (regionProperties.getTitle().equals("300平米以上")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("300"));
				Assert.assertTrue(regionProperties.getHighValue().equals(""));
			}
	}
  }
  @Test
  public void getFilterParamResponse6() {
	  int size = estateRegion.size();
	  for (int i = 0; i < size; i++) {
		  RegionProperties regionProperties = estateRegion.get(i);
			if (regionProperties.getTitle().equals("不限")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("0"));
				Assert.assertTrue(regionProperties.getHighValue().equals("0"));
			}
			if (regionProperties.getTitle().equals("3万以下")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("0"));
				Assert.assertTrue(regionProperties.getHighValue().equals("3"));
			}
			if (regionProperties.getTitle().equals("3-4万")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("3"));
				Assert.assertTrue(regionProperties.getHighValue().equals("4"));
			}
			if (regionProperties.getTitle().equals("4-5万")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("4"));
				Assert.assertTrue(regionProperties.getHighValue().equals("5"));
			}
			if (regionProperties.getTitle().equals("5-6万")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("5"));
				Assert.assertTrue(regionProperties.getHighValue().equals("6"));
			}
			if (regionProperties.getTitle().equals("6-7万")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("6"));
				Assert.assertTrue(regionProperties.getHighValue().equals("7"));
			}
			if (regionProperties.getTitle().equals("7-8万")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("7"));
				Assert.assertTrue(regionProperties.getHighValue().equals("8"));
			}
			if (regionProperties.getTitle().equals("8万以上")) {
				Assert.assertTrue(regionProperties.getLowValue().equals("8"));
				Assert.assertTrue(regionProperties.getHighValue().equals("0"));
			}
	}
  }
}
