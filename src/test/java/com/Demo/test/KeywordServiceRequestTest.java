package com.Demo.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.UserCommon;
import com.Demo.KeywordServiceRequest;
import com.Model.KeywordModel;
import com.Model.SearchRequestModel;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.FormJSON;
import com.qiang.utils.UseProperties;

public class KeywordServiceRequestTest {
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
   * 二手房默认热门搜索tips
   */
  public void getKeywordServiceResponse1() {
	 
    String result = new KeywordServiceRequest().getKeywordServiceResponse(getSearchRequestModel(1), uticket);
    System.err.println(FormJSON.format(result));
    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
    if (CommonUtils.parseJson("keywordList", result) == null) {
		throw new RuntimeException("没有获取到热门搜索的tips");
	}else {
		int size = keywordList.size();
		for (int i = 0; i < size; i++) {
			KeywordModel keywordModel = keywordList.get(i);
			Assert.assertNotNull(keywordModel.getEstateId());
			Assert.assertNotNull(keywordModel.getKeywords());
		}
	}
  }
  @Test
  /**
   * 新房默认热门搜索tips
   */
  public void getKeywordServiceResponse2() {
	 
    String result = new KeywordServiceRequest().getKeywordServiceResponse(getSearchRequestModel(2), uticket);
    System.err.println(FormJSON.format(result));
    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
    if (CommonUtils.parseJson("keywordList", result) == null) {
		throw new RuntimeException("没有获取到热门搜索的tips");
	}else {
		int size = keywordList.size();
		for (int i = 0; i < size; i++) {
			KeywordModel keywordModel = keywordList.get(i);
			Assert.assertNotNull(keywordModel.getEstateId());
			Assert.assertNotNull(keywordModel.getKeywords());
		}
	}
  }
  @Test
  /**
   * 租房默认热门搜索tips
   */
  public void getKeywordServiceResponse3() {
	 
    String result = new KeywordServiceRequest().getKeywordServiceResponse(getSearchRequestModel(0), uticket);
    System.err.println(FormJSON.format(result));
    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
    if (CommonUtils.parseJson("keywordList", result) == null) {
		throw new RuntimeException("没有获取到热门搜索的tips");
	}else {
		int size = keywordList.size();
		for (int i = 0; i < size; i++) {
			KeywordModel keywordModel = keywordList.get(i);
			Assert.assertNotNull(keywordModel.getEstateId());
			Assert.assertNotNull(keywordModel.getKeywords());
		}
	}
  }
  @Test
  /**
   * 品牌公寓房默认热门搜索tips
   */
  public void getKeywordServiceResponse4() {
	 
    String result = new KeywordServiceRequest().getKeywordServiceResponse(getSearchRequestModel(3), uticket);
    System.err.println(FormJSON.format(result));
    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
    if (CommonUtils.parseJson("keywordList", result) == null) {
		throw new RuntimeException("没有获取到热门搜索的tips");
	}else {
		int size = keywordList.size();
		for (int i = 0; i < size; i++) {
			KeywordModel keywordModel = keywordList.get(i);
			Assert.assertNotNull(keywordModel.getEstateId());
			Assert.assertNotNull(keywordModel.getKeywords());
		}
	}
  }
  
  @Test
  /**
   * 大首页以“永和”搜索全部房源tips
   */
  public void getKeywordServiceResponse5() {
		 
	    String result = new KeywordServiceRequest().getKeywordServiceResponse2(getSearchRequestModel2(1024,"永和"), uticket);
	    System.err.println(FormJSON.format(result));
	    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
	    if (CommonUtils.parseJson("keywordList", result) == null) {
			throw new RuntimeException("没有获取到tips");
		}else {
			int size = keywordList.size();
			for (int i = 0; i < size; i++) {
				KeywordModel keywordModel = keywordList.get(i);
				Assert.assertNotNull(keywordModel.getEstateId());
				Assert.assertNotNull(keywordModel.getKeywords());
				Assert.assertNotNull(keywordModel.getBrandHouseNum());
				Assert.assertNotNull(keywordModel.getCityId());
				Assert.assertNotNull(keywordModel.getEstateType());
				Assert.assertNotNull(keywordModel.getHouseNum());
				Assert.assertNotNull(keywordModel.getRentHouseNum());
				Assert.assertNotNull(keywordModel.getSellHouseNum());
			}
		}
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	throw new RuntimeException("没有获取到模糊匹配的tips");
		}
	  }
  
  @Test
  /**
   * 大首页以“永和”搜索二手房房源tips
   */
  public void getKeywordServiceResponse6() {
		 
	    String result = new KeywordServiceRequest().getKeywordServiceResponse2(getSearchRequestModel2(1,"永和"), uticket);
	    System.err.println(FormJSON.format(result));
	    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
	    if (CommonUtils.parseJson("keywordList", result) == null) {
			throw new RuntimeException("没有获取到tips");
		}else {
			int size = keywordList.size();
			for (int i = 0; i < size; i++) {
				KeywordModel keywordModel = keywordList.get(i);
				Assert.assertNotNull(keywordModel.getEstateId());
				Assert.assertNotNull(keywordModel.getKeywords());
				Assert.assertNotNull(keywordModel.getBrandHouseNum());
				Assert.assertNotNull(keywordModel.getCityId());
				Assert.assertNotNull(keywordModel.getEstateType());
				Assert.assertNotNull(keywordModel.getHouseNum());
				Assert.assertNotNull(keywordModel.getRentHouseNum());
				Assert.assertNotNull(keywordModel.getSellHouseNum());
			}
		}
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	throw new RuntimeException("没有获取到模糊匹配的tips");
		}
	  }
  
  @Test
  /**
   * 大首页以“永和”搜索租房房源tips
   */
  public void getKeywordServiceResponse7() {
		 
	    String result = new KeywordServiceRequest().getKeywordServiceResponse2(getSearchRequestModel2(0,"永和"), uticket);
	    System.err.println(FormJSON.format(result));
	    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
	    if (CommonUtils.parseJson("keywordList", result) == null) {
			throw new RuntimeException("没有获取到tips");
		}else {
			int size = keywordList.size();
			for (int i = 0; i < size; i++) {
				KeywordModel keywordModel = keywordList.get(i);
				Assert.assertNotNull(keywordModel.getEstateId());
				Assert.assertNotNull(keywordModel.getKeywords());
				Assert.assertNotNull(keywordModel.getBrandHouseNum());
				Assert.assertNotNull(keywordModel.getCityId());
				Assert.assertNotNull(keywordModel.getEstateType());
				Assert.assertNotNull(keywordModel.getHouseNum());
				Assert.assertNotNull(keywordModel.getRentHouseNum());
				Assert.assertNotNull(keywordModel.getSellHouseNum());
			}
		}
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	throw new RuntimeException("没有获取到模糊匹配的tips");
		}
	  }
  
  @Test
  /**
   * 大首页以“永和”搜索新房源tips
   */
  public void getKeywordServiceResponse8() {
		 
	    String result = new KeywordServiceRequest().getKeywordServiceResponse2(getSearchRequestModel2(2,"永和"), uticket);
	    System.err.println(FormJSON.format(result));
	    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
	    if (CommonUtils.parseJson("keywordList", result) == null) {
			throw new RuntimeException("没有获取到tips");
		}else {
			int size = keywordList.size();
			for (int i = 0; i < size; i++) {
				KeywordModel keywordModel = keywordList.get(i);
				Assert.assertNotNull(keywordModel.getEstateId());
				Assert.assertNotNull(keywordModel.getKeywords());
				Assert.assertNotNull(keywordModel.getBrandHouseNum());
				Assert.assertNotNull(keywordModel.getCityId());
				Assert.assertNotNull(keywordModel.getEstateType());
				Assert.assertNotNull(keywordModel.getHouseNum());
				Assert.assertNotNull(keywordModel.getRentHouseNum());
				Assert.assertNotNull(keywordModel.getSellHouseNum());
				Assert.assertNotNull(keywordModel.getTipsH5Url());
			}
		}
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	throw new RuntimeException("没有获取到模糊匹配的tips");
		}
	  }
  
  
  @Test
  /**
   * 大首页以“永和”搜索品牌公寓房源tips
   */
  public void getKeywordServiceResponse9() {
		 
	    String result = new KeywordServiceRequest().getKeywordServiceResponse2(getSearchRequestModel2(3,"永和"), uticket);
	    System.err.println(FormJSON.format(result));
	    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
	    if (CommonUtils.parseJson("keywordList", result) == null) {
			throw new RuntimeException("没有获取到tips");
		}else {
			int size = keywordList.size();
			for (int i = 0; i < size; i++) {
				KeywordModel keywordModel = keywordList.get(i);
				Assert.assertNotNull(keywordModel.getEstateId());
				Assert.assertNotNull(keywordModel.getKeywords());
				Assert.assertNotNull(keywordModel.getBrandHouseNum());
				Assert.assertNotNull(keywordModel.getCityId());
				Assert.assertNotNull(keywordModel.getEstateType());
				Assert.assertNotNull(keywordModel.getHouseNum());
				Assert.assertNotNull(keywordModel.getRentHouseNum());
				Assert.assertNotNull(keywordModel.getSellHouseNum());
			}
		}
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	throw new RuntimeException("没有获取到模糊匹配的tips");
		}
	  }
  
  /**
   * 设置数据  默认热门搜索tips
   */
  private static  SearchRequestModel getSearchRequestModel(int rentOrSale){
	  SearchRequestModel searchRequestModel = new SearchRequestModel();
	  searchRequestModel.setIsHot(1);
	  searchRequestModel.setRentOrSale(rentOrSale);
	  searchRequestModel.setCity(2);
	  return searchRequestModel;
  }
  /**
   * 设置数据   搜索Tips
   * @param rentOrSale
   * @return
   */
  private static  SearchRequestModel getSearchRequestModel2(int rentOrSale,String key){
	  SearchRequestModel searchRequestModel = new SearchRequestModel();
	  searchRequestModel.setKey(key);;
	  searchRequestModel.setRentOrSale(rentOrSale);
	  searchRequestModel.setCity(2);
	  return searchRequestModel;
  }
}
