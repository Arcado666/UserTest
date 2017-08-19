package com.Model;

import java.util.List;

public class CollectionHouseModel {
	private int enable = 1; //房源是否可用 0：不可用 1：可用
	private long estateId;//小区ID
	private long houseId; //房源ID
	private String imgUrl = ""; //照片URL
	private String estateName = "";// 小区名称
	private String rentPrice = "";//出租价格
	private String sellPrice = ""; //出售价格
	private int bedroomSum; // 几房
	private int livingRoomSum; // 几厅
	private int wcSum = 0;// 几卫
	private String houseSpace = "";//房屋面积
	private String subwayLine; // 地铁线（租房房源列表项取消发布时间字段，显示1km范围的地铁站所属的地铁线，例：1号线,4号线）
	private int rentOrSale; // 租售类型：0-租房；1-二手房
	private int videoNum; // 视频数量：0-无视频；非零-有视频
	private String videoPic = "";//视频图片URL
	private int videoType;//0是普通视频 1是全景视频
	private int aboveFiveYear; // 是否满五 0-否 ；1-是
	private int onlyOne; //是否唯一 0-否 ；1-是
	private int school; //是否学区房 0-否 ；1-是
	private int subway; //是否地铁房 0-否 ；1-是
	private int sign; //是否独家 0-否 ；1-是
	private String unitPrice; //单价
	private int readStatus; //阅读状态 1:已读 0:未读
	private String decorateType=""; //装修文案
	private String markContent="";//最新动态: 更新了图片/视频 备注:如果是价格变动 ==》》涨价16万 箭头前后的价格取beforePrice和afterPrice
	private String beforePrice; // 更新前价格
	private String afterPrice; // 更新后价格
	private String priceRange=""; // 增减幅度(如果不是更新价格则无)
	private int feedType; //动态类型(只在关注模块下有效)：1-房源新增，2-房源下架，3-房源涨价，4-房源降价,5-更新图片视频
	private List<HistoryModel> his;//历史动态
	private String floorStr="";//楼层显示:高层/共x层，中层/共x层，低层/共x层
	private String floorType2 = ""; //楼层显示:高层，中层，低层
	private String houseInvalidMemo = ""; // 房源失效说明
	private String forward="";//朝向
	private String date="";//日期
	private String tag ="";//特色标签 eg :某某时间成交 、 距地铁XX米
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	public long getEstateId() {
		return estateId;
	}
	public void setEstateId(long estateId) {
		this.estateId = estateId;
	}
	public long getHouseId() {
		return houseId;
	}
	public void setHouseId(long houseId) {
		this.houseId = houseId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getEstateName() {
		return estateName;
	}
	public void setEstateName(String estateName) {
		this.estateName = estateName;
	}
	public String getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(String rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
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
	public String getHouseSpace() {
		return houseSpace;
	}
	public void setHouseSpace(String houseSpace) {
		this.houseSpace = houseSpace;
	}
	public String getSubwayLine() {
		return subwayLine;
	}
	public void setSubwayLine(String subwayLine) {
		this.subwayLine = subwayLine;
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
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(int readStatus) {
		this.readStatus = readStatus;
	}
	public String getDecorateType() {
		return decorateType;
	}
	public void setDecorateType(String decorateType) {
		this.decorateType = decorateType;
	}
	public String getMarkContent() {
		return markContent;
	}
	public void setMarkContent(String markContent) {
		this.markContent = markContent;
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
	public String getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(String priceRange) {
		this.priceRange = priceRange;
	}
	public int getFeedType() {
		return feedType;
	}
	public void setFeedType(int feedType) {
		this.feedType = feedType;
	}
	public List<HistoryModel> getHis() {
		return his;
	}
	public void setHis(List<HistoryModel> his) {
		this.his = his;
	}
	public String getFloorStr() {
		return floorStr;
	}
	public void setFloorStr(String floorStr) {
		this.floorStr = floorStr;
	}
	public String getFloorType2() {
		return floorType2;
	}
	public void setFloorType2(String floorType2) {
		this.floorType2 = floorType2;
	}
	public String getHouseInvalidMemo() {
		return houseInvalidMemo;
	}
	public void setHouseInvalidMemo(String houseInvalidMemo) {
		this.houseInvalidMemo = houseInvalidMemo;
	}
	public String getForward() {
		return forward;
	}
	public void setForward(String forward) {
		this.forward = forward;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
}
