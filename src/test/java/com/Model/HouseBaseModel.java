package com.Model;

import java.util.Date;
import java.util.Map;

/**
 * 房源信息模型
 * 
 * @author Administrator
 *
 */
public class HouseBaseModel {
	private String tag;
	private long houseId;// 房源id
	private String rentPrice;// 出租价格
	private int picNum; // 照片数量
	private String[] picUrls; // 照片URL数组
	private int bedroomSum;// 几房
	private int livingRoomSum;// 几厅
	private int wcSum;// 几卫
	private int floor;// 楼层
	private int layers;// 总层高
	private String decorateType; // 毛坯，精装修
	private String estateName;// 所属小区或楼盘名称 eg.玉兰香苑2期
	private String areaName; // 区域名称 eg.花木
	private String townName;// 片区名称 eg.世纪公园
	private String pubDate;// 发布日期
	private String floorType = "";// 楼层显示:高层/共x层，中层/共x层，低层/共x层
	private String floorType2 = ""; // 楼层显示:高层，中层，低层
	private int collectionState; // 收藏状态 0:没收藏 1：已收藏
	private int enable; // 房源是否可用 0：不可用 1：可用
	private int estateId; // 小区id
	private Map<String, String> hdUrls;// 高清图
	private double lon; // 经度
	private double lat; // 纬度
	private double distance;// 距GPS定位距离
	private int currentImage;// android客户端需要此字段，服务端无需使用
	private String plateName;// 板块地址，兼容现有ios版本
	private String building; // 几号楼
	private String houseSpace;// 房屋面积
	private Date publishDate;
	// 二手房新增字段
	private String sellPrice; // 出售价格
	private int rentOrSale; // 租售类型：0-租房；1-二手房
	private int videoNum; // 视频数量：0-无视频；非零-有视频
	private String videoUrl = "";// 视频URL
	private String videoPic = ""; // 视频缩略图
	private int videoType;// 0是普通视频 1是全景视频
	private int sign; // 是否独家 0-否 ；1-是
	private int aboveFiveYear; // 是否满五 0-否 ；1-是
	private int onlyOne; // 是否唯一 0-否 ；1-是
	private int school; // 是否学区房 0-否 ；1-是
	private int subway; // 是否地铁房 0-否 ；1-是
	private int publishByUser; // 是否业主发布 0-否 ；1-是
	private String unitPrice; // 单价
	private int rentOrBrand; // 普租或者品牌公寓：1普租 2品牌公寓 6.6新增
	// 以下三个在rentOrBrand=2时使用 6.6新增
	private int rentType; // 品牌公寓类型：1合租 2整租
	private String roomName = ""; // 品牌公寓，卧室名称
	private String houseRoom = ""; // 品牌公寓，户型
	private String activityTag = ""; // 品牌公寓活动标签 6.7新增
	private String cityName;
	private String spaceArea;
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getSpaceArea() {
		return spaceArea;
	}
	public void setSpaceArea(String spaceArea) {
		this.spaceArea = spaceArea;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public long getHouseId() {
		return houseId;
	}
	public void setHouseId(long houseId) {
		this.houseId = houseId;
	}
	public String getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(String rentPrice) {
		this.rentPrice = rentPrice;
	}
	public int getPicNum() {
		return picNum;
	}
	public void setPicNum(int picNum) {
		this.picNum = picNum;
	}
	public String[] getPicUrls() {
		return picUrls;
	}
	public void setPicUrls(String[] picUrls) {
		this.picUrls = picUrls;
	}
	public int getBedroomSum() {
		return bedroomSum;
	}
	public void setBedroomSum(int bedroomSum) {
		this.bedroomSum = bedroomSum;
	}
	public int getLivingRoomSum() {
		return livingRoomSum;
	}
	public void setLivingRoomSum(int livingRoomSum) {
		this.livingRoomSum = livingRoomSum;
	}
	public int getWcSum() {
		return wcSum;
	}
	public void setWcSum(int wcSum) {
		this.wcSum = wcSum;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public int getLayers() {
		return layers;
	}
	public void setLayers(int layers) {
		this.layers = layers;
	}
	public String getDecorateType() {
		return decorateType;
	}
	public void setDecorateType(String decorateType) {
		this.decorateType = decorateType;
	}
	public String getEstateName() {
		return estateName;
	}
	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	public String getFloorType() {
		return floorType;
	}
	public void setFloorType(String floorType) {
		this.floorType = floorType;
	}
	public String getFloorType2() {
		return floorType2;
	}
	public void setFloorType2(String floorType2) {
		this.floorType2 = floorType2;
	}
	public int getCollectionState() {
		return collectionState;
	}
	public void setCollectionState(int collectionState) {
		this.collectionState = collectionState;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public int getEstateId() {
		return estateId;
	}
	public void setEstateId(int estateId) {
		this.estateId = estateId;
	}
	public Map<String, String> getHdUrls() {
		return hdUrls;
	}
	public void setHdUrls(Map<String, String> hdUrls) {
		this.hdUrls = hdUrls;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public int getCurrentImage() {
		return currentImage;
	}
	public void setCurrentImage(int currentImage) {
		this.currentImage = currentImage;
	}
	public String getPlateName() {
		return plateName;
	}
	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public String getHouseSpace() {
		return houseSpace;
	}
	public void setHouseSpace(String houseSpace) {
		this.houseSpace = houseSpace;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}
	public int getRentOrSale() {
		return rentOrSale;
	}
	public void setRentOrSale(int rentOrSale) {
		this.rentOrSale = rentOrSale;
	}
	public int getVideoNum() {
		return videoNum;
	}
	public void setVideoNum(int videoNum) {
		this.videoNum = videoNum;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getVideoPic() {
		return videoPic;
	}
	public void setVideoPic(String videoPic) {
		this.videoPic = videoPic;
	}
	public int getVideoType() {
		return videoType;
	}
	public void setVideoType(int videoType) {
		this.videoType = videoType;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public int getAboveFiveYear() {
		return aboveFiveYear;
	}
	public void setAboveFiveYear(int aboveFiveYear) {
		this.aboveFiveYear = aboveFiveYear;
	}
	public int getOnlyOne() {
		return onlyOne;
	}
	public void setOnlyOne(int onlyOne) {
		this.onlyOne = onlyOne;
	}
	public int getSchool() {
		return school;
	}
	public void setSchool(int school) {
		this.school = school;
	}
	public int getSubway() {
		return subway;
	}
	public void setSubway(int subway) {
		this.subway = subway;
	}
	public int getPublishByUser() {
		return publishByUser;
	}
	public void setPublishByUser(int publishByUser) {
		this.publishByUser = publishByUser;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getRentOrBrand() {
		return rentOrBrand;
	}
	public void setRentOrBrand(int rentOrBrand) {
		this.rentOrBrand = rentOrBrand;
	}
	public int getRentType() {
		return rentType;
	}
	public void setRentType(int rentType) {
		this.rentType = rentType;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getHouseRoom() {
		return houseRoom;
	}
	public void setHouseRoom(String houseRoom) {
		this.houseRoom = houseRoom;
	}
	public String getActivityTag() {
		return activityTag;
	}
	public void setActivityTag(String activityTag) {
		this.activityTag = activityTag;
	}
	
}
