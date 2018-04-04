package bba.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bba.com.a.service.BbaBeverageService;

@Controller
public class BbaBeverageController {
	private static final Logger logger = LoggerFactory.getLogger(BbaBeverageController.class);

	@Autowired
	BbaBeverageService bbaBeverageService;
	
	/*--------------------------------------------------------------------------------------------
	 * 음료 관리 클릭했을때 beveragelist.jsp로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="beveragelist.do", method=RequestMethod.GET)
	public String beveragelist(Model model) {
		logger.info("BbaBeverageController beveragelist.do");
		
		model.addAttribute("doc_title", "음료 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "beveragelist.tiles";
	}
}
