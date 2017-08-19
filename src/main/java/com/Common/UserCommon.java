package com.Common;

import java.util.Date;

public class UserCommon {
//	String host = "userapp.iwjwtest.com";//userappbeta.iwjw.com:8101  userapp.iwjwtest.com
	String host = "userappbeta.iwjw.com:8101";
	String cityId = "2";
	String App_Key = "iwjw.superjia.com";
	String App_Time = new Date().getTime() + "";
	String ver = "6.6";
//	String os = "iphone OS";
//	String imei = "85F6664F-6FF3-42DF-888C-B0D280501165";
	String os = "android";
	String imei = "a000005529c335";
	String uticket = "";

	public String getUticket() {
		return uticket;
	}

	public void setUticket(String uticket) {
		this.uticket = uticket;
	}

	public String getCityId() {
		return cityId;
	}

	public String getApp_Key() {
		return App_Key;
	}

	public String getApp_Time() {
		return App_Time;
	}

	public String getVer() {
		return ver;
	}

	public String getOs() {
		return os;
	}

	public String getImei() {
		return imei;
	}

	public String getHost() {
		return host;
	}

	public String getcityId() {
		return cityId;
	}
}
