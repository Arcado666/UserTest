package com.Common;

import com.qiang.httpClient.HttpConstants;

public class DemoCommon {
	HttpConstants hct;
	UserCommon uc;
	protected static String url = new UserCommon().host; 
	public void setDemoCommon(){
		hct = new HttpConstants();
		uc = new UserCommon();
		hct.setCommonHeader("cityId", uc.getcityId());
		hct.setCommonHeader("App-Key", uc.getApp_Key());
		hct.setCommonHeader("App_Time", uc.getApp_Time());
		hct.setCommonHeader("ver", uc.getVer());
		hct.setCommonHeader("os", uc.getOs());
		hct.setCommonHeader("imei", uc.getImei());
		hct.setCommonHeader("uticket", uc.getUticket());
	}
}
