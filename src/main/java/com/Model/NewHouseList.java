package com.Model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class NewHouseList {
	//基本信息-----------------------
	private Long cityId;
	private Long newHouseId; //新房id
	private String newHouseCode; //新房code
	private String imageUrl; // 新盘封面图
	private String name; // 新盘名称
	private String districtName; //区域
	private Long districtId; //区域id
	private String townName; // 版块名
	private Long townId; // 版块id
	private Set<Long> bedRoom; //户型
	private String totalPrice; //价格，多少万起 
	private String averPrice; //价格，均价
	private String defaultPrice; //价格，供前端显示
	private int priceFlag; //价格标志，1- 元/平，还是 2- 万/平,3- 总价多少万
	private String propertyType; //物业类型
	private String videoUrl = ""; //视频地址 根据url控制是否有视频
	private int videoType; //视频类型 0普通视频 1全景视频
	private int enable; //1房源有效 0无效
	//优惠活动
	private String concessions; //优惠活动
	private List<String> concessionsList; //优惠活动集合
	//卖点
	private String[] maidian; //新房卖点

	private int status; //1上架 2下架 3审核中
	private Collection<LayoutModel> layoutModelList; //关注的户型
	public Collection<LayoutModel> getLayoutModelList() {
		return layoutModelList;
	}

	public void setLayoutModelList(Collection<LayoutModel> layoutModelList) {
		this.layoutModelList = layoutModelList;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getNewHouseId() {
		return newHouseId;
	}

	public void setNewHouseId(Long newHouseId) {
		this.newHouseId = newHouseId;
	}

	public String getNewHouseCode() {
		return newHouseCode;
	}

	public void setNewHouseCode(String newHouseCode) {
		this.newHouseCode = newHouseCode;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public String getTownName() {
		return townName;
	}

	public void setTownName(String townName) {
		this.townName = townName;
	}

	public Long getTownId() {
		return townId;
	}

	public void setTownId(Long townId) {
		this.townId = townId;
	}

	public Set<Long> getBedRoom() {
		return bedRoom;
	}

	public void setBedRoom(Set<Long> bedRoom) {
		this.bedRoom = bedRoom;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getAverPrice() {
		return averPrice;
	}

	public void setAverPrice(String averPrice) {
		this.averPrice = averPrice;
	}

	public String getDefaultPrice() {
		return defaultPrice;
	}

	public void setDefaultPrice(String defaultPrice) {
		this.defaultPrice = defaultPrice;
	}

	public int getPriceFlag() {
		return priceFlag;
	}

	public void setPriceFlag(int priceFlag) {
		this.priceFlag = priceFlag;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
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

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public String getConcessions() {
		return concessions;
	}

	public void setConcessions(String concessions) {
		this.concessions = concessions;
	}

	public List<String> getConcessionsList() {
		return concessionsList;
	}

	public void setConcessionsList(List<String> concessionsList) {
		this.concessionsList = concessionsList;
	}

	public String[] getMaidian() {
		return maidian;
	}

	public void setMaidian(String[] maidian) {
		this.maidian = maidian;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
