package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class AppointmentHouseRequest extends DemoCommon{
	/**
	 * 房源约看
	 * @param userId
	 * @param uticket
	 * @param username   //用户称呼bizType
	 * @param gender  //性别 1：男，2：女 3:保密
	 * @param appointmentTime   //约看时间
	 * @param houseIds    约看房屋ID 多个用“,"半角逗号隔开
	 * @param city   //城市名称eg：北京，上海，广州，深圳
	 * @param rentOrSales    // 0 租房  1 二手房   3  品牌公寓约看  （品牌公寓不需要传经纪人相关信息 ）
	 * @param agentId   //经纪人Id
	 * @param relationType    // 关系类型  1-推荐的经纪人；3-强弱关系
	 * @param isCloseDisturb   // 是否关闭免打扰约看 0：否，1：是
	 * @param phone     //手机号码
	 * @return
	 */
	public String getAppointmentHouseResponse(String userId,String uticket,String username,String gender,String appointmentTime,String houseIds,String city,String rentOrSales
			,String agentId,String relationType ,String isCloseDisturb,String phone){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("userId", userId);
			pars.put("username", username);
			pars.put("gender", gender);
			pars.put("appointmentTime", appointmentTime);
			pars.put("houseIds", houseIds);
			pars.put("city", city);
			pars.put("rentOrSales", rentOrSales);
			pars.put("agentId", agentId);
			pars.put("relationType ", relationType );
			pars.put("isCloseDisturb", isCloseDisturb);
			pars.put("phone", phone);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/seekHouse/appointmentHouse.rest", pars);
	}
	public static void main(String[] args) {

		System.out.println();
	}

}
