package bba.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bba.com.a.service.BbaIngredientService;


@Controller
public class BbaIngredientController {
	private static final Logger logger = LoggerFactory.getLogger(BbaIngredientController.class);

	@Autowired
	BbaIngredientService bbaIngredientService;
	
	
	/*--------------------------------------------------------------------------------------------
	 * 재료 관리 클릭했을때 ingredientlist.jsp로 이동
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="ingredientlist.do", method=RequestMethod.GET)
	public String ingredientlist(Model model) {
		logger.info("BbaIngredientController ingredientlist.do");
		
		model.addAttribute("doc_title", "재료 관리");
		model.addAttribute("doc_menu", "테이블 관리");
		return "ingredientlist.tiles";
	}
}
