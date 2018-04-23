package bba.com.a.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bba.com.a.arrow.StoreMapParcing;
import bba.com.a.model.Bb_AdminDto;
import bba.com.a.model.Bb_MemberDto;
import bba.com.a.model.Bb_StoreDto;
import bba.com.a.service.BbaMemberSerivce;
import bba.com.a.service.BbaStoreSerivce;

@Controller
public class BbaMemberController {
	private static final Logger logger = LoggerFactory.getLogger(BbaMemberController.class);
	
	@Autowired
	BbaMemberSerivce bbMemberService;
	
	@Autowired
	BbaStoreSerivce bbaStoreService;
	
	



	
	/*--------------------------------------------------------------------------------------------
	 * 사원등록으로 이동 
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="adminplus.do", method=RequestMethod.GET)
	public String adminplus(Model model) {
		logger.info("BbaMemberController adminplus");
		

		List<Bb_StoreDto> bslist = bbaStoreService.GetStoreList();
		
		//위에 현재 위치 나타내줌 
		model.addAttribute("bslist", bslist);
		
		model.addAttribute("doc_title", "사원관리");
		model.addAttribute("doc_menu", "멤버관리");
		
		return "adminplus.tiles";
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 아이디 중복 체크
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value="getAdminID.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String getID(Model model, Bb_AdminDto adminDto) {
		logger.info("BbaMemberController getID");	
		
		int count = bbMemberService.getAdminID(adminDto);
		
		if(count > 0) {
			return "F";
		}else {
			return "S";
		}
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 사원등록 버튼 클릭 후 DB저장
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value = "adminplusAf.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String  adminplusAf(@RequestParam(value="name", required=true) List<String> name, 
	Bb_AdminDto adminDto, Model model) throws Exception {
		
		logger.info("BbaMemberController adminplusAf!");
		
		logger.info((String)adminDto.getName()); 			//이름
		logger.info((String)adminDto.getId()); 				//id
		logger.info((String)adminDto.getPassword()); 		//pwd
		logger.info((String)adminDto.getPhone());			//phone
		
		
		String conName ="";

			conName += name.get(1);
			conName += name.get(0);

		System.out.println("conName : " +conName);
		System.out.println("등록 된 스토어 코드 : " + adminDto.getStore_seq());
		adminDto.setName(conName);
		bbMemberService.addAdmin(adminDto);
		
		model.addAttribute("doc_title", "사원등록");
		model.addAttribute("doc_menu", "멤버관리");
		
		return "redirect:/adminlist.do";
		
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 사원 리스트 불러오기
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value = "adminlist.do", 
			method = {RequestMethod.POST,RequestMethod.GET})
	public String adminList(HttpServletRequest request, Model model) throws Exception {
		logger.info("Welcome BbaMemberController adminList! "+ new Date());
		
		/*private int seq;			// 시퀀스
		private String id;			// id
		private String password;	// 비밀번호
		private String name;		// 매니저 이름
		private String phone;		// 전화번호
		private int store_seq;	// 지점 시퀀스 가져오기
		private int del;			// 기본 0 , 삭제된 정보 1
*/		
		List<Bb_AdminDto> aList = bbMemberService.getAdminList();
		model.addAttribute("aList", aList);
		//model.addAttribute("year", adminparam.getYear());
		//model.addAttribute("month", adminparam.getMonth());
		
		//점포 dto 가져오기
		List<Bb_StoreDto> bslist = bbaStoreService.GetStoreList();
		model.addAttribute("bslist", bslist);		//store list
		
		for (int i = 0; i < bslist.size(); i++) {
			System.out.println("bslist의 점포 이름 :  " + bslist.get(i).getName());
		}
		
			
		model.addAttribute("doc_title", "사원관리");
		model.addAttribute("doc_menu", "멤버관리");
		
		return "adminlist.tiles";
	}
	
	
	
	/*--------------------------------------------------------------------------------------------
	 * 해당 시퀀스의 점포 DTO 가져오기
	 *-------------------------------------------------------------------------------------------*/
	/*SELECT SEQ, NAME, PHONE, ADDRESS, LAT, LNG, DEL
	FROM BB_STORE
	WHERE SEQ=1;*/
	@ResponseBody
	@RequestMapping(value= "getStoreName.do", method={RequestMethod.GET, RequestMethod.POST})
	public Bb_StoreDto getStoreName(@RequestParam("seq") int seq, 
			HttpServletRequest request, Model model)  {

		System.out.println("getStoreName seq 번호 : " + seq);
		
		Bb_StoreDto storeDto = bbMemberService.getStoreName(seq);
		
		model.addAttribute("storeDto", storeDto);
		
		
	    return storeDto;
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 사원 정보 삭제하기 
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value= "deladmin.do", method={RequestMethod.GET, RequestMethod.POST})
	public List<Bb_AdminDto> deladmin(@RequestParam("seq") int seq, 
			HttpServletRequest request, Model model)  {

		System.out.println("delAdmin seq 번호 : " + seq);
		bbMemberService.delAdmin(seq);
		List<Bb_AdminDto> aList = null;
		try {
			aList = bbMemberService.getAdminList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("aList", aList);
		
		for (int i = 0; i < aList.size(); i++) {
			System.out.println("aList : " + aList.get(i).getId());
		}
	    //SocialPerson person = dao.deladmin(seq);
	    return aList;
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 사원 정보 회복하기
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value= "recoveryAdmin.do", method={RequestMethod.GET, RequestMethod.POST})
	public List<Bb_AdminDto> recoveryAdmin(@RequestParam("seq") int seq, 
			HttpServletRequest request, Model model)  {

		System.out.println("recoveryAdmin seq 번호 : " + seq);
		bbMemberService.recoveryAdmin(seq);
		List<Bb_AdminDto> aList = null;
		try {
			aList = bbMemberService.getAdminList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("aList", aList);
		
		for (int i = 0; i < aList.size(); i++) {
			System.out.println("aList : " + aList.get(i).getId());
		}
	    //SocialPerson person = dao.deladmin(seq);
	    return aList;
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 사원 정보 수정하기 (디테일 보기)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value="updateAdmin.do", method={RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> updateAdmin(@RequestBody Map<String, Object> map, Model model) {
		logger.info("BbaMemberController updateAdmin");
		System.out.println("BbaMemberController updateAdmin");

		System.out.println((int)map.get("seq"));

		int seq = (int)map.get("seq");
		
		//DB에서 가져오기 
		Bb_AdminDto admindto = bbMemberService.updateAdmin(seq);
		
		/*SEQ NUMBER(10) PRIMARY KEY,
		ID VARCHAR2(20) UNIQUE,
		PASSWORD VARCHAR2(20) NOT NULL,
		NAME VARCHAR2(20) NOT NULL,
		PHONE VARCHAR2(20) NOT NULL,
		STORE_SEQ NUMBER(10) NOT NULL,
		DEL NUMBER(1) NOT NULL*/
		
		List<Bb_StoreDto> bslist = bbaStoreService.GetStoreList();
		
		String store_name ="";
		for(int i=0; i<bslist.size(); i++) {
			if(bslist.get(i).getSeq()==admindto.getStore_seq()) {
				store_name = bslist.get(i).getName();
			}
		}
		
		//view로 보내기 
		map.put("seq", admindto.getSeq());
		map.put("id", admindto.getId());
		map.put("password", admindto.getPassword());
		map.put("name", admindto.getName());
		map.put("phone", admindto.getPhone());
		map.put("store_seq", admindto.getStore_seq());
		map.put("store_name", store_name);
		map.put("store_list", bslist);
		map.put("del", admindto.getDel());
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("map",map);
		
		model.addAttribute("bslist", bslist);
		
		return rmap;
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 사원 수정 완료
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value="updateAdminAf.do", method=RequestMethod.POST)
	public Map<String, Object> updateStoreAf(@RequestBody Map<String, Object> map) {
		logger.info("BbaMemberController updateAdminAf");
		System.out.println("BbaMemberController updateAdminAf");
		
		String sseq = (String)map.get("seq");
		System.out.println("updateAdminAf seq : " + sseq);
		int seq = Integer.parseInt(sseq);
		
		/*SEQ NUMBER(10) PRIMARY KEY,
		ID VARCHAR2(20) UNIQUE,
		PASSWORD VARCHAR2(20) NOT NULL,
		NAME VARCHAR2(20) NOT NULL,
		PHONE VARCHAR2(20) NOT NULL,
		STORE_SEQ NUMBER(10) NOT NULL,
		DEL NUMBER(1) NOT NULL*/
		
		String store = (String)map.get("store_seq");
		int store_seq = Integer.parseInt(store);
		
		
		Bb_AdminDto admindto = new Bb_AdminDto(
				seq, 
				(String)map.get("id"), 
				(String)map.get("password"), 
				(String)map.get("name"), 
				(String)map.get("phone"), 
				store_seq, 
				0);

		bbMemberService.updateAdminAf(admindto);
		
		List<Bb_StoreDto> bslist = bbaStoreService.GetStoreList();
		
		String store_name ="";
		for(int i=0; i<bslist.size(); i++) {
			if(bslist.get(i).getSeq()==store_seq) {
				store_name = bslist.get(i).getName();
			}
		}
		
		map.put("store_name", store_name);
	
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("map",map);
		
		return rmap;
	}
	
	
	
	
	
	
	
	
	/*--------------------------------------------------------------------------------------------
	 * 고객 관리로 이동 
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="customerlist.do", method = {RequestMethod.POST,RequestMethod.GET})
	public String customerlist(HttpServletRequest request, Model model) throws Exception {
		logger.info("BbaMemberController customerlist");
		
		
		List<Bb_MemberDto> cList = bbMemberService.getCustomerList();
		model.addAttribute("cList", cList);
		
		model.addAttribute("doc_title", "고객관리");
		model.addAttribute("doc_menu", "멤버관리");
		
		return "customerlist.tiles";
	}
	



	/*--------------------------------------------------------------------------------------------
	 * 고객 정보 삭제하기 
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value= "delCustomer.do", method={RequestMethod.GET, RequestMethod.POST})
	public List<Bb_MemberDto> delCustomer(@RequestParam("seq") int seq, 
			HttpServletRequest request, Model model)  {

		System.out.println("delCustomer seq 번호 : " + seq);
		bbMemberService.delCustomer(seq);
		List<Bb_MemberDto> cList = null;
		try {
			cList = bbMemberService.getCustomerList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("cList", cList);
		
		for (int i = 0; i < cList.size(); i++) {
			System.out.println("cList : " + cList.get(i).getId());
		}
	    //SocialPerson person = dao.deladmin(seq);
	    return cList;
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 고객 정보 수정하기 (디테일 보기)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value="updateCustomer.do", method={RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> updateCustomer(@RequestBody Map<String, Object> map) {
		logger.info("BbaMemberController updateCustomer");
		System.out.println("BbaMemberController updateCustomer");

		System.out.println((int)map.get("seq"));

		int seq = (int)map.get("seq");
		
		//DB에서 가져오기 
		Bb_MemberDto customerDto = bbMemberService.updateCustomer(seq);
		
		/*
		 *  SEQ NUMBER(10) PRIMARY KEY,
			ID VARCHAR2(20) NOT NULL,
			PASSWORD VARCHAR2(20) NOT NULL,
			BDAY VARCHAR2(20) NOT NULL,
			NAME VARCHAR2(20) NOT NULL,
			PHONE VARCHAR2(20) NOT NULL,
			SEX NUMBER(1) NOT NULL,
			MILEAGE NUMBER(10) NOT NULL,
			GRADE NUMBER(10) NOT NULL,
			EXP NUMBER(10) NOT NULL,
			DEL NUMBER(1) NOT NULL*/
		
		//view로 보내기 
		map.put("seq", customerDto.getSeq());
		map.put("id", customerDto.getId());
		map.put("password", customerDto.getPassword());
		map.put("bday", customerDto.getBday());
		map.put("name", customerDto.getName());
		map.put("phone", customerDto.getPhone());
		map.put("sex", customerDto.getSex());
		map.put("mileage", customerDto.getMileage());
		map.put("grade", customerDto.getGrade());
		map.put("exp", customerDto.getExp());
		map.put("del", customerDto.getDel());
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("map",map);
		
		return rmap;
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 고객 수정 완료
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value="updateCustomerAf.do", method=RequestMethod.POST)
	public Map<String, Object> updateCustomerAf(@RequestBody Map<String, Object> map) {
		logger.info("BbaMemberController updateCustomerAf");
		System.out.println("BbaMemberController updateCustomerAf");
		
		String sseq = (String)map.get("seq");
		sseq = sseq.replaceAll("(^\\p{Z}+|\\p{Z}+$)", "");
		System.out.println("updateCustomerAf seq : " + sseq);
		int seq = Integer.parseInt(sseq);
		

		String ssex = (String)map.get("sex");
		int sex = Integer.parseInt(ssex);
		
		String mmileage = (String)map.get("mileage");
		int mileage = Integer.parseInt(mmileage);
		
		String ggrade = (String)map.get("grade");
		int grade = Integer.parseInt(ggrade);
		
		String eexp = (String)map.get("exp");
		int exp= Integer.parseInt(eexp);
		
		
		String phon = (String)map.get("phone");
		phon = phon.replaceAll("(^\\p{Z}+|\\p{Z}+$)", "");
		
		Bb_MemberDto customerDto = new Bb_MemberDto(
				seq, 
				(String)map.get("id"), 
				(String)map.get("password"), 
				(String)map.get("bday"), 
				(String)map.get("name"), 
				phon, 
				sex,
				mileage,
				grade,
				exp, 
				0);

		bbMemberService.updateCustomerAf(customerDto);
		
		map.put("seq", customerDto.getSeq());
		map.put("id", customerDto.getId());
		map.put("password", customerDto.getPassword());
		map.put("bday", customerDto.getBday());
		map.put("name", customerDto.getName());
		map.put("phone", customerDto.getPhone());
		map.put("sex", customerDto.getSex());
		map.put("mileage", customerDto.getMileage());
		map.put("grade", customerDto.getGrade());
		map.put("exp", customerDto.getExp());
		map.put("del", customerDto.getDel());
	
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("map",map);
		
		return rmap;
	}
	
	
	
	
	

}













