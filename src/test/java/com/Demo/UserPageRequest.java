package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;
import com.qiang.utils.CommonUtils;

public class UserPageRequest extends DemoCommon{
	/**
	 * 看房日程（From v6.1）
	 * @param status     //0预约中 1待看房 2 待评价 3已结束
	 * @param uticket
	 * @param pageSize  //每次加载20条数据
	 * @param offset  /数据偏移量
	 * @param getAllNum   是否查询所有状态数目（查询数目较耗时 首次加载后可不查询） 1是 0否
	 * @param agentId    //经纪人ID     6.5根据经纪人查询预约列表需要经纪人id
	 * @return
	 */
	public String getUserPageResponse(String userId,String status,String uticket,String pageSize ,String offset ,String getAllNum ,String agentId){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("status", status);
			pars.put("pageSize", pageSize);
			pars.put("offset", offset );
			pars.put("getAllNum", getAllNum );
			pars.put("agentId", agentId );
			pars.put("userId", userId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/schedule/getSchedules4Status.rest", pars);
	}
	public static void main(String[] args) {
		System.out.println(CommonUtils.parseJson("scheduleHouseGroup", new UserPageRequest().getUserPageResponse("318936","", "UmdjSUtSOVFtTEElQCUxNTMyMzBjYmE4NGMzYzdjYmQ2MTQxY2ZjZDUwNTQyYw==", "", "", "", "")));
	}

}
