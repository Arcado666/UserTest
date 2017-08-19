package com.Model;

public class GetStrongWeakAgentListModel {
	private long userId; //用户Id,通过请求Header里的uticket获取
	private int cityId; //城市ID（房源所在的城市的Id）
	private int bizType; // 业务类型 1-租房 2-二手房  0全能
	private int type;// 1：默认看房顾问 2：强关系（选择看房顾问里的强关系列表，不足三个用系统推荐补足，包含默认的） 3：弱关系（咨询过的看房顾问列表） 4：强弱关系（房源分享页看房顾问列表）5：强弱关系的件数 6：系统推荐的看房顾问(房源咨询)  7:小区咨询
	private String houseId; // 房源Id，多个用逗号分隔，约看和房源咨询的时候传
	private int offset = 0; // 已看多少条
	private int pageSize = 10; // 每页显示多少行
	private int estateId;//小区id
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getBizType() {
		return bizType;
	}
	public void setBizType(int bizType) {
		this.bizType = bizType;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
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
	public int getEstateId() {
		return estateId;
	}
	public void setEstateId(int estateId) {
		this.estateId = estateId;
	}
}
