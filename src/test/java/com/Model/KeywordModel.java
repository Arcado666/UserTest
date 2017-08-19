package com.Model;

public class KeywordModel {
	private String estateId; //小区ID 
	private String estateName; //小区名，无小区别名时为Type的名称
	private int secondLevelId;// 二级ID（estateType=5地铁站时设值地铁线ID，2板块时设值区域ID）
	 // 1区域 2板块 3小区名 4地铁线 5地铁站 6小区别名 7小区地址 8学校全名 9学校常用名 10学校别名 11新房名 12新房别名
	private String estateType; 
	private String keywords; //搜索关键字
	private int houseNum; //房源数量 from 3.3
	 
	private int rentHouseNum;//租房房源数目
	private int sellHouseNum;//二手房房源数目
	private int brandHouseNum;//品牌公寓房源数目
	private int newHouseNum;//新房房源数目
	private int cityId; //cityId
	private String tipsH5Url = ""; //tips跳转的H5的URL（目前只有新房跳转H5）
	public String getEstateId() {
		return estateId;
	}
	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}
	public String getEstateName() {
		return estateName;
	}
	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}
	public int getSecondLevelId() {
		return secondLevelId;
	}
	public void setSecondLevelId(int secondLevelId) {
		this.secondLevelId = secondLevelId;
	}
	public String getEstateType() {
		return estateType;
	}
	public void setEstateType(String estateType) {
		this.estateType = estateType;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public int getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	public int getRentHouseNum() {
		return rentHouseNum;
	}
	public void setRentHouseNum(int rentHouseNum) {
		this.rentHouseNum = rentHouseNum;
	}
	public int getSellHouseNum() {
		return sellHouseNum;
	}
	public void setSellHouseNum(int sellHouseNum) {
		this.sellHouseNum = sellHouseNum;
	}
	public int getBrandHouseNum() {
		return brandHouseNum;
	}
	public void setBrandHouseNum(int brandHouseNum) {
		this.brandHouseNum = brandHouseNum;
	}
	public int getNewHouseNum() {
		return newHouseNum;
	}
	public void setNewHouseNum(int newHouseNum) {
		this.newHouseNum = newHouseNum;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getTipsH5Url() {
		return tipsH5Url;
	}
	public void setTipsH5Url(String tipsH5Url) {
		this.tipsH5Url = tipsH5Url;
	}
	
}
