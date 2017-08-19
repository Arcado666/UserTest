package com.Demo.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Demo.Iwjwh5urlRequest;
import com.qiang.utils.CommonUtils;
import com.qiang.utils.FormJSON;


public class Iwjwh5urlRequestTest {
	String result ;
	@BeforeClass
	public void BeforeClass(){
		result = new Iwjwh5urlRequest().getIwjwh5urlResponse();
	}
  @Test
  public void getIwjwh5urlResponse() {
	  System.err.println(FormJSON.format(result));
	  
    Assert.assertTrue(CommonUtils.parseJson("helpCenterUrl", result).contains("http://m.iwjw.com/help"));
    Assert.assertTrue(CommonUtils.parseJson("loanHelpUrl", result).contains("http://m.iwjw.com/helpRight/6"));
    Assert.assertTrue(CommonUtils.parseJson("safecardExplainUrl", result).contains("/licai/safecard"));
    Assert.assertTrue(CommonUtils.parseJson("supportcardsByAllUrl", result).contains("/licai/supportcards"));
    Assert.assertTrue(CommonUtils.parseJson("supportcardsByBankUrl", result).contains("/licai/supportcards?type=bank"));
    Assert.assertTrue(CommonUtils.parseJson("supportcardsByCreditUrl", result).contains("/licai/supportcards?type=credit"));
    Assert.assertTrue(CommonUtils.parseJson("accountProtocol", result).contains("/licai/protocal/eaccount"));
    Assert.assertTrue(CommonUtils.parseJson("ailicaiProtocol", result).contains("/licai/protocal/service"));
    Assert.assertTrue(CommonUtils.parseJson("defaultNewHouseUrl", result).contains("/newhouse/"));
    Assert.assertTrue(CommonUtils.parseJson("cardUrl", result).contains("/card/"));
    Assert.assertTrue(CommonUtils.parseJson("tradeEnsureCardUrl", result).contains("http://m.iwjw.com/card/servicecard"));
    Assert.assertTrue(CommonUtils.parseJson("ailicaiUrl", result).contains("/licai/licaiindex"));
    Assert.assertTrue(CommonUtils.parseJson("orderH5Url", result).contains("/myorder"));
    Assert.assertTrue(CommonUtils.parseJson("orderDetailH5Url", result).contains("/myorder#!/myorder/detail"));
    Assert.assertTrue(CommonUtils.parseJson("aboutUrl", result).contains("/about/"));
    Assert.assertTrue(CommonUtils.parseJson("alicaiType", result).contains("2"));
    Assert.assertTrue(CommonUtils.parseJson("rentHouseCommissionUrl", result).contains("http://m.iwjw.com/jiaizhai/chuzumanager"));
    Assert.assertTrue(CommonUtils.parseJson("rentOrderDetailH5Url", result).contains("/myorder#!/rent_detail"));
    Assert.assertTrue(CommonUtils.parseJson("rentBillDetailH5Url", result).contains("/myorder#!/rent_bill"));
    Assert.assertTrue(CommonUtils.parseJson("payRentH5Url", result).contains("/myorder#!/payrent?_router=server"));
    Assert.assertTrue(CommonUtils.parseJson("payRentBillDetailH5Url", result).contains("/myorder#!/payrent_bill"));
    Assert.assertTrue(CommonUtils.parseJson("tiyanbaoDetailUrl", result).contains("/licai/index#!/tiyanbao"));
    Assert.assertTrue(CommonUtils.parseJson("productDetailUrl", result).contains("/licai/index#!/detail"));
    Assert.assertTrue(CommonUtils.parseJson("rebateUrl", result).contains("voucher/rebate-detail"));
  }
}
