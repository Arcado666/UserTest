package com.Demo;

import java.util.HashMap;
import java.util.Map;

import com.Common.DemoCommon;
import com.Common.UserCommon;
import com.Model.SearchRequestModel;
import com.qiang.httpClient.HttpPostClient;
import com.qiang.utils.MapOfValueIsNotNull;

public class KeywordServiceRequest extends DemoCommon{
	/**
	 *  热门搜索结果
	 * @param searchRequestModel
	 * @param uticket
	 * @return
	 */
	public String getKeywordServiceResponse(SearchRequestModel searchRequestModel,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("city", searchRequestModel.getCity());
//			pars.put("key", searchRequestModel.getKey());
//			pars.put("lowPrice", searchRequestModel.getLowPrice());
//			pars.put("highPrice", searchRequestModel.getHighPrice());
//			pars.put("room", searchRequestModel.getRoom());
//			pars.put("decorate", searchRequestModel.getDecorate());
//			pars.put("inhouse", searchRequestModel.getInhouse());
//			pars.put("offset", searchRequestModel.getOffset());
//			pars.put("pageSize", searchRequestModel.getPageSize());
//			pars.put("sequence", searchRequestModel.getSequence());
//			pars.put("lat", searchRequestModel.getLat());
//			pars.put("lon", searchRequestModel.getLon());
//			pars.put("level", searchRequestModel.getLevel());
//			pars.put("areaId", searchRequestModel.getAreaId());
//			pars.put("tag", searchRequestModel.getTag());
//			pars.put("rooms", searchRequestModel.getRooms());
//			pars.put("roomArray", searchRequestModel.getRoomArray());
//			pars.put("block ", searchRequestModel.getBlock());
//			pars.put("latlonArray", searchRequestModel.getLatlonArray());
//			pars.put("distance", searchRequestModel.getDistance());
//			pars.put("subwayLineId", searchRequestModel.getSubwayLineId());
			pars.put("rentOrSale", searchRequestModel.getRentOrSale());
			pars.put("isHot", searchRequestModel.getIsHot());
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(new MapOfValueIsNotNull().getNewMap(pars),new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/Search/keywordService.rest", pars);
	}
	/**
	 * 搜索Tips
	 * @param searchRequestModel
	 * @param uticket
	 * @return
	 */
	public String getKeywordServiceResponse2(SearchRequestModel searchRequestModel,String uticket){
		setDemoCommon();
		HttpPostClient httpPostClient = new HttpPostClient();
		httpPostClient.setHeader("uticket", uticket);
		 Map<String, Object> pars = new HashMap<String, Object>();
			pars.put("city", searchRequestModel.getCity());
			pars.put("key", searchRequestModel.getKey());
			pars.put("rentOrSale", searchRequestModel.getRentOrSale());
		httpPostClient.setHeader("App-Secret", httpPostClient.paraMd5(new MapOfValueIsNotNull().getNewMap(pars),new UserCommon().getOs()));
		return HttpPostClient.sendHttpPostJson("http://"+DemoCommon.url+"/ihouse/Search/keywordService.rest", pars);
	}
}
