package com.Demo.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Common.AddLogWrap;
import com.Common.UserCommon;
import com.Demo.KeywordServiceRequest;
import com.Model.KeywordModel;
import com.Model.SearchRequestModel;
import com.alibaba.fastjson.JSON;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.UseProperties;

public class KeywordServiceRequestTest {
	public static final Logger LOGGER = Logger.getLogger(KeywordServiceRequestTest.class);
	String mobile ;
	String url = new UserCommon().getHost();
	String uticket;
	String userId;
	@BeforeClass
	public void getPorperties() {
		LOGGER.info("热门搜索结果--->>>");
		mobile = UseProperties.GetValueByKey("config.properties", "mobile");
		uticket = UseProperties.GetValueByKey("config.properties", "uticket");
		userId = UseProperties.GetValueByKey("config.properties", "userId");
		}
  @Test
  /**
   * 二手房默认热门搜索tips
   */
  public void getKeywordServiceResponse1() {
	 LOGGER.info("二手房默认热门搜索tips");
    String result = new KeywordServiceRequest().getKeywordServiceResponse(getSearchRequestModel(1), uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
    if (CommonUtils.parseJson("keywordList", result) == null) {
    	LOGGER.error("没有获取到热门搜索的tips");
		throw new RuntimeException("没有获取到热门搜索的tips");
	}else {
		int size = keywordList.size();
		for (int i = 0; i < size; i++) {
			
			KeywordModel keywordModel = keywordList.get(i);
			LOGGER.info("keywordModel.getEstateId()="+keywordModel.getEstateId()+"");
			Assert.assertNotNull(keywordModel.getEstateId());
			LOGGER.info("keywordModel.getKeywords()="+keywordModel.getKeywords()+"");
			Assert.assertNotNull(keywordModel.getKeywords());
		}
	}
  }
  @Test
  /**
   * 新房默认热门搜索tips
   */
  public void getKeywordServiceResponse2() {
	 LOGGER.info("新房默认热门搜索tips");
    String result = new KeywordServiceRequest().getKeywordServiceResponse(getSearchRequestModel(2), uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
    if (CommonUtils.parseJson("keywordList", result) == null) {
    	LOGGER.error("没有获取到热门搜索的tips");
		throw new RuntimeException("没有获取到热门搜索的tips");
	}else {
		int size = keywordList.size();
		for (int i = 0; i < size; i++) {
			KeywordModel keywordModel = keywordList.get(i);
			LOGGER.info("keywordModel.getEstateId()="+keywordModel.getEstateId()+"");
			Assert.assertNotNull(keywordModel.getEstateId());
			LOGGER.info("keywordModel.getKeywords()="+keywordModel.getKeywords()+"");
			Assert.assertNotNull(keywordModel.getKeywords());
		}
	}
  }
  @Test
  /**
   * 租房默认热门搜索tips
   */
  public void getKeywordServiceResponse3() {
	 LOGGER.info("租房默认热门搜索tips");
    String result = new KeywordServiceRequest().getKeywordServiceResponse(getSearchRequestModel(0), uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
    if (CommonUtils.parseJson("keywordList", result) == null) {
    	LOGGER.error("没有获取到热门搜索的tips");
		throw new RuntimeException("没有获取到热门搜索的tips");
	}else {
		int size = keywordList.size();
		for (int i = 0; i < size; i++) {
			KeywordModel keywordModel = keywordList.get(i);
			LOGGER.info("keywordModel.getEstateId()="+keywordModel.getEstateId()+"");
			Assert.assertNotNull(keywordModel.getEstateId());
			LOGGER.info("keywordModel.getKeywords()="+keywordModel.getKeywords()+"");
			Assert.assertNotNull(keywordModel.getKeywords());
		}
	}
  }
  @Test
  /**
   * 品牌公寓房默认热门搜索tips
   */
  public void getKeywordServiceResponse4() {
	 LOGGER.info("品牌公寓房默认热门搜索tips");
    String result = new KeywordServiceRequest().getKeywordServiceResponse(getSearchRequestModel(3), uticket);
    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
    	LOGGER.error(result);
		throw new RuntimeException(result);
	}
    LOGGER.info("result="+result+"");
    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
    if (CommonUtils.parseJson("keywordList", result) == null) {
    	LOGGER.error("没有获取到热门搜索的tips");
		throw new RuntimeException("没有获取到热门搜索的tips");
	}else {
		int size = keywordList.size();
		for (int i = 0; i < size; i++) {
			KeywordModel keywordModel = keywordList.get(i);
			LOGGER.info("keywordModel.getEstateId()="+keywordModel.getEstateId()+"");
			Assert.assertNotNull(keywordModel.getEstateId());
			LOGGER.info("keywordModel.getKeywords()="+keywordModel.getKeywords()+"");
			Assert.assertNotNull(keywordModel.getKeywords());
		}
	}
  }
  
  @Test
  /**
   * 大首页以“永和”搜索全部房源tips
   */
  public void getKeywordServiceResponse5() {
		 LOGGER.info("大首页以“永和”搜索全部房源tips");
	    String result = new KeywordServiceRequest().getKeywordServiceResponse2(getSearchRequestModel2(1024,"永和"), uticket);
	    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
	    	LOGGER.error(result);
			throw new RuntimeException(result);
		}
	    LOGGER.info("result="+result+"");
	    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	LOGGER.error("没有获取到热门搜索的tips");
			throw new RuntimeException("没有获取到tips");
		}else {
			int size = keywordList.size();
			for (int i = 0; i < size; i++) {
				KeywordModel keywordModel = keywordList.get(i);
				LOGGER.info("keywordModel.getEstateId()="+keywordModel.getEstateId()+"");
				Assert.assertNotNull(keywordModel.getEstateId());
				LOGGER.info("keywordModel.getKeywords()="+keywordModel.getKeywords()+"");
				Assert.assertNotNull(keywordModel.getKeywords());
				LOGGER.info("keywordModel.getBrandHouseNum()="+keywordModel.getBrandHouseNum()+"");
				Assert.assertNotNull(keywordModel.getBrandHouseNum());
				LOGGER.info("keywordModel.getCityId()="+keywordModel.getCityId()+"");
				Assert.assertNotNull(keywordModel.getCityId());
				LOGGER.info("keywordModel.getEstateType()="+keywordModel.getEstateType()+"");
				Assert.assertNotNull(keywordModel.getEstateType());
				LOGGER.info("keywordModel.getHouseNum()="+keywordModel.getHouseNum()+"");
				Assert.assertNotNull(keywordModel.getHouseNum());
				LOGGER.info("keywordModel.getRentHouseNum()="+keywordModel.getRentHouseNum()+"");
				Assert.assertNotNull(keywordModel.getRentHouseNum());
				LOGGER.info("keywordModel.getSellHouseNum()="+keywordModel.getSellHouseNum()+"");
				Assert.assertNotNull(keywordModel.getSellHouseNum());
			}
		}
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	LOGGER.error("没有获取到热门搜索的tips");
	    	throw new RuntimeException("没有获取到模糊匹配的tips");
		}
	  }
  
  @Test
  /**
   * 大首页以“永和”搜索二手房房源tips
   */
  public void getKeywordServiceResponse6() {
		 LOGGER.info("大首页以“永和”搜索二手房房源tips");
	    String result = new KeywordServiceRequest().getKeywordServiceResponse2(getSearchRequestModel2(1,"永和"), uticket);
	    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
	    	LOGGER.error(result);
			throw new RuntimeException(result);
		}
	    LOGGER.info("result="+result+"");
	    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	LOGGER.error("没有获取到热门搜索的tips");
			throw new RuntimeException("没有获取到tips");
		}else {
			int size = keywordList.size();
			for (int i = 0; i < size; i++) {
				KeywordModel keywordModel = keywordList.get(i);
				LOGGER.info("keywordModel.getEstateId()="+keywordModel.getEstateId()+"");
				Assert.assertNotNull(keywordModel.getEstateId());
				LOGGER.info("keywordModel.getKeywords()="+keywordModel.getKeywords()+"");
				Assert.assertNotNull(keywordModel.getKeywords());
				LOGGER.info("keywordModel.getBrandHouseNum()="+keywordModel.getBrandHouseNum()+"");
				Assert.assertNotNull(keywordModel.getBrandHouseNum());
				LOGGER.info("keywordModel.getCityId()="+keywordModel.getCityId()+"");
				Assert.assertNotNull(keywordModel.getCityId());
				LOGGER.info("keywordModel.getEstateType()="+keywordModel.getEstateType()+"");
				Assert.assertNotNull(keywordModel.getEstateType());
				LOGGER.info("keywordModel.getHouseNum()="+keywordModel.getHouseNum()+"");
				Assert.assertNotNull(keywordModel.getHouseNum());
				LOGGER.info("keywordModel.getRentHouseNum()="+keywordModel.getRentHouseNum()+"");
				Assert.assertNotNull(keywordModel.getRentHouseNum());
				LOGGER.info("keywordModel.getSellHouseNum()="+keywordModel.getSellHouseNum()+"");
				Assert.assertNotNull(keywordModel.getSellHouseNum());
			}
		}
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	LOGGER.error("没有获取到热门搜索的tips");
	    	throw new RuntimeException("没有获取到模糊匹配的tips");
		}
	  }
  
  @Test
  /**
   * 大首页以“永和”搜索租房房源tips
   */
  public void getKeywordServiceResponse7() {
		 LOGGER.info("大首页以“永和”搜索租房房源tips");
	    String result = new KeywordServiceRequest().getKeywordServiceResponse2(getSearchRequestModel2(0,"永和"), uticket);
	    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
	    	LOGGER.error(result);
			throw new RuntimeException(result);
		}
	    LOGGER.info("result="+result+"");
	    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	LOGGER.error("没有获取到热门搜索的tips");
			throw new RuntimeException("没有获取到tips");
		}else {
			int size = keywordList.size();
			for (int i = 0; i < size; i++) {
				KeywordModel keywordModel = keywordList.get(i);
				LOGGER.info("keywordModel.getEstateId()="+keywordModel.getEstateId()+"");
				Assert.assertNotNull(keywordModel.getEstateId());
				LOGGER.info("keywordModel.getKeywords()="+keywordModel.getKeywords()+"");
				Assert.assertNotNull(keywordModel.getKeywords());
				LOGGER.info("keywordModel.getBrandHouseNum()="+keywordModel.getBrandHouseNum()+"");
				Assert.assertNotNull(keywordModel.getBrandHouseNum());
				LOGGER.info("keywordModel.getCityId()="+keywordModel.getCityId()+"");
				Assert.assertNotNull(keywordModel.getCityId());
				LOGGER.info("keywordModel.getEstateType()="+keywordModel.getEstateType()+"");
				Assert.assertNotNull(keywordModel.getEstateType());
				LOGGER.info("keywordModel.getHouseNum()="+keywordModel.getHouseNum()+"");
				Assert.assertNotNull(keywordModel.getHouseNum());
				LOGGER.info("keywordModel.getRentHouseNum()="+keywordModel.getRentHouseNum()+"");
				Assert.assertNotNull(keywordModel.getRentHouseNum());
				LOGGER.info("keywordModel.getSellHouseNum()="+keywordModel.getSellHouseNum()+"");
				Assert.assertNotNull(keywordModel.getSellHouseNum());
			}
		}
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	LOGGER.error("没有获取到热门搜索的tips");
	    	throw new RuntimeException("没有获取到模糊匹配的tips");
		}
	  }
  
  @Test
  /**
   * 大首页以“永和”搜索新房源tips
   */
  public void getKeywordServiceResponse8() {
		 LOGGER.info("大首页以“永和”搜索新房源tips");
	    String result = new KeywordServiceRequest().getKeywordServiceResponse2(getSearchRequestModel2(2,"永和"), uticket);
	    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
	    	LOGGER.error(result);
			throw new RuntimeException(result);
		}
	    LOGGER.info("result="+result+"");
	    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	LOGGER.error("没有获取到热门搜索的tips");
			throw new RuntimeException("没有获取到tips");
		}else {
			int size = keywordList.size();
			for (int i = 0; i < size; i++) {
				KeywordModel keywordModel = keywordList.get(i);
				LOGGER.info("keywordModel.getEstateId()="+keywordModel.getEstateId()+"");
				Assert.assertNotNull(keywordModel.getEstateId());
				LOGGER.info("keywordModel.getKeywords()="+keywordModel.getKeywords()+"");
				Assert.assertNotNull(keywordModel.getKeywords());
				LOGGER.info("keywordModel.getBrandHouseNum()="+keywordModel.getBrandHouseNum()+"");
				Assert.assertNotNull(keywordModel.getBrandHouseNum());
				LOGGER.info("keywordModel.getCityId()="+keywordModel.getCityId()+"");
				Assert.assertNotNull(keywordModel.getCityId());
				LOGGER.info("keywordModel.getEstateType()="+keywordModel.getEstateType()+"");
				Assert.assertNotNull(keywordModel.getEstateType());
				LOGGER.info("keywordModel.getHouseNum()="+keywordModel.getHouseNum()+"");
				Assert.assertNotNull(keywordModel.getHouseNum());
				LOGGER.info("keywordModel.getRentHouseNum()="+keywordModel.getRentHouseNum()+"");
				Assert.assertNotNull(keywordModel.getRentHouseNum());
				LOGGER.info("keywordModel.getSellHouseNum()="+keywordModel.getSellHouseNum()+"");
				Assert.assertNotNull(keywordModel.getSellHouseNum());
				LOGGER.info("keywordModel.getTipsH5Url()="+keywordModel.getTipsH5Url()+"");
				Assert.assertNotNull(keywordModel.getTipsH5Url());
			}
		}
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	LOGGER.error("没有获取到热门搜索的tips");
	    	throw new RuntimeException("没有获取到模糊匹配的tips");
		}
	  }
  
  
  @Test
  /**
   * 大首页以“永和”搜索品牌公寓房源tips
   */
  public void getKeywordServiceResponse9() {
		 LOGGER.info("大首页以“永和”搜索品牌公寓房源tips");
	    String result = new KeywordServiceRequest().getKeywordServiceResponse2(getSearchRequestModel2(3,"永和"), uticket);
	    if (CommonUtils.parseJson("errorCode", result).equals("110001")) {
	    	LOGGER.error(result);
			throw new RuntimeException(result);
		}
	    LOGGER.info("result="+result+"");
	    List<KeywordModel> keywordList = JSON.parseArray(CommonUtils.parseJson("keywordList", result), KeywordModel.class);
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	LOGGER.error("没有获取到热门搜索的tips");
			throw new RuntimeException("没有获取到tips");
		}else {
			int size = keywordList.size();
			for (int i = 0; i < size; i++) {
				KeywordModel keywordModel = keywordList.get(i);
				LOGGER.info("keywordModel.getEstateId()="+keywordModel.getEstateId()+"");
				Assert.assertNotNull(keywordModel.getEstateId());
				LOGGER.info("keywordModel.getKeywords()="+keywordModel.getKeywords()+"");
				Assert.assertNotNull(keywordModel.getKeywords());
				LOGGER.info("keywordModel.getBrandHouseNum()="+keywordModel.getBrandHouseNum()+"");
				Assert.assertNotNull(keywordModel.getBrandHouseNum());
				LOGGER.info("keywordModel.getCityId()="+keywordModel.getCityId()+"");
				Assert.assertNotNull(keywordModel.getCityId());
				LOGGER.info("keywordModel.getEstateType()="+keywordModel.getEstateType()+"");
				Assert.assertNotNull(keywordModel.getEstateType());
				LOGGER.info("keywordModel.getHouseNum()="+keywordModel.getHouseNum()+"");
				Assert.assertNotNull(keywordModel.getHouseNum());
				LOGGER.info("keywordModel.getRentHouseNum()="+keywordModel.getRentHouseNum()+"");
				Assert.assertNotNull(keywordModel.getRentHouseNum());
				LOGGER.info("keywordModel.getSellHouseNum()="+keywordModel.getSellHouseNum()+"");
				Assert.assertNotNull(keywordModel.getSellHouseNum());
			}
		}
	    if (CommonUtils.parseJson("keywordList", result) == null) {
	    	LOGGER.error("没有获取到热门搜索的tips");
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
  @AfterClass
  public void afterclass(){
	  LOGGER.info("<<<---热门搜索结果");
	  new AddLogWrap();
  }
}
