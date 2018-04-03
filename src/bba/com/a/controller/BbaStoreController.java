package bba.com.a.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bba.com.a.model.Bb_StoreDto;
import bba.com.a.service.BbaStoreSerivce;

@Controller
public class BbaStoreController {
	private static final Logger logger = LoggerFactory.getLogger(BbaMemberController.class);
	
	@Autowired
	BbaStoreSerivce bbaStoreService;
	
	
	/*--------------------------------------------------------------------------------------------
	 * store 관리 페이지로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="storelist.do", method=RequestMethod.GET)
	public String storelist(Model model) {
		logger.info("BbaStoreController storelist.do");
		
		List<Bb_StoreDto> bslist = bbaStoreService.GetStoreList();
		String markers="";
		

		for (int i = 0; i < bslist.size(); i++) {
			Bb_StoreDto bsdto = bslist.get(i);
			markers +="{coords:{lat:"+bsdto.getLat()+", lng:"+bsdto.getLng()
			+"},content:'<h1>"+bsdto.getName()+"</h1>'}";
			if(i != bslist.size() -1) {
				markers +=",";
			}
		}
		System.out.println(markers);
		
		model.addAttribute("marker", "{coords:{lat:35.7940063, lng:128.48197240000002},content:'<h1>qwe</h1>'}");
		//위에 현재 위치 나타내줌 
		model.addAttribute("doc_title", "스토어관리");
		model.addAttribute("doc_menu", "스토어관리");
		model.addAttribute("bslist", bslist);
		model.addAttribute("markers", markers);
		return "storelist.tiles";
	}

	
	/*--------------------------------------------------------------------------------------------
	 * store 새로 등록 
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value="registerStore.do", method=RequestMethod.POST)
	public  Map<String, Object> registerStore(@RequestBody Map<String, Object> map) {
		logger.info("BbaStoreController registerStore");
		
		logger.info((String)map.get("name")); 			//지점명 
		logger.info((String)map.get("phone")); 			//전화번호
		logger.info((String)map.get("address")); 		//주소 
		logger.info((String)map.get("latlng"));			//위도,경도
		System.out.println("latlng: " + map.get("latlng"));
		
		//(32.123, 234.123) > 32.123 , 234.123 각각 으로 파싱해주기 (DTO에 넣기위해)
		String latlngparser = (String)map.get("latlng");
		int latIndex  = latlngparser.indexOf(",");
		String lat = latlngparser.substring(1, latIndex);
		String lng = latlngparser.substring(latIndex+2, latlngparser.length()-1);
		System.out.println("lat:"+lat);
		System.out.println("lng:"+lng);
		//DTO에 스토어 정보 입력 
		Bb_StoreDto bsdto = new Bb_StoreDto(0, (String)map.get("name"), (String)map.get("phone"), 
				(String)map.get("address"), lat, lng, 0);
		
		//입력하고 시퀀스받아오기
		int seq = bbaStoreService.registerStore(bsdto);
		/*
		//다시보낼때는 주소 #로 묶어준거 빼줌
		map.put("address", ((String)map.get("address")).replace("#", " "));*/
		//시퀀스도 보내줌 
		map.put("seq", seq);
		
/*		
		------------------------------------------------------------------------------------------------------
		 * addMarker로 등록된 마커 표시 해줘야함 해당 스토어 정보 lat, lng, name을 
		 *	{coords:{lat:42.4668, lng:-70.9495},
		 *	iconImage:'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
		 *	content:'<h1>lynn Ma</h1>'
		 *	}
		*---------------------------------------------------------------------------------------------------------
		
		map.put("maps", (String)map.get("latlng"));
		String latlng =((String)map.get("latlng")).replace("(", "{coords:{lat:");
		System.out.println("latlng수정1: "+latlng);
		latlng =latlng.replace(", ", ", lng:");
		System.out.println("latlng수정2: "+latlng);
		latlng =latlng.replace(")", "},content:'<h1>"+map.get("name")+"</h1>'}");
		System.out.println("latlng수정3: "+latlng);
		map.put("latlng", latlng);*/
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("map",map);
		
		return rmap;
	}
	
	/*--------------------------------------------------------------------------------------------
	 * store 수정
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value="updateStore.do", method=RequestMethod.POST)
	public String updateStore(Model model) {
		logger.info("BbaStoreController registerStore");
		
		
		
		
		//위에 현재 위치 나타내줌 
		model.addAttribute("doc_title", "스토어관리");
		model.addAttribute("doc_menu", "스토어관리");
		return "storelist.tiles";
	}
}
