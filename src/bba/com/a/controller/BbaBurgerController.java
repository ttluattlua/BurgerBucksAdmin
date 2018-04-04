package bba.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bba.com.a.dao.BbaBurgerDao;

@Controller
public class BbaBurgerController {
	private static final Logger logger = LoggerFactory.getLogger(BbaBurgerController.class);

	@Autowired
	BbaBurgerDao bbaBurgerDao;
	
	/*--------------------------------------------------------------------------------------------
	 * 버거 관리 클릭했을때 burgerlist.jsp로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="burgerlist.do", method=RequestMethod.GET)
	public String burgerlist(Model model) {
		logger.info("BbaBurgerController burgerlist.do");
		model.addAttribute("doc_title", "버거 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "burgerlist.tiles";
	}

}
