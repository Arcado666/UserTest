package com.Model;

import java.util.Date;

public class SearchRequestModel {
	private int city = 2;// 选择的城市
	private String key;// 搜索关键字
	private long lowPrice;// 最低价
	private long highPrice;// 最高价
	private int room;// 卧室
	private int decorate;// 装修
	private Date inhouse;// 入住时间
	private int offset; //数据起始标号 
	private int pageSize; //每页显示数据条数
	private long userId; //用户ID
	private int sequence; //排序方式
	private double lat; //纬度
	private double lon; //经度
	private int level;// 地图层级
	private int areaId;// 小区ID
	private int tag;
	private int rooms;//筛选几室
	private String roomArray;//筛选
	private String block ;//板块
	private String[] latlonArray;//数组格式：{"纬度,经度"(topleft),"纬度2,经度2"(topright),"纬度3,经度3"(bottomright),"纬度4,经度4(bottomleft)"}
	private String distance; //距目标距离
	private int subwayLineId;//地铁线ID
	private int rentOrSale = 0; // 租售类型：0-租房；1-二手房；2-新房  3-品牌公寓
	private int isHot;//业务是否为热门搜索  1是 0 否
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public long getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(long lowPrice) {
		this.lowPrice = lowPrice;
	}
	public long getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(long highPrice) {
		this.highPrice = highPrice;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getDecorate() {
		return decorate;
	}
	public void setDecorate(int decorate) {
		this.decorate = decorate;
	}
	public Date getInhouse() {
		return inhouse;
	}
	public void setInhouse(Date inhouse) {
		this.inhouse = inhouse;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public int getRooms() {
		return rooms;
	}
	public void setRooms(int rooms) {
		this.rooms = rooms;
	}
	public String getRoomArray() {
		return roomArray;
	}
	public void setRoomArray(String roomArray) {
		this.roomArray = roomArray;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String[] getLatlonArray() {
		return latlonArray;
	}
	public void setLatlonArray(String[] latlonArray) {
		this.latlonArray = latlonArray;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public int getSubwayLineId() {
		return subwayLineId;
	}
	public void setSubwayLineId(int subwayLineId) {
		this.subwayLineId = subwayLineId;
	}
	public int getRentOrSale() {
		return rentOrSale;
	}
	public void setRentOrSale(int rentOrSale) {
		this.rentOrSale = rentOrSale;
	}
	public int getIsHot() {
		return isHot;
	}
	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}
	
}
