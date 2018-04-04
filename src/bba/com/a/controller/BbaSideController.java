package bba.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bba.com.a.service.BbaSideService;

@Controller
public class BbaSideController {
	private static final Logger logger = LoggerFactory.getLogger(BbaSideController.class);

	@Autowired
	BbaSideService bbaSideService;
	
	
	/*--------------------------------------------------------------------------------------------
	 * 사이드 관리 클릭했을때 sidelist.jsp로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="sidelist.do", method=RequestMethod.GET)
	public String sidelist(Model model) {
		logger.info("BbaSideController sidelist.do");
		
		model.addAttribute("doc_title", "사이드 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "sidelist.tiles";
	}
}
