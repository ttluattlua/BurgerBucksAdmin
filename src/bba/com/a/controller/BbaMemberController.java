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

import bba.com.a.model.Bb_AdminDto;
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
	 * 사원등록 버튼 클릭 후 DB저장
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value = "adminplusAf.do", 
			method= {RequestMethod.GET, RequestMethod.POST})
	public String  adminplusAf(@RequestParam(value="name", required=true) List<String> name, 
	Bb_AdminDto adminDto, Model model) throws Exception {
		
		logger.info("**  BbaMemberController adminplusAf!");
		
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
		
		return "adminlist.tiles";
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













