package bba.com.a.controller;

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
import bba.com.a.model.Bb_StoreDto;
import bba.com.a.service.BbaMemberSerivce;

@Controller
public class BbaMemberController {
	private static final Logger logger = LoggerFactory.getLogger(BbaMemberController.class);
	
	@Autowired
	BbaMemberSerivce bbMemberService;
	
	/*--------------------------------------------------------------------------------------------
	 * 로그인후 메인
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(Model model) {
		logger.info("BbaMemberController login");
		return "home.tiles";
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 사원등록으로 이동 
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="adminplus.do", method=RequestMethod.GET)
	public String adminplus(Model model) {
		logger.info("BbaMemberController adminplus");
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
		adminDto.setName(conName);
		bbMemberService.addAdmin(adminDto);
		
		model.addAttribute("doc_title", "사원등록");
		model.addAttribute("doc_menu", "사원등록");
		
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
		
		model.addAttribute("doc_title", "사원관리");
		model.addAttribute("doc_menu", "사원관리");
		
		return "adminlist.tiles";
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
	 * 사원 정보 수정하기 (디테일 보기)
	 *-------------------------------------------------------------------------------------------*/
	@ResponseBody
	@RequestMapping(value="updateAdmin.do", method=RequestMethod.POST)
	public Map<String, Object> updateAdmin(@RequestBody Map<String, Object> map) {
		logger.info("BbaMemberController updateAdmin");
		System.out.println("BbaMemberController updateAdmin");

		System.out.println((int)map.get("seq"));

		int seq = (int)map.get("seq");
		
		//DB에서 가져오기 
		Bb_AdminDto admindto = bbMemberService.updateadmin(seq);
		
		/*SEQ NUMBER(10) PRIMARY KEY,
		ID VARCHAR2(20) UNIQUE,
		PASSWORD VARCHAR2(20) NOT NULL,
		NAME VARCHAR2(20) NOT NULL,
		PHONE VARCHAR2(20) NOT NULL,
		STORE_SEQ NUMBER(10) NOT NULL,
		DEL NUMBER(1) NOT NULL*/
		
		//view로 보내기 
		map.put("seq", admindto.getSeq());
		map.put("id", admindto.getId());
		map.put("password", admindto.getPassword());
		map.put("name", admindto.getName());
		map.put("phone", admindto.getPhone());
		map.put("store_seq", admindto.getStore_seq());
		map.put("del", admindto.getDel());
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("map",map);
		
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

		bbMemberService.updateadminAf(admindto);
	
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("msg","수정완료");
		
		return rmap;
	}
	
	
	/*--------------------------------------------------------------------------------------------
	 * 고객관리로 이동 
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="customerlist.do", method=RequestMethod.GET)
	public String customerlist(Model model) {
		logger.info("BbaMemberController customerlist");
		return "customerlist.tiles";
	}
	
	

}













