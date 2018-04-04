package bba.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bba.com.a.service.BbaMenuService;

@Controller
public class BbaMenuController {
	private static final Logger logger = LoggerFactory.getLogger(BbaMenuController.class);

	@Autowired
	BbaMenuService bbaMenuService;
	
	
	/*--------------------------------------------------------------------------------------------
	 * 메뉴 관리 클릭했을때 menulist.jsp로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="menulist.do", method=RequestMethod.GET)
	public String menulist(Model model) {
		logger.info("BbaMenuController menulist.do");
		model.addAttribute("doc_title", "메뉴 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "menulist.tiles";
	}
}
