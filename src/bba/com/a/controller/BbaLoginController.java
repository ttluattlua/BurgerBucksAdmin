package bba.com.a.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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
import bba.com.a.model.Bb_OrderStatisticDto;
import bba.com.a.service.BbaMemberSerivce;
import bba.com.a.service.BbaStatisticService;
import bba.com.a.service.BbaStoreSerivce;

@Controller
public class BbaLoginController {
	private static final Logger logger = LoggerFactory.getLogger(BbaLoginController.class);
	
	@Autowired
	BbaMemberSerivce bbMemberService;

	@Autowired
	BbaStatisticService bbaStatisticService;

	
	/*--------------------------------------------------------------------------------------------
	 * 로그인 화면 (첫화면)
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="login.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String login(HttpServletRequest request, Model model) {
		logger.info("BbaMemberController login");
		
		//세션 초기화
		HttpSession session = request.getSession();
		session.removeAttribute("login");
		
		return "login.tiles";
	}
	
	/*--------------------------------------------------------------------------------------------
	 * 로그인후 메인
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="loginAf.do", method=RequestMethod.POST)
	public String loginAf(HttpServletRequest request, HttpServletResponse response,  Model model, Bb_AdminDto adminDto) {
		logger.info("BbaMemberController login");
		
		
		
		int StoreCount = bbaStatisticService.getStoreCounts();
		int memCount = bbaStatisticService.getMemberCounts();
		int preProfit = bbaStatisticService.getPreviousMonthProfit();
		int preOrderCount = bbaStatisticService.getPreviousMonthOrderCounts();
		List<Bb_OrderStatisticDto> osList = bbaStatisticService.getOrderStatisticList();

		String osListStr="";
		for (int i = 0; i < osList.size(); i++) {
			if(i!=osList.size()-1) {
				osListStr += osList.get(i).toString()+",";
			}else {
				osListStr += osList.get(i).toString();
			}
		}
		System.out.println("osListStr"+osListStr);
		System.out.println("로그인 시 id : " + adminDto.getId());
		System.out.println("로그인 시 password : " + adminDto.getPassword());
		
		HttpSession session = request.getSession(true);

		//혜진 집  http://192.168.219.110:8191/upload/
		session.setAttribute("imagePath", "http://192.168.219.110:8191/upload/");

		
		//언니 여기다가 이미지 경로 좀 session에다 저장해 놓을게요 지우지말아주세용 ㅋㅋ
		//여기다 저장한 후에 컴퓨터 서버 바뀌면 여기만 수정해줄 수 있게 바꿔놓으려구용

	    /*// 요청 URI로 1depth path를 구한다.
		String reqUri = request.getRequestURI();
		String[] reqUris = reqUri.split("/");
		String firstPath = "";
		firstPath = reqUris[1];*/
		
		Bb_AdminDto admin = bbMemberService.loginAdminIdPw(adminDto);
		if(admin==null) {

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter out;
			try {
				
				//실패시 창 띄우기
				out = response.getWriter();
				out.println("<script>alert('아이디/ 비밀번호를 확인하세요.'); history.go(-1);</script>");
	            out.flush(); 
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "redirect:/login.do";
		}else {
			
			//세션 설정
			session.setAttribute("login", admin) ;
			session.setMaxInactiveInterval(60*60);
			
			model.addAttribute("StoreCount", StoreCount);
			model.addAttribute("memCount", memCount);
			model.addAttribute("preProfit", preProfit);
			model.addAttribute("preOrderCount", preOrderCount);
			model.addAttribute("osListStr", osListStr);
			model.addAttribute("msg", admin.getId()+" login 완료"); 
		    
			return "home.tiles";
		}
	}
	
	/*--------------------------------------------------------------------------------------------
	 * main 화면으로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="main.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String main(Model model) {
		logger.info("BbaMemberController login");
		

		int StoreCount = bbaStatisticService.getStoreCounts();
		int memCount = bbaStatisticService.getMemberCounts();
		int preProfit = bbaStatisticService.getPreviousMonthProfit();
		int preOrderCount = bbaStatisticService.getPreviousMonthOrderCounts();
		List<Bb_OrderStatisticDto> osList = bbaStatisticService.getOrderStatisticList();

		String osListStr="";
		for (int i = 0; i < osList.size(); i++) {
			if(i!=osList.size()-1) {
				osListStr += osList.get(i).toString()+",";
			}else {
				osListStr += osList.get(i).toString();
			}
		}
		model.addAttribute("StoreCount", StoreCount);
		model.addAttribute("memCount", memCount);
		model.addAttribute("preProfit", preProfit);
		model.addAttribute("preOrderCount", preOrderCount);
		model.addAttribute("osListStr", osListStr);
		return "home.tiles";
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













