package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class DeleteCollectionNewHouseLayoutRequest extends DemoCommon{
	/**
	 * 取消新房户型关注
	 * @param layoutId
	 * @param houseId   //房源ID
	 * @param uticket   //户型ID
	 * @return
	 */
	public String getDeleteCollectionNewHouseLayoutResponse(String layoutId,String houseId,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("houseId", houseId);
			pars.put("layoutId", layoutId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/collection/deleteCollectionNewHoueseLayout.rest", pars);
	}
	public static void main(String[] args) {
		System.out.println(new DeleteCollectionNewHouseLayoutRequest().getDeleteCollectionNewHouseLayoutResponse( "2","181", "UmdjSUtSOVFtTEElQCUxNTMyMzBjYmE4NGMzYzdjYmQ2MTQxY2ZjZDUwNTQyYw=="));

	}

}
