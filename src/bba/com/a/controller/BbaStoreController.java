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

import bba.com.a.arrow.StoreMapParcing;
import bba.com.a.model.Bb_StoreDto;
import bba.com.a.service.BbaStoreSerivce;

@Controller
public class BbaStoreController {
	private static final Logger logger = LoggerFactory.getLogger(BbaStoreController.class);
	
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
		
		System.out.println("bslist size: "+ bslist.size());
		for (int i = 0; i < bslist.size(); i++) {
			Bb_StoreDto bsdto = bslist.get(i);
			
			markers +="{coords:{lat:"+bsdto.getLat()+", lng:"+bsdto.getLng()
			+"},content:'"+bsdto.getName()+"', seq:'"+bsdto.getSeq()+"'}";
			if(i < bslist.size() -1) {
				markers +=",";
			}
		
		}
		System.out.println(markers);
		
		
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
		/*String latlngparser = (String)map.get("latlng");
		int latIndex  = latlngparser.indexOf(",");
		String lat = latlngparser.substring(1, latIndex);
		String lng = latlngparser.substring(latIndex+2, latlngparser.length()-1);
		System.out.println("lat:"+lat);
		System.out.println("lng:"+lng);*/
		
		String latlng[] = StoreMapParcing.getMapParcing(map);
		String lat = latlng[0];
		String lng = latlng[1];
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
		

		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("map",map);
		
		return rmap;
	}
	
	/*--------------------------------------------------------------------------------------------
	 * store 수정
	 *-------------------------------------------------------------------------------------------*/
	
	@ResponseBody
	@RequestMapping(value="updateStore.do", method=RequestMethod.POST)
	public Map<String, Object> updateStore(@RequestBody Map<String, Object> map) {
		logger.info("BbaStoreController updateStore");
		System.out.println("BbaStoreController updateStore");

		System.out.println((int)map.get("seq"));
		

		int seq = (int)map.get("seq");
		//수정할 bbs_store_Dto DB에서 가져오기 
		
		Bb_StoreDto bsdto = bbaStoreService.updateStore(seq);
		//우편번호, 도로명,지번, 디테일 나눠주기
		String address[] = bsdto.getAddress().split("#");
		System.out.println(bsdto.toString());
		
		//view로 보내기 
		map.put("seq", bsdto.getSeq());
		map.put("name", bsdto.getName());
		map.put("phone", bsdto.getPhone());
		map.put("postcode", address[0]);
		map.put("roadAddress", address[1]);
		map.put("jibunAddress", address[2]);
		map.put("detailAddress", address[3]);
		map.put("lat", bsdto.getLat());
		map.put("lng", bsdto.getLng());
		map.put("del", bsdto.getDel());
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("map",map);
		
		return rmap;
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * store 수정 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@ResponseBody
	@RequestMapping(value="updateStoreAf.do", method=RequestMethod.POST)
	public Map<String, Object> updateStoreAf(@RequestBody Map<String, Object> map) {
		logger.info("BbaStoreController updateStoreAf");
		System.out.println("BbaStoreController updateStoreAf");

		String sseq = (String)map.get("seq");
		int seq = Integer.parseInt(sseq);
		//맵 parcing
		String latlng[] = StoreMapParcing.getMapParcing(map);
		String lat = latlng[0];
		String lng = latlng[1];
		Bb_StoreDto bsdto = new Bb_StoreDto(seq, (String)map.get("name"), (String)map.get("phone"), (String)map.get("address"), lat, lng, 0);

		bbaStoreService.updateStoreAf(bsdto);
	
		
		//view로 보내기 
/*		map.put("seq", bsdto.getSeq());
		map.put("name", bsdto.getName());
		map.put("phone", bsdto.getPhone());
		map.put("postcode", address[0]);
		map.put("roadAddress", address[1]);
		map.put("jibunAddress", address[2]);
		map.put("detailAddress", address[3]);
		map.put("lat", bsdto.getLat());
		map.put("lng", bsdto.getLng());
		map.put("del", bsdto.getDel());*/
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("msg","수정완료");
		
		
		
		return rmap;
	}
	
	/*--------------------------------------------------------------------------------------------
	 * store 삭제 완료
	 *-------------------------------------------------------------------------------------------*/
	
	@ResponseBody
	@RequestMapping(value="deleteStore.do", method=RequestMethod.POST)
	public Map<String, Object> deleteStore(@RequestBody Map<String, Object> map) {
		logger.info("BbaStoreController deleteStore");
		System.out.println("BbaStoreController deleteStore");

		String sseq = (String)map.get("seq");
		int seq = Integer.parseInt(sseq);

		bbaStoreService.deleteStore(seq);
	
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("msg","삭제완료");
		
		
		
		return rmap;
	}
}
