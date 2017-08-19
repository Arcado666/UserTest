package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.qiang.httpClient.HttpPostClient;

public class CollectionNewHouseLayoutRequest extends DemoCommon{
	/**
	 * 添加新房户型关注
	 * @param houseId  //房源ID
	 * @param uticket
	 * @param layoutId  //户型ID
	 * @return
	 */
	public String getCollectionNewHouseLayoutResponse(String houseId,String uticket,String layoutId,String estateId){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("houseId", houseId);
			pars.put("layoutId", layoutId);
			pars.put("estateId", estateId);
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(pars,new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/collection/addNewHouseLayoutCollect.rest", pars);
	}
	public static void main(String[] args) {
		System.out.println(new CollectionNewHouseLayoutRequest().getCollectionNewHouseLayoutResponse("181", "UmdjSUtSOVFtTEElQCUxNTMyMzBjYmE4NGMzYzdjYmQ2MTQxY2ZjZDUwNTQyYw==", "2","9"));

	}

}
