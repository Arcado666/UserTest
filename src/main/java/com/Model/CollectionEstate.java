package com.Model;

public class CollectionEstate {
	private long collId;//关注Id
	private int type=2; //关注类型:2：小区 固定值
	private long estateId; //小区id
	private int rentOrSale; //租售类型 0-租房 1-二手房
	private String estateImg; //小区图片
	private String estateName; //小区名称
	private String area; //板块
	private int effectiveHouseNum;//小区有效房源总数
	private String feedTitle;//动态文案
	private String constructDate;//建造年代 (eg.2008年建造)
	private String avgPrice;//均价（eg.5.6万/平、8900元/平）
	public long getCollId() {
		return collId;
	}
	public void setCollId(long collId) {
		this.collId = collId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public long getEstateId() {
		return estateId;
	}
	public void setEstateId(long estateId) {
		this.estateId = estateId;
	}
	public int getRentOrSale() {
		return rentOrSale;
	}
	public void setRentOrSale(int rentOrSale) {
		this.rentOrSale = rentOrSale;
	}
	public String getEstateImg() {
		return estateImg;
	}
	public void setEstateImg(String estateImg) {
		this.estateImg = estateImg;
	}
	public String getEstateName() {
		return estateName;
	}
	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getEffectiveHouseNum() {
		return effectiveHouseNum;
	}
	public void setEffectiveHouseNum(int effectiveHouseNum) {
		this.effectiveHouseNum = effectiveHouseNum;
	}
	public String getFeedTitle() {
		return feedTitle;
	}
	public void setFeedTitle(String feedTitle) {
		this.feedTitle = feedTitle;
	}
	public String getConstructDate() {
		return constructDate;
	}
	public void setConstructDate(String constructDate) {
		this.constructDate = constructDate;
	}
	public String getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(String avgPrice) {
		this.avgPrice = avgPrice;
	}
}
