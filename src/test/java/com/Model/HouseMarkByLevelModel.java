package com.Model;

public class HouseMarkByLevelModel {
	private int offset = 0;// 已看多少条
	private int pageSize;// 每页显示多少行
	private int level;// 地图层级
	private double lat;// 纬度
	private double lon;// 经度
	private String geoHash;// 经纬度GeoHash
	private String city = "2";// 城市ID：上海 如果在地铁模块检索数据,参数为城市在地铁表里的代码 eg.上海：2；北京12438
	private String area;// 区域:浦东
	private int areaId;// 区域ID，选择了区域或板块时传它们的id
	private int subwayNo;// 地铁线id
	private int stationId; // 地铁站id
	private int sequence;// 列表排序 1:时间 2:价格低-高3：价格高-低 4：距离
	private long userId;
	private int tag;
	private int room; // 卧室
	private int rooms;// 用于过滤房源的房间数目
	private String roomArray;// 用于过滤房源的房间数目
	private String[] latlonArray;// 屏幕四个角的坐标
									// 数组格式：{"纬度,经度"(topleft),"纬度2,经度2"(topright),"纬度3,经度3"(bottomright),"纬度4,经度4(bottomleft)"}
	private int rentOrSale; // 租售类型：0-租房；1-二手房 2新房 3品牌公寓
	private int lowSpace; // 面积区间-最小面积
	private int highSpace; // 面积区间-最大面积
	private int aboveFiveYear; // 是否满五 0-否 ；1-是
	private int onlyOne; // 是否唯一 0-否 ；1-是
	private int school; // 是否学区房 0-否 ；1-是
	private int subway; // 是否地铁房 0-否 ；1-是
	private int flag; // 标志位，用于附加状态的传递，不同接口意义不同（地图页-【初始状态：0；其他：1】）
	private int houseAge; // 1：2年以下 ; 2：2-5年; 3：5-10年 ; 4：10年以上 ;（v5.2以前使用）
	private int houseAges; // 房龄 1111 个位数的1：5年以下 、十分位的1：5-10年、 百分位的1：10-20年 、
							// 千分位的1：20年以上
	private int floors; // 楼层111 个位数的1：低层、十分位的1：中层、百分位的1：高层
	private int isElevator; // 是否电梯房 1：是，0：否
	private int decorateTypes;// 装修 个位数1：毛坯，十分位10：简装，100：精装，1000：豪装，多选则相加
	private int decorateType;// 装修 1 毛坯，2 装修,3简装,4精装,5豪装
	private String key = ""; // 搜索关键字
	private int tipsType = -1; // 搜索tips类型 0地铁站 1区域板块 2小区 3小区别名 4小区地址
								// （若为地铁站时，请将地铁站id赋给areaId），若不知是什么类型时，请传-1
	private int bandRentBlockLevel = 14; // 品牌公寓板块默认层级
	private int bandRentEstateLevel = 17;// 品牌公寓小区默认层级
	private int rentOrBrand; // 普租或者品牌公寓：1普租 2品牌公寓 6.6新增
	private int rentType; // 品牌公寓类型：1合租 2整租 6.6新增
	private int isActivity; // 1有优惠 6.7新增
	private int sort = 0;//0默认 1 发布时间排序  2总价高-低 3总价低-高 4单价高-低 5 单价低-高
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
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
	public String getGeoHash() {
		return geoHash;
	}
	public void setGeoHash(String geoHash) {
		this.geoHash = geoHash;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public int getSubwayNo() {
		return subwayNo;
	}
	public void setSubwayNo(int subwayNo) {
		this.subwayNo = subwayNo;
	}
	public int getStationId() {
		return stationId;
	}
	public void setStationId(int stationId) {
		this.stationId = stationId;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
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
	public String[] getLatlonArray() {
		return latlonArray;
	}
	public void setLatlonArray(String[] latlonArray) {
		this.latlonArray = latlonArray;
	}
	public int getRentOrSale() {
		return rentOrSale;
	}
	public void setRentOrSale(int rentOrSale) {
		this.rentOrSale = rentOrSale;
	}
	public int getLowSpace() {
		return lowSpace;
	}
	public void setLowSpace(int lowSpace) {
		this.lowSpace = lowSpace;
	}
	public int getHighSpace() {
		return highSpace;
	}
	public void setHighSpace(int highSpace) {
		this.highSpace = highSpace;
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getHouseAge() {
		return houseAge;
	}
	public void setHouseAge(int houseAge) {
		this.houseAge = houseAge;
	}
	public int getHouseAges() {
		return houseAges;
	}
	public void setHouseAges(int houseAges) {
		this.houseAges = houseAges;
	}
	public int getFloors() {
		return floors;
	}
	public void setFloors(int floors) {
		this.floors = floors;
	}
	public int getIsElevator() {
		return isElevator;
	}
	public void setIsElevator(int isElevator) {
		this.isElevator = isElevator;
	}
	public int getDecorateTypes() {
		return decorateTypes;
	}
	public void setDecorateTypes(int decorateTypes) {
		this.decorateTypes = decorateTypes;
	}
	public int getDecorateType() {
		return decorateType;
	}
	public void setDecorateType(int decorateType) {
		this.decorateType = decorateType;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getTipsType() {
		return tipsType;
	}
	public void setTipsType(int tipsType) {
		this.tipsType = tipsType;
	}
	public int getBandRentBlockLevel() {
		return bandRentBlockLevel;
	}
	public void setBandRentBlockLevel(int bandRentBlockLevel) {
		this.bandRentBlockLevel = bandRentBlockLevel;
	}
	public int getBandRentEstateLevel() {
		return bandRentEstateLevel;
	}
	public void setBandRentEstateLevel(int bandRentEstateLevel) {
		this.bandRentEstateLevel = bandRentEstateLevel;
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
	public int getIsActivity() {
		return isActivity;
	}
	public void setIsActivity(int isActivity) {
		this.isActivity = isActivity;
	}
	
}
