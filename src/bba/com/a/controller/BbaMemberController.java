package bba.com.a.controller;

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
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(Model model) {
		logger.info("bbsMemberController login");
		return "home.tiles";
	}
	

}












