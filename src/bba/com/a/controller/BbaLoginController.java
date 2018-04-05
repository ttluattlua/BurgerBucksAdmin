package bba.com.a.controller;


import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bba.com.a.model.Bb_AdminDto;
import bba.com.a.service.BbaMemberSerivce;
import bba.com.a.service.BbaStoreSerivce;

@Controller
public class BbaLoginController {
	private static final Logger logger = LoggerFactory.getLogger(BbaLoginController.class);
	
	@Autowired
	BbaMemberSerivce bbMemberService;
	
	@Autowired
	BbaStoreSerivce bbaStoreService;
	
	
	/*--------------------------------------------------------------------------------------------
	 * 로그인 화면 (첫화면)
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(Model model) {
		logger.info("BbaMemberController login");
		return "login.tiles";
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 로그인후 메인
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="loginAf.do", method=RequestMethod.POST)
	public String loginAf(HttpServletRequest request, Model model, Bb_AdminDto adminDto) {
		logger.info("BbaMemberController login");
		
		System.out.println("로그인 시 id : " + adminDto.getId());
		System.out.println("로그인 시 password : " + adminDto.getPassword());
		
		HttpSession session = request.getSession();
		
		Bb_AdminDto admin = bbMemberService.loginAdminIdPw(adminDto);
		if(admin==null) {
			return "login.tiles";
		}else {
			session.setAttribute("loginedId", admin.getId()) ;
			session.setMaxInactiveInterval(60*60);
		    
			return "home.tiles";
		}
		
		
	}
	
	/*
 
    // 세션 생성
    session.setAttribute("name", id) ;
    session.setAttribute("addr", addr) ;
 
 
    // 세션 유지시간 설정(예 : 1시간)
    session.setMaxInactiveInterval(60*60)
 
    // 세션값 가져오기
    out.println(session.getAttribute("name");
    out.println(session.getAttribute("addr");
 
 
    // 세션값 삭제
    session.removeAttribute("addr")
 
 
    // 세션값 가져오기
    out.println(session.getAttribute("name");
 
    // 세션을 삭제했으므로 addr은 안나옴
    out.println(session.getAttribute("addr");
 
 
 
    // 세션 전체 무효화(로그아웃시 주로 사용)
    session.invalidate();*/


	
	

}













