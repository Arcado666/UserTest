package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class CalcHousePriceRequest extends DemoCommon{
	/**
	 * 查房价接口(From6.0)
	 * @param estateId   //小区id ，必要字段
	 * @param bedroomSum    //室，必要字段
	 * @param livingRoomSum   //厅 ，必要字段
	 * @param bathRoomSum  //卫，必要字段
	 * @param layer  //当前楼层高度，必要字段 eg.1、2、23
	 * @param layers    //总楼层，必要字段 
	 * @param houseType   //房源类型，1是住宅 2是别墅 默认1
	 * @param keeyYear   //持有年限，默认无 5：满五（同时选了满五，满二，处理成满五）,2满二,0 默认0
	 * @param constructDate    //建造年限，默认无 五年以下处理成5,5-10 处理成10 ，10-20 处理成20 ，20以上 处理成30
	 * @param decorateType  //装修，默认无 精装修为4，默认2
	 * @param ventilation   //朝向，默认无 东南西北对应1234，如东西对应13，南北对应24，东对应1等等。
	 * @param spaceArea    //面积，必要字段 
	 * @param elevator     //是否有电梯，1-有 0-无
	 * @return
	 */
	public String getCalcHousePriceResponse(String estateId,String bedroomSum,String livingRoomSum,String bathRoomSum,String layer,String layers,String houseType
			,String keeyYear,String constructDate,String decorateType,String ventilation,String spaceArea,String elevator){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("estateId", estateId);
			pars.put("bedroomSum", bedroomSum);
			pars.put("livingRoomSum", livingRoomSum);
			pars.put("bathRoomSum", bathRoomSum);
			pars.put("layer", layer);
			pars.put("layers", layers);
			pars.put("houseType", houseType);
			pars.put("keeyYear", keeyYear);
			pars.put("constructDate", constructDate);
			pars.put("decorateType", decorateType);
			pars.put("ventilation", ventilation);
			pars.put("spaceArea", spaceArea);
			pars.put("elevator", elevator);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/housePrice/calcHousePrice.rest", pars);
	}
	public static void main(String[] args) {

		System.out.println(new CalcHousePriceRequest().getCalcHousePriceResponse("9023", "1", "0", "1", "3", "12", "", "", "", "", "", "60", "1"));
	}

}
