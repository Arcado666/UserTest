package com.Model;

public class LayoutModel {
	private String imageUrl;
	private String  smallImageUrl;
	private String name; 
	private Integer bedroomSum; // 室
	private Integer livingRoomSum; // 厅
	private Integer wcSum; // 卫
	private String spaceArea; // 面积
	private String totalPrice; // 总价
	private Long propertyId; //新房id
	private String areaUnit="㎡";  //面积单位
	private String priceUnit="万"; //总价单位
	private String averagePrice; //均价 
	private Long id;
	 private String videoUrl; //视频 
	private int videoType; //视频类型 0普通 1全景
	private int status; //0售罄 1在售 
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getSmallImageUrl() {
		return smallImageUrl;
	}
	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBedroomSum() {
		return bedroomSum;
	}
	public void setBedroomSum(Integer bedroomSum) {
		this.bedroomSum = bedroomSum;
	}
	public Integer getLivingRoomSum() {
		return livingRoomSum;
	}
	public void setLivingRoomSum(Integer livingRoomSum) {
		this.livingRoomSum = livingRoomSum;
	}
	public Integer getWcSum() {
		return wcSum;
	}
	public void setWcSum(Integer wcSum) {
		this.wcSum = wcSum;
	}
	public String getSpaceArea() {
		return spaceArea;
	}
	public void setSpaceArea(String spaceArea) {
		this.spaceArea = spaceArea;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Long getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}
	public String getAreaUnit() {
		return areaUnit;
	}
	public void setAreaUnit(String areaUnit) {
		this.areaUnit = areaUnit;
	}
	public String getPriceUnit() {
		return priceUnit;
	}
	public void setPriceUnit(String priceUnit) {
		this.priceUnit = priceUnit;
	}
	public String getAveragePrice() {
		return averagePrice;
	}
	public void setAveragePrice(String averagePrice) {
		this.averagePrice = averagePrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public int getVideoType() {
		return videoType;
	}
	public void setVideoType(int videoType) {
		this.videoType = videoType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
