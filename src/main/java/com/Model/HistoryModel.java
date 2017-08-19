package com.Model;

public class HistoryModel {
	private String createDate; // 动态时间
	private String markContent; // 动态内容
	private String priceRange; // 增减幅度(如果不是更新价格则无)
	private String beforePrice; // 更新前价格
	private String afterPrice; // 更新后价格
	private int readStatus; // 是否已读（0：未读，1：已读）
	private int feedType; // 动态类型：1-房源新增，2-房源下架，3-房源涨价，4-房源降价,5-更新图片视频
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getMarkContent() {
		return markContent;
	}
	public void setMarkContent(String markContent) {
		this.markContent = markContent;
	}
	public String getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}
	public String getBeforePrice() {
		return beforePrice;
	}
	public void setBeforePrice(String beforePrice) {
		this.beforePrice = beforePrice;
	}
	public String getAfterPrice() {
		return afterPrice;
	}
	public void setAfterPrice(String afterPrice) {
		this.afterPrice = afterPrice;
	}
	public int getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(int readStatus) {
		this.readStatus = readStatus;
	}
	public int getFeedType() {
		return feedType;
	}
	public void setFeedType(int feedType) {
		this.feedType = feedType;
	}
}
