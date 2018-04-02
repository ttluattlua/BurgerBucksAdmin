package bba.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
	 * 지점관리자로 이동 
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="adminlist.do", method=RequestMethod.GET)
	public String adminlist(Model model) {
		logger.info("BbaMemberController adminlist");
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

	
	/*--------------------------------------------------------------------------------------------
	 * 사원등록 버튼 클릭 후 DB저장
	 *-------------------------------------------------------------------------------------------*/
	/*@RequestMapping(value = "adminplusAf.do", 
			method = RequestMethod.POST)
	public String bbswriteAf(BbsDto bbs, Model model) throws Exception {
		if(bbs.getContent().equals("") || bbs.getTitle().equals("")){
			return "adminplus";
		}
		logger.info("Welcome SistMemberController bbswriteAf! "+ new Date());
		khBbsService.writeBbs(bbs);
		return "redirect:/bbslist.do";
	}*/
}













