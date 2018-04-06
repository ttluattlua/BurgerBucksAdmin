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

import bba.com.a.arrow.StoreMapParcing;
import bba.com.a.model.Bb_AdminDto;
import bba.com.a.model.Bb_MemberDto;
import bba.com.a.model.Bb_StoreDto;
import bba.com.a.service.BbaMemberSerivce;
import bba.com.a.service.BbaStoreSerivce;

@Controller
public class BbaOrderController {
	private static final Logger logger = LoggerFactory.getLogger(BbaOrderController.class);
	
	@Autowired
	BbaMemberSerivce bbMemberService;
	
	@Autowired
	BbaStoreSerivce bbaStoreService;
	

	
	/*--------------------------------------------------------------------------------------------
	 * 사원등록으로 이동 
	 *-------------------------------------------------------------------------------------------*/
	@RequestMapping(value="orderlist.do", method=RequestMethod.GET)
	public String orderlist(Model model) {
		logger.info("BbaOrderController orderlist");
		

		List<Bb_StoreDto> bslist = bbaStoreService.GetStoreList();
		
		//위에 현재 위치 나타내줌 
		model.addAttribute("bslist", bslist);
		
		model.addAttribute("doc_title", "주문관리");
		model.addAttribute("doc_menu", "주문관리");
		
		return "orderlist.tiles";
	}
	
	
	
	
	
	

}













