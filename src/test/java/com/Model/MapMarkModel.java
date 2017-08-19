package com.Model;

public class MapMarkModel {
	private int areaId; // 区域ID
	private String areaName = ""; // 区域名称，小区层级为小区名称
	private int grade; // 房源颗粒 1-区域; 2-板块; 3-小区
	private int houseNum; // 房源数量
	private double lat; // 纬度
	private double lon; // 经度
	private String stationName = "";
	private String geoHash = "";
	private double distance;
	private int isNewHouse = 0;// 是否是新房 默认0 1是新房
	private String monthAveragePrice; // 小区本月均价 为空字符串("")时表示无法获取均价
	private int isCollect; // （登录状态时判断）小区是否已关注 0-未关注 1-已关注
	private int brandHouseNum; // 品牌公寓房源数量 6.6新增
	private String[] latlonArray;// 屏幕四个角的坐标
	private int stationId; // 地铁站id
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getHouseNum() {
		return houseNum;
	}
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getGeoHash() {
		return geoHash;
	}
	public void setGeoHash(String geoHash) {
		this.geoHash = geoHash;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getIsNewHouse() {
		return isNewHouse;
	}
	public void setIsNewHouse(int isNewHouse) {
		this.isNewHouse = isNewHouse;
	}
	public String getMonthAveragePrice() {
		return monthAveragePrice;
	}
	public void setMonthAveragePrice(String monthAveragePrice) {
		this.monthAveragePrice = monthAveragePrice;
	}
	public int getIsCollect() {
		return isCollect;
	}
	public void setIsCollect(int isCollect) {
		this.isCollect = isCollect;
	}
	public int getBrandHouseNum() {
		return brandHouseNum;
	}
	public void setBrandHouseNum(int brandHouseNum) {
		this.brandHouseNum = brandHouseNum;
	}
	public String[] getLatlonArray() {
		return latlonArray;
	}
	public void setLatlonArray(String[] latlonArray) {
		this.latlonArray = latlonArray;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

}
